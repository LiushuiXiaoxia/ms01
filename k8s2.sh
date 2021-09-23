#!/bin/bash

#set -e

echo "Build with Gradle"
chmod u+x gradlew
./gradlew clean assemble
echo "Build complete"


VERSION_NAME=v0.1

build_module() {
  module=$1
  port=$2
  echo ">>> docker build $module"
  cd "$module"

  minikube image build -t "$module:$VERSION_NAME" .

  cd ..
  echo "<<< docker build $module"
}

build_module "ms-gateway" 8800
build_module "ms-customer" 8810
build_module "ms-provider" 8820


kubectl delete -f k8s2.yml
kubectl apply -f k8s2.yml

sleep 10

minikube service ms-gateway-svc
echo "build and start success..."
