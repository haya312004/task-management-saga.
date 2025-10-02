#!/bin/bash
echo "=== Building and Deploying Microservices to Docker ==="

# Build Eureka Server
echo "1. Building Eureka Server..."
cd eureka-server
docker build -t eureka-server .
docker run -d -p 8761:8761 --name eureka-container eureka-server
cd ..

echo "✅ Eureka Server deployed successfully!"
echo "📊 Access at: http://localhost:8761"
echo "🔍 Check running containers: docker ps"