# Api gateway service

Entry point of other image services

# Getting Started

### Run locally
```maven
mvn spring-boot:run
```
Visit http://localhost:8080... to visit other services

For example : http://localhost:8080/image-transformer/api/change-size to 

### Package  project
```maven
mvn package
```
### Build docker image
```docker
docker build -t zenan/api-gateway .
```
