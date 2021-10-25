package com.cicd_spark

import org.apache.spark.sql.functions.{col, sum}
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, SparkSession}

class AvroHelper(spark: SparkSession) {

  def countAdultsByCheckin(expediaDf: DataFrame): DataFrame =
    expediaDf.filter(col("srch_ci").isNotNull)
      .select("hotel_id", "srch_adults_cnt", "srch_ci")
      .groupBy("srch_ci")
      .agg(sum("srch_adults_cnt").as("total_adults_cnt"))
      .orderBy("srch_ci")

  def getBatchesFromAvro(spark: SparkSession, pathToSource: String): DataFrame =
    spark.read
      .format("avro")
      .schema(getExpediaSchema)
      .load(getClass.getResource(pathToSource).getPath)

  def getExpediaSchema(): StructType =
    new StructType(Array(
      StructField("date_time", StringType, nullable = true),
      StructField("site_name", IntegerType, nullable = true),
      StructField("posa_continent", IntegerType, nullable = true),
      StructField("user_location_country", IntegerType, nullable = true),
      StructField("user_location_region", IntegerType, nullable = true),
      StructField("user_location_city", IntegerType, nullable = true),
      StructField("orig_destination_distance", DoubleType, nullable = true),
      StructField("is_mobile", IntegerType, nullable = true),
      StructField("is_package", IntegerType, nullable = true),
      StructField("channel", IntegerType, nullable = true),
      StructField("srch_ci", StringType, nullable = true),
      StructField("srch_co", StringType, nullable = true),
      StructField("srch_adults_cnt", IntegerType, nullable = true),
      StructField("srch_children_cnt", IntegerType, nullable = true),
      StructField("srch_rm_cnt", IntegerType, nullable = true),
      StructField("srch_destination_id", IntegerType, nullable = true),
      StructField("srch_destination_type_id", IntegerType, nullable = true),
      StructField("hotel_id", LongType, nullable = true)
    ))
}
