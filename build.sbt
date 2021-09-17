name := "kafka-launcher"

organization := "com.evolutiongaming"

homepage := Some(new URL("http://github.com/evolution-gaming/kafka-launcher"))

startYear := Some(2018)

organizationName := "Evolution"

organizationHomepage := Some(url("http://evolution.com"))

scalaVersion := crossScalaVersions.value.head

crossScalaVersions := Seq("2.13.6", "2.12.14")

Test / classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.ScalaLibrary

Compile / doc / scalacOptions ++= Seq("-groups", "-implicits", "-no-link-warnings")

publishTo := Some(Resolver.evolutionReleases)

libraryDependencies ++= Seq(
  "org.apache.kafka"    %% "kafka"     % "2.8.1",
  "com.evolutiongaming" %% "tmp-dir"   % "0.0.5",
  "org.slf4j"            % "slf4j-api" % "1.7.32",
  "org.scalatest"       %% "scalatest" % "3.2.9" % Test)

licenses := Seq(("MIT", url("https://opensource.org/licenses/MIT")))

releaseCrossBuild := true

scalacOptsFailOnWarn := Some(false)

ThisBuild / versionScheme := Some("early-semver")