FROM maven:3.6.3-jdk-11-slim

# COPY entrypoint.sh /usr/local/bin/entrypoint.sh
COPY . /mavenProject
# RUN apt-get update && apt-get install dos2unix && dos2unix /usr/local/bin/entrypoint.sh && chmod +x /usr/local/bin/entrypoint.sh

#Start application
WORKDIR /mavenProject
RUN mvn clean package spring-boot:repackage
RUN chmod +x ./target/parsing-service-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "./target/parsing-service-1.0-SNAPSHOT.jar"]