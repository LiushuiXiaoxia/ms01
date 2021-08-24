#!/bin/sh

set -e

#./gradlew clean assemble

mkdir -p z-deploy

cp ms-gateway/build/libs/*.jar z-deploy
cp ms-customer/build/libs/*.jar z-deploy
cp ms-provider/build/libs/*.jar z-deploy