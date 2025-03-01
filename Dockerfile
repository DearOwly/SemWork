FROM gradle:jdk21-corretto AS builder
WORKDIR /application
COPY . .
RUN --mount=type=cache,target=/root/.gradle  gradle clean build -x test

FROM amazoncorretto:21-alpine AS layers
WORKDIR /application
COPY --from=builder /application/build/libs/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM amazoncorretto:21-alpine
VOLUME /tmp
COPY --from=layers /application/dependencies/ ./
COPY --from=layers /application/spring-boot-loader/ ./
COPY --from=layers /application/snapshot-dependencies/ ./
COPY --from=layers /application/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
