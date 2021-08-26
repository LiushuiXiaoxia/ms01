#!/bin/sh

set -e

echo "Build with Gradle"
chmod u+x gradlew
./gradlew clean assemble
echo "Build complete"

build_module() {
  module=$1
  port=$2
  echo ">>> docker build $module"
  pushd "$module"
  docker ps | grep "$module:v0.1" | awk '{print $1}' | xargs docker stop
  docker ps -a | grep "$module:v0.1" | awk '{print $1}' | xargs docker rm
  docker images | grep "$module:v0.1" | awk '{print $3}' | xargs docker rmi

  docker build -t "$module":v0.1 .

  echo "docker start $module"
  docker run -d --network host -p "$port":"$port" --name "$module"-docker "$module":v0.1
  popd
  echo "<<< docker build $module"
}

build_module "ms-gateway" 8800
build_module "ms-customer" 8810
build_module "ms-provider" 8820

echo "build and start success..."

sleep 10

docker ps | grep "ms"
