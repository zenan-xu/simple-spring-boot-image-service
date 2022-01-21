# Simple example showing an image processing microservices

# API Gateway service
Entrypoint to other image services using `org.springframework.cloud:spring-cloud-starter-gateway`

# Image uploader service
A service that can upload and save images to cloud storage (google cloud bucket) 
which to be transformed later using `com.google.cloud:spring-cloud-gcp-starter-storage`

# Image transformer service
A service that can transform image using `net.coobird:thumbnailator`

# Swagger page
A Swagger page for image services using `org.springdoc:springdoc-openapi-ui`

# Disclaimer
Add kubernetes deployment file. Haven't got time to that (not very familiar to set up kubernetes)
I'll try and add one later.