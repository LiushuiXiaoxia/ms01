FROM openjdk:8-jdk-alpine

ADD nacos-server-2.0.3.zip /
ADD start.sh /

RUN unzip nacos-server-2.0.3.zip

ENTRYPOINT ["sh","/start.sh"]