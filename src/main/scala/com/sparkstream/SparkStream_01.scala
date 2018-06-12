package com.sparkstream

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * 通过在终端使用 nc -lk 9999
  * 监听9999端口输入的数据，进行单词计数
  */
object SparkStream_01 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("SparkStream_01")
    val ssc = new StreamingContext(conf, Seconds(10))

    //监听本地的9999端口
    //    val lines: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)

    //统计实时上传到hdfs到文件单词数
    val lines = ssc.textFileStream("hdfs://localhost:9000/input")

    //统计单词数
    val wordCounts = lines.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)

    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
