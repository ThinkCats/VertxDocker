FROM maven:3.3.9-jdk-8
RUN mvn package
RUN ls