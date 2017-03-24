package com.scala.xml
import org.apache.spark.sql.SQLContext
import org.apache.spark.{ SparkConf, SparkContext }
import org.apache.log4j._

object XmlDemo {

  Logger.getLogger("org").setLevel(Level.ERROR)
  def main(args: Array[String]) = {

    val conf = new SparkConf()
      .setAppName("ProcessXML")
      .setMaster("local")
      // Error is throw if below is not set
      //java.net.URISyntaxException: Relative path in absolute URI: file:C:/brijesh/code/scala/scala_wrksp/Test/spark-warehouse
      .set("spark.sql.warehouse.dir", "/spark-warehouse/");

    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)
    val df = sqlContext.read
      .format("com.databricks.spark.xml")
      .option("rowTag", "book")
      .load("books.xml")

    val selectedData = df.select("author", "_id")
    selectedData.write
      .format("com.databricks.spark.xml")
      .option("rootTag", "books")
      .option("rowTag", "book")
      .save("newbooks")
   
      println("Check newbooks folder!!")
      
  }

}