# flight-management-showcase

This is a proof-of-concept application, which demonstrates Microservice Architecture Pattern using Spring Boot Microservices  via Spring Cloud, Netflix OSS, ELK Stack, Docker.

## Development environment
- Docker 19.03.2
- Docker Compose 1.24.1
- Docker MySQL 8.0.18
- Java8 
- Spring Cloud Greenwich.SR3


## Setup and Running on Docker (Single Instance)

* Run the [oneTouchDockerImageBuilder.sh](oneTouchDockerImageBuilder.sh) script which will perform the Maven packaging operation of all the microservices and then start the containers.
 

* All the variables in docker-compose.yml file are read from the .env file located in the root path of the showcase.


## Architecture
All the Microservices are developed using spring boot. All of they will consume its configuration from the Config Server.
This spring boot applications will be registered with eureka discovery server.
Zuul will route the requests to the different microservice based on the url route. Zuul registers itself with eureka and gets the ip/domain from eureka for the microservice while routing the request.


Services will be exposed in the following ports


| Service                  | port     | 
|--------------------------|-----------
|Config Serer              | 8888
|Eureka Discovery Service  | 8761
|Api Gateway Service       | 9000
|Hystrix Dashboard         | 8989
|Zipkin Dashboard          | 9411
|Flight  Service           | 9010
|Booking Service           | 9020
|Passenger Service         | 9030

<hr>


Once everythings is up and running, you should be able to open a browser & hit any of the following URLs:

| Service   | Path                          | Description             |
|-----------|-------------------------------|-------------------------|
| Eureka    | http://localhost:8761         | Eureka with all Services|
| Hystrix   | http://localhost:8989/hystrix | Info on Circuit Breakers|
| Zipkin    | http://localhost:9411         | Latence Details         |
| Kibana    | http://localhost:5601         | Log Analysis            |


### Testing Microservices using Postman

[Postman](https://www.getpostman.com/) is a client to test various HTTP services. [Download Postman](https://www.getpostman.com/downloads/) and install it.
Open postman application, go to `File` -> `Import` opening import dialog. Click on `Choose Files` to import and select the [Flight-management-showcase.postman_collection.json](Flight-management-showcase.postman_collection.json) and
[Flight-management-showcase.postman_environment.json](Flight-management-showcase.postman_environment.json) from the folder `postman`.
After import you'll see the collection `Flight-management-showcase` on the left-side menu. 

