FROM openjdk:11.0.15
EXPOSE 8080:8080
RUN mkdir /app
COPY ./build/libs/*-all.jar /app/application.jar
ENTRYPOINT ["java", "-jar", "/app/application.jar"]
