name := "kafka-launcher"

organization := "com.evolutiongaming"

homepage := Some(new URL("http://github.com/evolution-gaming/kafka-launcher"))

startYear := Some(2018)

organizationName := "Evolution Gaming"

organizationHomepage := Some(url("http://evolutiongaming.com"))

bintrayOrganization := Some("evolutiongaming")

scalaVersion := crossScalaVersions.value.head

crossScalaVersions := Seq(/*"2.13.0", https://github.com/apache/kafka/pull/6989*/"2.12.9")

scalacOptions in(Compile, doc) ++= Seq("-groups", "-implicits", "-no-link-warnings")

resolvers += Resolver.bintrayRepo("evolutiongaming", "maven")

libraryDependencies ++= Seq(
  "org.apache.kafka"    %% "kafka"     % "2.3.0",
  "com.evolutiongaming" %% "tmp-dir"   % "0.0.4",
  "org.slf4j"            % "slf4j-api" % "1.7.28",
  "org.scalatest"       %% "scalatest" % "3.0.8" % Test)

licenses := Seq(("MIT", url("https://opensource.org/licenses/MIT")))

releaseCrossBuild := true