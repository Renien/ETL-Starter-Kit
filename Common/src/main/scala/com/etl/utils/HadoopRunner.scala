package com.etl.utils

import java.util.Properties

import com.twitter.scalding.{RichXHandler, Tool}
import org.apache.hadoop

/**
  * Created by renienj on 3/12/17.
  */
class HadoopRunner(job: String, prop: Properties) {

  def run() {
    val args = prop.get("main.args").asInstanceOf[String]
    require(args != null, "unable to get main.args")
    try {
      hadoop.util.ToolRunner.run(new hadoop.conf.Configuration, new Tool, args.split(" "))
    } catch {
      case t: Throwable => {
        //create the exception URL link in GitHub wiki
        val gitHubLink = RichXHandler.createXUrl(t)
        val extraInfo = (if (RichXHandler().handlers.exists(h => h(t))) {
          RichXHandler.mapping(t.getClass) + "\n"
        }
        else {
          ""
        }) +
          "If you know what exactly caused this error, please consider contributing to GitHub via following link.\n" + gitHubLink

        //re-throw the exception with extra info
        throw new Throwable(extraInfo, t)
      }
    }
  }
}
