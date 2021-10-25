package com.cicd_spark

import org.apache.spark.sql.SparkSession


class SuperSpark {

  val spark = SparkSession
    .builder()
    .appName("SparkStreaming")
    .master("local[*]")
    .config("spark.sql.session.timeZone", "UTC")
    .config("spark.executor.heartbeatInterval", "30s")
    .config("spark.driver.maxResultSize", "10G")
    .config("spark.executor.memory", "25G")
    .config("spark.driver.memory", "20g")
    .config("spark.memory.offHeap.enabled", true)
    .config("spark.memory.offHeap.size", "15g")
    .config("spark.sql.shuffle.partitions", "1")
    .config("spark.sql.debug.maxToStringFields", "1000")
    .config("spark.sql.streaming.statefulOperator.checkCorrectness.enabled", false)
    .config("spark.sql.streaming.multipleWatermarkPolicy", "max")
    .getOrCreate()
  spark.sparkContext.setLogLevel("WARN")

  val avroHelper = new AvroHelper(spark)

  def getSparkSession(): SparkSession = spark

  def stopSparkSession(): Unit = spark.stop();
}
