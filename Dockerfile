FROM openjdk:8
ADD target/tourguide_gpsUtil-0.0.1-SNAPSHOT.jar tourguide_gpsUtil-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "/tourguide_gpsUtil-0.0.1-SNAPSHOT.jar"]