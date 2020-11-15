# Coinbase client

A simple Coinbase Pro websocket client built on Spring Boot. Features:
 - Connects to websocket server and subscribing to ticker channel
 - Persists most current received data regarding subscribed instruments
 - Exposes endpoint providing persisted data in json format
 
 Enpoint URI: /api/instruments  
 Default port: 8080
 
 How to run locally (required JDK 11+):
 1. Run "gradlew clean build" command in project's root directory
 2. Navigate to /build/libs
 3. Run "java -jar <JAR_FILENAME>" 