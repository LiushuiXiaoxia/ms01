#!/bin/sh

# set -e

./gradlew clean assemble

rm -rf z-deploy && mkdir -p z-deploy

cp ms-gateway/build/libs/*.jar z-deploy
cp ms-customer/build/libs/*.jar z-deploy
cp ms-provider/build/libs/*.jar z-deploy


cp -R /Users/xiaqiulei/dev/apache-skywalking-apm-bin/agent ./z-deploy/agent1
cp ./z-deploy/agent1/optional-plugins/apm-spring-cloud-gateway-2.1.x-plugin-8.7.0.jar ./z-deploy/agent1/plugins

cp -R /Users/xiaqiulei/dev/apache-skywalking-apm-bin/agent ./z-deploy/agent2
cp -R /Users/xiaqiulei/dev/apache-skywalking-apm-bin/agent ./z-deploy/agent3

cp  -f ./z-script/agent1.config ./z-deploy/agent1/config/agent.config
cp  -f ./z-script/agent2.config ./z-deploy/agent2/config/agent.config
cp  -f ./z-script/agent3.config ./z-deploy/agent3/config/agent.config