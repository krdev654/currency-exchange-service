Current Exchange URL:
* http://localhost:8000/currency-exchange/from/USD/to/INR

Currency Conversion URL:
* http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10


---- 
To run multiple instances of spring-boot and different ports

----
`mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8000`