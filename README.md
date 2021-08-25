# 微服务实战

---

## Nacos

https://nacos.io/zh-cn/

https://nacos.io/zh-cn/docs/quick-start.html


```shell
./bin/startup.sh
```

http://localhost:8848/nacos

## Prometheus

https://prometheus.io/download/

```shell

./prometheus

# or

docker run \
    -p 9090:9090 \
    -v /path/to/prometheus.yml:/etc/prometheus/prometheus.yml \
    prom/prometheus
```

## Grafana

https://grafana.com/grafana/download?platform=mac

```shell
brew update

brew install grafana

brew info grafana

# 启动
/usr/local/opt/grafana/bin/grafana-server --config /usr/local/etc/grafana/grafana.ini \
--homepath /usr/local/opt/grafana/share/grafana --packaging=brew \
cfg:default.paths.logs=/usr/local/var/log/grafana cfg:default.paths.data=/usr/local/var/lib/grafana \
cfg:default.paths.plugins=/usr/local/var/lib/grafana/plugins
http://localhost:3000/

# 4701
```

## Zipkin

https://zipkin.io/pages/quickstart.html

```shell
docker run -d -p 9411:9411 openzipkin/zipkin
```

## Skywalking

https://skywalking.apache.org/downloads/

```shell
wget https://mirrors.tuna.tsinghua.edu.cn/apache/skywalking/8.7.0/apache-skywalking-apm-8.7.0.tar.gz

tar -xvf apache-skywalking-apm-8.7.0.tar.g

cd apache-skywalking-apm-bin

# start
./bin/startup.sh

# stop
jps -lvm | grep -i 'sky' | grep -v 'agent' | awk '{print $1}' | xargs kill -9


# 测试dashboard
curl http://localhost:8080/

# 赋值文件
sh deploy.sh

# 启动
java -javaagent:z-deploy/agent1/skywalking-agent.jar -jar z-deploy/ms-gateway-0.0.1-SNAPSHOT.jar
java -javaagent:z-deploy/agent2/skywalking-agent.jar -jar z-deploy/ms-customer-0.0.1-SNAPSHOT.jar
java -javaagent:z-deploy/agent3/skywalking-agent.jar -jar z-deploy/ms-provider-0.0.1-SNAPSHOT.jar

# 测试
curl http://localhost:8800/lbapi/customer/test3
```

```properties
agent.service_name=${SW_AGENT_NAME:user-center}
collector.backend_service=${SW_AGENT_COLLECTOR_BACKEND_SERVICES:192.168.100.17:11800}
```

```shell
curl http://localhost:8800/lbapi/customer/test3
```