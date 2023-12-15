FROM openjdk:17-jdk-alpine
COPY target/TelegramGPTBot-1.0.0-SNAPSHOT-jar-with-dependencies.jar java-app.jar
ENTRYPOINT ["java", "-jar", "java-app.jar"]