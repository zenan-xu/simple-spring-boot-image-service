# Image uploader service

A service that can upload and save images to cloud storage (google cloud bucket) which to be transformed later


This service is registered in the API Gateway service
# Getting Started

Change `gcs-resource` with your resource 

Change google gcp credentials (credentials.json) and add your json.
You can follow this [link](https://cloud.google.com/docs/authentication/getting-started)
to generate your own credentials

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
docker build -t zenan/image-uploader .
```

# Disclaimer
Need to work on the cors filter