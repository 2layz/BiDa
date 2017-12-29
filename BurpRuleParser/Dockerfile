FROM openjdk:8u151-jdk-alpine
ADD target/ruleparser-1.0-SNAPSHOT-jar-with-dependencies.jar /opt/rules-parser.jar
ENTRYPOINT ["java","-jar","/opt/rules-parser.jar", ">", "/tmp/logs"]
