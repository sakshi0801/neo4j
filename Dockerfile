FROM openjdk:11.0.3-jdk-slim-stretch
ADD ./target/neo4jDemo-0.0.1-SNAPSHOT.jar /app/neo4jDemo-0.0.1-SNAPSHOT.jar
WORKDIR app/
ENTRYPOINT ["java","-jar","neo4jDemo-0.0.1-SNAPSHOT.jar"]