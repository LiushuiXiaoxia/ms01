#!/bin/sh

# set -e

sh /nacos/bin/startup.sh -m standalone

sleep 5

tail -f /nacos/logs/start.out

while :
do
    echo "nacos start success..."
    sleep 5
done