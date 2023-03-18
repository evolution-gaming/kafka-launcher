name := "kafka-launcher"

organization := "com.evolutiongaming"

homepage := Some(new URL("http://github.com/evolution-gaming/kafka-launcher"))

startYear := Some(2018)

organizationName := "Evolution"

organizationHomepage := Some(url("http://evolution.com"))

scalaVersion := crossScalaVersions.value.head

crossScalaVersions := Seq("2.13.8", "2.12.15")

Test / classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.ScalaLibrary

Compile / doc / scalacOptions ++= Seq("-groups", "-implicits", "-no-link-warnings")

publishTo := Some(Resolver.evolutionReleases)

libraryDependencies ++= Seq(
  "org.apache.kafka"    %% "kafka"     % "3.4.0",
  "com.evolutiongaming" %% "tmp-dir"   % "0.0.5",
  "org.slf4j"            % "slf4j-api" % "2.0.7",
  "org.scalatest"       %% "scalatest" % "3.2.12" % Test)

licenses := Seq(("MIT", url("https://opensource.org/licenses/MIT")))

releaseCrossBuild := true

scalacOptsFailOnWarn := Some(false)

ThisBuild / versionScheme := Some("early-semver")