FROM azul/zulu-openjdk-alpine:17-latest
LABEL authors="luis"

COPY gradlew gradlew
COPY settings.gradle settings.gradle
COPY build.gradle build.gradle
COPY src ./src
COPY gradle ./gradle

CMD ["./gradlew", "bootRun"]
