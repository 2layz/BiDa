FROM openjdk:8u151-jdk-alpine
ADD target/lib/ /opt/lib/
ADD target/ruleparser-1.0-SNAPSHOT.jar /opt/lib/rules-parser.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo/rules","-cp","/opt/lib/*","com.devx.rule.parser.RuleChangeListenerApp", ">", "/tmp/logs"]
