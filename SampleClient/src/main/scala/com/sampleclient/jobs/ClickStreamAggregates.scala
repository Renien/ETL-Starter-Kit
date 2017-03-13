package com.sampleclient.jobs

import com.etl.utils.DynamicQueueAllocationConfig
import com.twitter.scalding.{Args, Job}

class ClickStreamAggregates(args: Args) extends Job(args) with DynamicQueueAllocationConfig {

  //implementation to read the avro data
}