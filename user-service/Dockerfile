FROM openjdk:8-jdk-alpine

MAINTAINER Ramazan Sakin <ramazansakin63@gmail.com>
ADD target/*.jar user-service-app.jar

ENTRYPOINT ["java","-jar","/user-service-app.jar"]