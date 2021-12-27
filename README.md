Current Exchange URL:
* http://localhost:8000/currency-exchange/from/USD/to/INR

Currency Conversion URL:
* http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10

Eureka:
* http://localhost:8761

API Gateway:
* https://localhost:8765/currency-exchange/currency-exchange/from/USD/to/INR
* http://localhost:8765/currency-conversion/currency-conversion/from/AUD/to/INR/quantity/5

---- 
To run multiple instances of spring-boot and different ports

----
`mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8000`


----

Fire multiple requests from commandline:

* watch curl <url>
* To define a time-interval
    - watch -n 0.1 curl http://localhost:8000/sample-api
