package com.cicd_spark

import org.apache.spark.sql.SparkSession


class SuperSpark {

  val spark = SparkSession
    .builder()
    .appName("SparkJenkins")
    .master("local[*]")
    .getOrCreate()
  spark.sparkContext.setLogLevel("DEBUG")

  val avroHelper = new AvroHelper(spark)

  def getSparkSession(): SparkSession = spark

  def stopSparkSession(): Unit = spark.stop();
}
