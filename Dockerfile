FROM openjdk:17-jdk-slim
EXPOSE 8083
COPY target/Spring-Boot-Demo-0.0.1-SNAPSHOT.jar Spring-Boot-Demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "Spring-Boot-Demo-0.0.1-SNAPSHOT.jar"]