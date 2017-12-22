FROM anapsix/alpine-java
MAINTAINER vivek

ADD kafka_2.12-1.0.0 /opt/kafka_2.12-1.0.0
ADD startKafka.sh /opt/kafka_2.12-1.0.0/bin/startKafka.sh
ADD createTopics.sh /opt/kafka_2.12-1.0.0/bin/createTopics.sh

WORKDIR /opt/kafka_2.12-1.0.0/bin/
RUN chmod +x -R *.sh

EXPOSE 9092

CMD ["/opt/kafka_2.12-1.0.0/bin/startKafka.sh"]
