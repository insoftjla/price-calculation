FROM gradle:8-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle build && rm -rf build/libs/*plain.jar

FROM amazoncorretto:17 as executor
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]