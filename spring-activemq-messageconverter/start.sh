#!/usr/bin/env bash

cd ./spring-activemq-producer && mvn clean package
cd ..
cd ./spring-activemq-consumer && mvn clean package
cd ..
docker-compose up -d && docker-compose logs -f