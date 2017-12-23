#!/bin/bash

sed -i 's/LISTENER_HOST_NAME/'"$LISTENER_HOST_NAME"'/g' /opt/kafka_2.12-1.0.0/config/server.properties
sed -i 's/LISTENER_PORT/'"$LISTENER_PORT"'/g' /opt/kafka_2.12-1.0.0/config/server.properties 
sed -i 's/ZOOKEEPER_HOST_NAME/'"$ZOOKEEPER_HOST_NAME"'/g' /opt/kafka_2.12-1.0.0/config/server.properties 

sleep 15s

if [[ -z $BROKER_ID ]]
then
	sed -i 's/BROKER_ID/'"$HOSTNAME| awk -F'-' '{print $2}'"'/g' /opt/kafka_2.12-1.0.0/config/server.properties 
else
	sed -i 's/BROKER_ID/'"$BROKER_ID"'/g' /opt/kafka_2.12-1.0.0/config/server.properties 
fi

/opt/kafka_2.12-1.0.0/bin/createTopics.sh &

/opt/kafka_2.12-1.0.0/bin/kafka-server-start.sh /opt/kafka_2.12-1.0.0/config/server.properties &
wait
