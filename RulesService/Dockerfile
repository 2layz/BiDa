FROM openjdk:8-alpine

ADD target/RulesService-0.0.1-SNAPSHOT.jar /RulesService.jar

EXPOSE 8080

ENTRYPOINT [ "java","-Dspring.data.mongodb.uri=mongodb://mongo/rules","-jar", "/RulesService.jar"]
