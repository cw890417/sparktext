package com.spark.text

import org.apache.spark.{SparkConf, SparkContext}

object SparkRdd {
  //
  implicit def float2tnt(x: Float): Int = x.toInt

  def main(args: Array[String]): Unit = {
    //    val conf = new SparkConf().setAppName("first").setMaster("local")
    //    val sc = new SparkContext(conf)
    //    val count = sc.longAccumulator("name")
    //    val data = Array(1, 2, 3, 4, 5)
    //    val distData = sc.parallelize(data).foreach(x => count.add(x))
    //    sc.parallelize(data).take(10)
    //    println(count.value)
    //      distData.persist()
    //      distData.cache()
    //      distData.reduce(_ + _)
    //    sc.stop()

    //    for (i <- 1 to 5) println(i)
    val a : Int = 2.55f
  }
}
