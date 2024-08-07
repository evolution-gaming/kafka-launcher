name := "kafka-launcher"

organization := "com.evolutiongaming"

homepage := Some(url("https://github.com/evolution-gaming/kafka-launcher"))

startYear := Some(2018)

organizationName := "Evolution"

organizationHomepage := Some(url("https://evolution.com"))

scalaVersion := crossScalaVersions.value.head

crossScalaVersions := Seq("2.13.12", "2.12.18", "3.3.1")

Test / classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.ScalaLibrary

Compile / doc / scalacOptions ++= Seq("-groups", "-implicits", "-no-link-warnings")

publishTo := Some(Resolver.evolutionReleases)

libraryDependencies ++= Seq(
  "org.apache.kafka"    %% "kafka"     % "3.4.0" cross CrossVersion.for3Use2_13,
  "com.evolutiongaming" %% "tmp-dir"   % "0.0.6",
  "org.slf4j"            % "slf4j-api" % "1.7.36",
  "org.scalatest"       %% "scalatest" % "3.2.12" % Test)

licenses := Seq(("MIT", url("https://opensource.org/licenses/MIT")))

releaseCrossBuild := true

scalacOptsFailOnWarn := Some(false)

ThisBuild / versionScheme := Some("early-semver")

//addCommandAlias("check", "all versionPolicyCheck Compile/doc")
addCommandAlias("check", "show version")
addCommandAlias("build", "+all compile test")
