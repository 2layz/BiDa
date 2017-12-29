FROM openjdk:8u151-jdk-alpine
ADD target/kafka-consumer-1.0-SNAPSHOT-jar-with-dependencies.jar /opt/kafka-consumer.jar
ENTRYPOINT ["java","-jar","/opt/kafka-consumer.jar", ">", "/tmp/logs"]
