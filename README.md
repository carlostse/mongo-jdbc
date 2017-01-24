Mongo JDBC Driver
===========

A JDBC driver for MongoDB.

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
- [ ] upgrade Mongo Java Driver to 3.x

## Platform

### Java

This project targets to support Java 8. Some additional JDBC functions were added since Java 7,
thus which may cause errors where compiling using Java 6 or below, and it is not supported in this project.

### Build

```
$ mvn package -Dmaven.test.skip=true
```

Or, if you have a testing MongoDB instance running on localhost and listening to port 27017, you can
```
$ mvn package
```

## License
Apache License, Version 2.0