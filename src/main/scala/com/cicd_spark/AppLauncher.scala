package com.cicd_spark

import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.functions.{col, sum}

object AppLauncher extends SuperSpark {

  def main(args: Array[String]): Unit = {

    val expediaDf = avroHelper.getBatchesFromAvro(spark, "/totalAdultsCountByCheckIn")


    val totalAdultsCountByCheckIn = avroHelper.countAdultsByCheckin(expediaDf)


    totalAdultsCountByCheckIn
      .write
      .format("avro")
      .mode(SaveMode.Overwrite)
      .save("totalAdultsCountByCheckIn")
  }
}
