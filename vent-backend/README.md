# vent-backend

> Visualized Education NTNU

Vent is a visualization tool for educational data. This is the backend that can be configured to integrate data from multiple sources, before converting them to [VSON](https://github.com/hernil/vson) and exposing them through an API.  

## Build Setup

``` bash
# install dependencies
mvn install

# package and run jar
mvn package && MYSQL_DB_PASSWORD=password java -jar target/vent-0.0.1-SNAPSHOT.jar
```

This application is written in Kotlin using the Spring Boot framework. Please refer to their respective documentation for troubleshooting. 

