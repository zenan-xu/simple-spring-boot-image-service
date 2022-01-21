# Image transformer service

A service that can transform image (change scale, size ...)

This service is registered in the API Gateway service
# Getting Started

### Run locally
```maven
mvn spring-boot:run
```

### Package  project
```maven
mvn package
```
### Build docker image
```docker
docker build -t zenan/image-transformer .
```

# Disclaimer
Need to work on the cors filter