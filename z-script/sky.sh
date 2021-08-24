#!/bin/sh


java -javaagent:z-deploy/agent1/skywalking-agent.jar -jar z-deploy/ms-gateway-0.0.1-SNAPSHOT.jar

java -javaagent:z-deploy/agent2/skywalking-agent.jar -jar z-deploy/ms-customer-0.0.1-SNAPSHOT.jar

java -javaagent:z-deploy/agent3/skywalking-agent.jar -jar z-deploy/ms-provider-0.0.1-SNAPSHOT.jar