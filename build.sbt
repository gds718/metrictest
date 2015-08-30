name := "metric"

version := "1.0"

scalaVersion := "2.10.5"

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.akka" %% "akka-cluster" % "2.3.11"
