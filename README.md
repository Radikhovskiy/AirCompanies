*AirCompanies service*
-
This is a program based on Spring Boot, which allows us to create and modify airplanes, as well as manage flights.
This project uses an H2 database, so you don't need to change the database settings.

**Technologies used:**
- JDK 11
- Spring Boot
- Docker
- H2 database
- Spring Web
- Spring ORM
- Hibernate
- JPA Repository
- Lombok
- Maven

**How start using:**
- Fork repository and clone it to your IDE
- Run AirCompaniesApplication to be able to go to the url of the local host

**Task**

*Your localhost will be printed in console during run application.

1) All CRUD operations were added.
2) To change the company for the plane you need to enter a link in Postman using PATCH method:
   http://localhost:8080/airplanes/change/[AIRPLANE_NAME]?companyName=[AIRCOMPANY_NAME]

Example: http://localhost:8080/airplanes/change/Hawker-Hurricane?companyName=ExpressJet-airlines

3) To find all Air Company Flights by status enter: http://localhost:8080/flights/[AIRCOMPANY_NAME]/?status=[STATUS_IN_UPPER_CASE]
   
Example: http://localhost:8080/flights/Delta-Air-Lines?status=ACTIVE

4) To find all Flights in ACTIVE status and started more than 24 hours ago: http://localhost:8080/flights/active-after-a-day
5) To add new Airplane you need to use Postman and send POST request on url http://localhost:8080/airplanes/add (in header choose Content type on application/json and transfer the body in raw format)

You can add only one Airplane with the same name.
6) To add new Flight enter: http://localhost:8080/flights/add and follow the steps from the previous point.

P.s. Don't specify fields id and flight status. It will insert automatically and the status will be PENDING.
7) To change Flight status use PATCH method in Postman and enter: http://localhost:8080/flights/change-status/[FLIGHT_ID]?status=[STATUS_IN_UPPER_CASE]

Example: http://localhost:8080/flights/change-status/4?status=ACTIVE
Started and ended time will be inserted automatically for suitable statuses. 

Note: you can use me Postman collection to test application: https://www.postman.com/orbital-module-technologist-4380168/workspace/public-workspace/collection/18301113-f36f098c-22ff-47d7-8d67-43d84640ba25

**Run app with help Docker:**

First you need to install Docker Desktop and register on DockerHub.

Commands to work with Docker:
1. Create a jar

mvn clean package

2. Build the image

docker build -t <YOUR_DOCKER_HUB_ID/YOUR_IMAGE_NAME> .

3. Run it locally and check the result on localhost

docker run -p 8080:8080 <YOUR_DOCKER_HUB_ID/YOUR_IMAGE_NAME>

Depends on your localhost

5. Stop it locally

Control + C

4. Push the image to the docker hub

docker push <YOUR_DOCKER_HUB_ID/YOUR_IMAGE_NAME>
  
