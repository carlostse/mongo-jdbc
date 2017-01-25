Mongo JDBC Driver
===========

JDBC driver for MongoDB. A wrapper translates SQL to official MongoDB Java API calls.

This is a fork of http://github.com/erh/mongo-jdbc, and merged some changes from:
- https://github.com/davemc/mongo-jdbc
- https://github.com/ccdaisy/mongo-jdbc

__EXPERIMENTAL__

This project targets to support some simple SQL only, and has no plans to support join tables.

## Scenario

A traditional JDBC application needs to read data stored in MongoDB. Instead of maintaining two copies of data,
a JDBC driver has been made. The JDBC application can use the traditional SQL to access the MongoDB without modifications.

## Project Scope

JDBC Connection
- [x] support connection to a ReplicaSet
- [ ] support connection to a Sharded Cluster

Query Types
- [x] support __SELECT__ on single table
- [x] support __WHERE__
- [x] support __ORDER BY__ and __LIMIT__
- [x] upgrade [Java MongoDB Driver](https://docs.mongodb.com/ecosystem/drivers/java/) to latest version (3.4.1)
- [x] support MongoDB replica set
- [ ] replace deprecated Java MongoDB Driver APIs

## Quick Start

1. Import the `pom.xml` in [IntelliJ IDEA](https://www.jetbrains.com/idea/)
2. Right click __examples__ and select __Mark Directory as__, __Sources Root__
4. Right click `HelloWorld` and select __Run HelloWorld.main()__

## Platform

### Java

This project targets to support Java 8. Some additional JDBC functions were added since Java 7,
thus which may cause errors where compiling using Java 6 or below, and it is not supported in this project.

### Build JDBC JAR

```
$ mvn package -Dmaven.test.skip=true
```

Or, if you have a testing MongoDB instance running on localhost and listening to port 27017, you can
```
$ mvn package
```

## License
Apache License, Version 2.0