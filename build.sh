#!/bin/sh
mvn clean
mvn package
./pushToCloudServer.sh
