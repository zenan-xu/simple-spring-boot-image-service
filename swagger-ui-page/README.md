# Swagger UI page for image uploader and image transformer service

# Getting Started

### Run locally
```maven
mvn spring-boot:run
```
Visit `http://localhost:8083/swagger-ui/index.html`
### Package  project
```maven
mvn package
```
### Build docker image
```docker
docker build -t zenan/swagger-ui .
```

# Disclaimer
For image transformer service, the `content-disposition` header for the file name added by the service
is not propagated to the swagger, needs to check the problem. Otherwise, the swagger ui of image transformer service
works correctly on `http://localhost:8083/swagger-ui/index.html`
