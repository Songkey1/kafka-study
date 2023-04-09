# kafka-study

### [kafka-docker compose](https://github.com/wurstmeister/kafka-docker)
[docker-compose.yml](kafka-docker/docker-compose.yml)을 아래와 같이 수정하여 single broker로 사용
    
```agsl
version: '2'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    ports:
      - "2181:2181"
    restart: unless-stopped

  kafka:
    build: .
    ports:
      - "9092:9092"
    environment:
      DOCKER_API_VERSION: 1.22
      KAFKA_ADVERTISED_HOST_NAME: 127.0.0.1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock
    restart: unless-stopped
```
        
- Start a cluster: `docker-compose up -d`
- Destroy a cluster: `docker-compose stop`
