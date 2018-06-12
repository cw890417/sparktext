package com.spark.text.chap01

import org.apache.spark.Partitioner

class CustomPartitioner(partitions: Int) extends Partitioner {
  def numPartitions = partitions

  def getPartition(key: Any) = key match {
    case (k: String, v: Int) => math.abs(k.hashCode % numPartitions)
    case null => 0
    case _ => math.abs(key.hashCode() % numPartitions)
  }

  override def equals(other: Any): Boolean = other match {
    case h: CustomPartitioner => h.numPartitions == numPartitions
    case _ => false
  }

  override def hashCode(): Int = numPartitions
  
}
