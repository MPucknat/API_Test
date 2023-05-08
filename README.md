# API_Test

## Usage
Make a REST calls to localhost:8080
````json
{
  "method": "amount",
  "number": 1000
}

````

Other possible values for method:
|Method|Description|
|nothing|Returns a Random beer|
|amount|Returns the amount of beer you specify|
|id|Returns a beer with that id|

## Project setup

### Run with Docker

First, you need to build the project with maven:
```
mvn clean install -P api_test
```

Then just run the docker-compose:
```
docker-compose up -d
```
