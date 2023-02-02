FROM openjdk:17-jdk-slim

MAINTAINER Zeynel Acar
EXPOSE 8086
ADD target/messagingclient-0.0.1-SNAPSHOT.jar messagingclient.jar

ENTRYPOINT ["java","-jar","messagingclient.jar"]