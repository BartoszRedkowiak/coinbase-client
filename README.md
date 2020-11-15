# Coinbase client

A simple Coinbase Pro websocket client built on Spring Boot. Features:
 - Connects to websocket server and subscribing to ticker channel
 - Persists most current received data regarding subscribed instruments
 - Exposes endpoint providing persisted data in json format
 
 Enpoint URI: /api/instruments  
 Default port: 8080
 
 How to run application (required JDK 11+):  
 Execute "gradlew bootRun" command in project's root directory