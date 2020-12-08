FROM adoptopenjdk/openjdk9-openj9:latest

WORKDIR /app

COPY target/bip-address-0.0.1-SNAPSHOT.jar /app/bip-address.jar

ENTRYPOINT ["java","-jar","bip-address.jar"]