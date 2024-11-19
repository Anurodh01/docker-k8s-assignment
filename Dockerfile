FROM openjdk:17
EXPOSE 8050
ADD target/employee-service.jar employee-service.jar
ENTRYPOINT ["java","-jar","/employee-service.jar"]