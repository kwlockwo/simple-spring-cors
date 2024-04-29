FROM eclipse-temurin:17-jdk-jammy AS base
WORKDIR /service
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src src

FROM base AS build
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /service

COPY --from=build /service/target/simple-spring-cors-0.0.1-SNAPSHOT.jar ./
RUN mkdir "$HOME"/.ssh && chmod 700 "$HOME"/.ssh

CMD [java, -jar, /service/simple-spring-cors-0.0.1-SNAPSHOT.jar]