#!/bin/sh

set -e

echo "Build with Gradle"
chmod u+x gradlew
./gradlew clean assemble -PBUILD_ENV=docker
echo "Build complete"

build_module() {
  module=$1
  port=$2
  echo ">>> docker build $module"
  pushd "$module"
  docker ps | grep "$module" | awk '{print $1}' | xargs docker stop
  docker ps -a | grep "$module" | awk '{print $1}' | xargs docker rm
  docker images | grep "$module" | awk '{print $3}' | xargs docker rmi
  docker build -t "$module":v0.1 .
  echo "docker start $module"
  # docker run -d --network=host --net=host -p "$port":"$port" --name "$module"-docker "$module":v0.1
  popd
  echo "<<< docker build $module"
}

echo "build and start success..."
docker-compose up --build

sleep 10
docker ps | grep "ms"
