FROM openjdk:8

RUN mkdir -p /usr/app
WORKDIR /usr/app

COPY . .

RUN ./gradlew build --refresh-dependencies

ENTRYPOINT ["./gradlew","bootRun"]

# docker run -it -p 3000:3000 spring-boot:latest