FROM maven:3.3.9-jdk-8-onbuild
RUN mvn package
RUN ls
EXPOSE 8000
CMD ["java -jar","target/com.vv-1.0-SNAPSHOT-fat.jar"]