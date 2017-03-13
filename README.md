<h1 align="center">
<img src="https://raw.githubusercontent.com/Renien/ETL/master/doc/blob/ELT.png" alt="ETL" width="20%" height="20%">
    <br>
        ETL
    <br>
  <h4 align="center">Extract - Transform - Load</h4>
</h1>

<p align="center">
       <a href="https://travis-ci.org/Renien/ETL">
           <img src="https://travis-ci.org/Renien/ETL.svg?branch=master"
                alt="Travis Build">
       </a>
       <a href="">
           <img src="https://img.shields.io/npm/l/express.svg?maxAge=2592000&style=flat-square"
                alt="License">
         </a>
    </p>

## Summary

Extract, Transform, Load (ETL) refers to a process in database usage and especially in data warehousing. This repository contains a starter kit featuring ETL related work.

## Directory Layout

```
.
├── Common                                                        --> common module which can contain helper class
│   ├── build.gradle                                              --> build script for common module specific
│   └── src                                                       --> source package directory for common module
│       └── main
│           ├── java
│           ├── resources
│           └── scala
│               └── com
│                   └── etl
│                       └── utils
│                           ├── HadoopRunner.scala
│                           └── MapReduceConfig.scala
├── DataModel                                                     --> schema level module (eg: avro, thrift, json etc)
│   ├── build.gradle                                              --> build script for datamodel module specific
│   ├── schema                                                    --> data schema files
│   │   └── com
│   │       └── etl
│   │           └── datamodel
│   │               └── ClickStreamRecord.avsc                    --> click stream record avro schema
│   ├── src                                                       --> source package directory for datamodel module
│   │   └── main
│   │       ├── java
│   │       ├── resources
│   │       └── scala
│   └── target                                                    --> auto generated code (eg from avro, thrift etc)
│       └── generated-sources
│           └── main
│               └── java
│                   └── com
│                       └── etl
│                           └── datamodel
│                               └── ClickStreamRecord.java        --> auto generated code from click stream record avro schema
├── SampleClient                                                  --> sperate module for client specific ETL jobs
│   ├── build.gradle                                              --> build script for client specific module
│   ├── src                                                       --> source package directory for client specific module
│   │   └── main
│   │       ├── java
│   │       ├── resources
│   │       └── scala
│   │           └── com
│   │               └── sampleclient
│   │                   └── jobs
│   │                       └── ClickStreamAggregates.scala       --> clickstream aggregates jobs
│   └── workflow                                                  --> hadoop job flow groovy script folder
│       ├── flow.gradle                                           --> gradle script to generate haoop job flows (eg: Azkaban)
│       └── jobs.gradle                                           --> gradle script for haoop jobs (eg: Azkaban)
├── build.gradle                                                  --> build script for root module
├── gradle                                                        --> gradle folder which contains all the build script files
│   ├── artifacts.gradle                                          --> artifact file for ETL project
│   ├── buildscript.gradle                                        --> groovy script contains plugins, task classes, and other classes are available for project
│   ├── dependencies.gradle                                       --> dependencies for the ETL project
│   ├── enviroments.groovy                                        --> configuration for prod and dev enviroment
│   ├── repositories.gradle                                       --> all the dependencies repository location
│   └── workflows.gradle                                          --> root workflow gradle file contain configuration and custom build task
├── gradlew
├── gradlew.bat
├── settings.gradle                                               --> setting sub modules

```