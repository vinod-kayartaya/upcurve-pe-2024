#!/bin/bash

# Define an array with the names of the service directories
services=(
  "category-service"
  "product-service"
  "supplier-service"
  "eureka-service"
  "gateway-service"
)

# Loop through each service directory and run the Maven command
for service in "${services[@]}"; do
  echo "Building $service..."
  cd $service
  mvn clean package -DskipTests
  if [ $? -ne 0 ]; then
    echo "Build failed for $service"
    exit 1
  fi
  cd ..
done

echo "All services built successfully."
