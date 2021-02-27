FROM openjdk

WORKDIR /app

COPY target/justa-0.0.1-SNAPSHOT.jar /app/justa-app.jar

ENTRYPOINT ["java", "-jar", "justa-app.jar"]