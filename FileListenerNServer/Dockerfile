FROM scratch
ADD ./target/fileWatcher /opt/fileWatcher
EXPOSE 8080
LABEL io.cadvisor.metric.prometheus=/etc/custom-metrics/definition.json
ENTRYPOINT ["/opt/fileWatcher"]
