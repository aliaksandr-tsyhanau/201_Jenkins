name := "201_Jenkins"

version := "0.1"

scalaVersion := "2.11.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.5"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.5"

// https://mvnrepository.com/artifact/org.apache.spark/spark-avro
libraryDependencies += "org.apache.spark" %% "spark-avro" % "2.4.5"

lazy val root = project

resolvers in ThisBuild += Resolver.jcenterRepo

libraryDependencies += "org.junit.jupiter" % "junit-jupiter-api" % "5.6.2" % Test
libraryDependencies += "org.junit.jupiter" % "junit-jupiter-engine" % "5.6.2" % Test
libraryDependencies += "net.aichler" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test

Compile / mainClass := Some("com.cicd_spark.AppLauncher.scala")
assembly / mainClass := Some("com.cicd_spark.AppLauncher.scala")

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}




