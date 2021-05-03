# Kafka Launcher
[![Build Status](https://github.com/evolution-gaming/kafka-launcher/workflows/CI/badge.svg)](https://github.com/evolution-gaming/kafka-launcher/actions?query=workflow%3ACI)
[![Coverage Status](https://coveralls.io/repos/github/evolution-gaming/kafka-launcher/badge.svg?branch=master)](https://coveralls.io/github/evolution-gaming/kafka-launcher?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/493799c12bb24cb39fe708c601a285fd)](https://www.codacy.com/app/evolution-gaming/kafka-launcher?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=evolution-gaming/kafka-launcher&amp;utm_campaign=Badge_Grade)
[![Version](https://img.shields.io/badge/version-click-blue)](https://evolution.jfrog.io/artifactory/api/search/latestVersion?g=com.evolutiongaming&a=kafka-launcher_2.13&repos=public)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellowgreen.svg)](https://opensource.org/licenses/MIT)

## How to use

```scala
val shutdown = StartKafka() // starts server
shutdown() // shuts down server
```

## Setup

```scala
addSbtPlugin("com.evolution" % "sbt-artifactory-plugin" % "0.0.2")

libraryDependencies += "com.evolutiongaming" %% "kafka-launcher" % "0.0.9"
```