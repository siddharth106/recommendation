FROM openjdk:11

ADD ./target/recommendation-service-2.1.2.RELEASE.jar recommendation-service.jar
EXPOSE 8023

ENTRYPOINT ["java","-jar","recommendation-service.jar"]
