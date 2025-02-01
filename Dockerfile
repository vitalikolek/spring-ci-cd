FROM openjdk:21-jdk

EXPOSE 8080

COPY ./build/libs/spring-ci-cd-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "spring-ci-cd-0.0.1-SNAPSHOT.jar"]