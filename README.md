# Kafka Launcher [![Build Status](https://travis-ci.org/evolution-gaming/kafka-launcher.svg)](https://travis-ci.org/evolution-gaming/kafka-launcher) [![Coverage Status](https://coveralls.io/repos/evolution-gaming/kafka-launcher/badge.svg)](https://coveralls.io/r/evolution-gaming/kafka-launcher) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/493799c12bb24cb39fe708c601a285fd)](https://www.codacy.com/app/evolution-gaming/kafka-launcher?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=evolution-gaming/kafka-launcher&amp;utm_campaign=Badge_Grade) [ ![version](https://api.bintray.com/packages/evolutiongaming/maven/kafka-launcher/images/download.svg) ](https://bintray.com/evolutiongaming/maven/kafka-launcher/_latestVersion) [![License: MIT](https://img.shields.io/badge/License-MIT-yellowgreen.svg)](https://opensource.org/licenses/MIT)

## How to use

```scala
val shutdown = StartKafka() // starts server
shutdown() // shuts down server
```

## Setup

```scala
resolvers += Resolver.bintrayRepo("evolutiongaming", "maven")

libraryDependencies += "com.evolutiongaming" %% "kafka-launcher" % "0.0.9"
```