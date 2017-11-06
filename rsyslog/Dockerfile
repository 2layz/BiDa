FROM alpine
MAINTAINER 2layz
RUN  apk update \
  && apk add rsyslog
ADD rsyslog_default.conf /etc/rsyslog_default.conf
ADD rsyslog.conf /etc/rsyslog.conf
EXPOSE 514 514/udp
ENTRYPOINT [ "rsyslogd", "-n" ]