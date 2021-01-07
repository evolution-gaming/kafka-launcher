name := "kafka-launcher"

organization := "com.evolutiongaming"

homepage := Some(new URL("http://github.com/evolution-gaming/kafka-launcher"))

startYear := Some(2018)

organizationName := "Evolution Gaming"

organizationHomepage := Some(url("http://evolutiongaming.com"))

bintrayOrganization := Some("evolutiongaming")

scalaVersion := crossScalaVersions.value.head

crossScalaVersions := Seq("2.13.3", "2.12.10")

Test / classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.ScalaLibrary

scalacOptions in(Compile, doc) ++= Seq("-groups", "-implicits", "-no-link-warnings")

resolvers += Resolver.bintrayRepo("evolutiongaming", "maven")

libraryDependencies ++= Seq(
  "org.apache.kafka"    %% "kafka"     % "2.6.1",
  "com.evolutiongaming" %% "tmp-dir"   % "0.0.5",
  "org.slf4j"            % "slf4j-api" % "1.7.30",
  "org.scalatest"       %% "scalatest" % "3.2.3" % Test)

licenses := Seq(("MIT", url("https://opensource.org/licenses/MIT")))

releaseCrossBuild := true

scalacOptsFailOnWarn := Some(false)