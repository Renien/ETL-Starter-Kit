package com.etl.utils

import com.twitter.scalding.{Job}

/**
  * Created by renienj on 3/12/17.
  */
trait MapReduceConfig extends Job {
  import MapReduceConfig.ConfigArguments._

  def defaultQueue: String = "default"
  def defaultReducers: Int = 5
  def defaultMaxConcurrentSteps: Int = 100
  def defaultTimeout: Int = 600000 // 10 Minutes
  def defaultCompressMapOutput: String = "true"

  implicit val jobArgs = args

  //Default config for the hadoop jobs
  override def config: Map[AnyRef, AnyRef] = {
    super.config ++ Map(
      "mapreduce.job.queuename" -> args.getOrElse(queue, defaultQueue),
      "mapreduce.job.reduces" -> args.getOrElse(reducers, defaultReducers.toString),
      "mapreduce.map.output.compress" -> args.getOrElse(compressMapOutput, defaultCompressMapOutput),
      "mapreduce.map.output.compress.codec" -> "org.apache.hadoop.io.compress.SnappyCodec",
      "mapreduce.reduce.input.limit" -> "-1",
      "mapreduce.task.timeout" -> defaultTimeout.toString,
      "mapred.child.java.opts" -> "-Xmx3072m",
      "mapreduce.map.java.opts" -> "-Xmx3072m",
      "cascading.flow.maxconcurrentsteps" -> defaultMaxConcurrentSteps.toString,
      "cascading.spill.threshold" -> "50000000",
      "cascading.spill.map.threshold" -> "500000",
      "cascading.aggregateby.threshold" -> "500000",
      "cascading.spill.list.threshold" -> "1000000",
      "cascading.cogroup.spill.threshold" -> "500000",
      "cascading.app.appjar.class" -> getClass
    )
  }
}

object MapReduceConfig {
  def spillThreshold: Int = 1000000
  object ConfigArguments {
    val queue = "queue"
    val reducers = "reducers"
    val compressMapOutput = "compressMapOutput"
    val mapReduceFramework = "mapReduceFramework"
  }
}

trait SingleFailureConfig extends Job {
  override def config: Map[AnyRef, AnyRef] = {
    super.config ++ Map(
      "mapreduce.map.maxattempts" -> "1",
      "mapreduce.reduce.maxattempts" -> "1"
    )
  }
}

//Hadoop queue allocation
trait DynamicQueueAllocationConfig extends MapReduceConfig {
  override def defaultQueue: String = {
    mode match {
      case _ => super.defaultQueue
    }

  }
}