package com.cicd_spark

import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.{BeforeEach, Test}

class AvroHelperTest {
  var spark: SparkSession = null
  var ss: SuperSpark = null
  var helper: AvroHelper = null

  @BeforeEach
  def init(): Unit = {
    import org.apache.hadoop.security.UserGroupInformation
    UserGroupInformation.setLoginUser(UserGroupInformation.createRemoteUser("tsyhanau"))
    val ss = new SuperSpark
    spark = ss.getSparkSession
    helper = new AvroHelper(spark)
  }

  @Test
  def checkNullCheckInWasSkipped(): Unit = {
    assertTrue(helper.countAdultsByCheckin(getTestExpediaDf())
      .count() == 1)
  }

  @Test
  def checkCountIsCorrect(): Unit = {
    assertTrue(helper.countAdultsByCheckin(getTestExpediaDf())
      .select(col("total_adults_cnt")).collect()(0).get(0) == 101
    )
  }

  def getTestExpediaDf(): DataFrame = {
    val arrayStructureData = Seq(
      Row(1, 1, "01-01-2021"),
      Row(1, 100, "01-01-2021"),
      Row(1, 999, null)
    )

    def getExpediaSchema(): StructType =
      new StructType(Array(
        StructField("hotel_id", IntegerType, nullable = true),
        StructField("srch_adults_cnt", IntegerType, nullable = true),
        StructField("srch_ci", StringType, nullable = true)
      ))

    spark.createDataFrame(
      spark.sparkContext.parallelize(arrayStructureData), getExpediaSchema)
  }
}
