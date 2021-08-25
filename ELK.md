# Elk

---


## Mac

### Elasticsearch

```shell
# install
brew install elasticsearch

# info
brew info elasticsearch

# run
elasticsearch
```

http://localhost:9200/

### Kibana

```shell
# install
brew install kibana

# info
brew info kibana

# run
kibana
```

http://localhost:5601/app/home

## Docker

```shell
docker pull elasticsearch:7.14.0
docker pull kibana:7.14.0

docker network create elastic

docker run --name es01-test --net elastic -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:7.14.0
docker run --name kib01-test --net elastic -p 5601:5601 -e "ELASTICSEARCH_HOSTS=http://es01-test:9200" kibana:7.14.0
```

http://localhost:9200/
http://localhost:5601/app/home