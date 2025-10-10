FROM amazoncorretto:21-alpine-jdk
COPY target/misegundaapi-0.0.1-SNAPSHOT.jar /miapiv1.jar

ENTRYPOINT ["java","-jar","/miapiv1.jar"]