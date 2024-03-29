package com.evolutiongaming.kafka

import java.net.InetSocketAddress

import com.evolutiongaming.tmpdir.TmpDir
import kafka.server.{KafkaConfig, KafkaServer}
import org.apache.kafka.common.security.auth.SecurityProtocol
import org.apache.zookeeper.server.{ServerCnxnFactory, SetShutdownHandler, ZooKeeperServer}

import scala.jdk.CollectionConverters._

object StartKafka {

  type Shutdown = () => Unit

  object Shutdown {
    val Empty: Shutdown = () => ()
  }

  def apply(
    kafkaAddress: Address = Address.Kafka,
    zkAddress: Address = Address.ZooKeeper,
    overrides: Map[String, String] = Map.empty): Shutdown = {

    val shutdownZk = zooKeeperServer(zkAddress)
    val shutdownKafka = kafkaServer(kafkaAddress = kafkaAddress, zkAddress = zkAddress, overrides = overrides)

    () => {
      shutdownKafka()
      shutdownZk()
    }
  }

  private def zooKeeperServer(address: Address) = {
    val tmpDir = TmpDir("zookeeper-", deleteOnExit = false)
    val inetAddress = new InetSocketAddress(address.host, address.port)
    val file = tmpDir.path.toAbsolutePath.toFile
    val server = new ZooKeeperServer(file, file, ZooKeeperServer.DEFAULT_TICK_TIME)
    SetShutdownHandler(server)
    val factory = ServerCnxnFactory.createFactory
    factory.configure(inetAddress, 1024)
    factory.startup(server)
    () => {
      factory.shutdown()
      tmpDir.delete()
    }
  }

  private def kafkaServer(
    kafkaAddress: Address,
    zkAddress: Address,
    overrides: Map[String, String]) = {

    val listener = s"${ SecurityProtocol.PLAINTEXT }://$kafkaAddress"
    val tmpDir = TmpDir("kafka-", deleteOnExit = false)
    val defaults = Map[String, String](
      (KafkaConfig.ZkConnectProp, zkAddress.toString),
      (KafkaConfig.BrokerIdProp, 0.toString),
      (KafkaConfig.ListenersProp, listener),
      (KafkaConfig.AdvertisedListenersProp, listener),
      (KafkaConfig.AutoCreateTopicsEnableProp, true.toString),
      (KafkaConfig.LogDirProp, tmpDir.path.toAbsolutePath.toString),
      (KafkaConfig.LogFlushIntervalMessagesProp, 1.toString),
      (KafkaConfig.OffsetsTopicReplicationFactorProp, 1.toString),
      (KafkaConfig.OffsetsTopicPartitionsProp, 1.toString),
      (KafkaConfig.TransactionsTopicReplicationFactorProp, 1.toString),
      (KafkaConfig.TransactionsTopicMinISRProp, 1.toString),
      (KafkaConfig.LogCleanerDedupeBufferSizeProp, (10 * 1024L * 1024).toString),
      (KafkaConfig.GroupInitialRebalanceDelayMsProp, 0.toString),
      (KafkaConfig.ZkSessionTimeoutMsProp, 10000.toString))

    val props = defaults ++ overrides
    val config = new KafkaConfig(props.asJava)
    val server = new KafkaServer(config)
    server.startup()

    () => {
      server.shutdown()
      server.awaitShutdown()
      tmpDir.delete()
    }
  }


  final case class Address(host: String = "localhost", port: Int) {
    override def toString: String = s"$host:$port"
  }

  object Address {
    val Kafka: Address = Address(port = 9092)
    val ZooKeeper: Address = Address(port = 2181)
  }
}