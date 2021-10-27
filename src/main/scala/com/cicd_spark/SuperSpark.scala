package com.cicd_spark

import org.apache.spark.sql.SparkSession


class SuperSpark {

  val spark = SparkSession
    .builder()
    .appName("SparkJenkins")
    .master("local[*]")
    .config("spark.sql.session.timeZone", "UTC")
    //.getOrCreate()
  spark.sparkContext.setLogLevel("WARN")

  val avroHelper = new AvroHelper(spark)

  def getSparkSession(): SparkSession = spark

  def stopSparkSession(): Unit = spark.stop();
}
