#!/bin/sh

#set -e

echo "Build with Gradle"
chmod u+x gradlew
./gradlew clean assemble
echo "Build complete"

VERSION_NAME=v0.1
REPO_URL=xx.oo/xia

build_module() {
  module=$1
  port=$2
  echo ">>> docker build $module"
  pushd "$module"
  docker images | grep "$module:$VERSION_NAME" | awk '{print $3}' | xargs docker rmi

  docker build -t "$module:$VERSION_NAME" .
  docker tag "$module:$VERSION_NAME" "$REPO_URL/$module:$VERSION_NAME"
  popd
  echo "<<< docker build $module"
}

build_module "ms-gateway" 8800
build_module "ms-customer" 8810
build_module "ms-provider" 8820


kubectl delete -f ms-k8s.yml

echo ">>> minikube load image"
minikube image load "$REPO_URL/ms-gateway:$VERSION_NAME"
minikube image load "$REPO_URL/ms-customer:$VERSION_NAME"
minikube image load "$REPO_URL/ms-provider:$VERSION_NAME"
echo "<<< minikube load image"

kubectl apply -f k8s.yml

sleep 10
minikube service ms-gateway-svc
echo "build and start success..."
