#!/usr/bin/env bash
#wait for kafka to come up
sleep 25s
sed -i 's/FIREFOX_LOG_FILE/'"$FIREFOX_LOG_FILE"'/g' /usr/share/logstash/bin/config/firefox_logstasher.conf
sed -i 's/FIREFOX_TOPIC/'"$FIREFOX_TOPIC"'/g' /usr/share/logstash/bin/config/firefox_logstasher.conf
sed -i 's/KAFKA_HOST/'"$KAFKA_HOST"'/g' /usr/share/logstash/bin/config/firefox_logstasher.conf
sed -i 's/KAFKA_PORT/'"$KAFKA_PORT"'/g' /usr/share/logstash/bin/config/firefox_logstasher.conf

logstash -f /usr/share/logstash/bin/config/firefox_logstasher.conf --config.reload.automatic &
wait
