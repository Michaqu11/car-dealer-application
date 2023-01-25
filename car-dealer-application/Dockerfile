
FROM nginx:stable-alpine as production-stage

COPY ./application/target/car-dealer-application-0.0.1-SNAPSHOT.jar /server/application.jar
RUN apk add maven
CMD ["java", "-jar", "/server/application.jar"]


