FROM gradle:jdk21-alpine

WORKDIR .

COPY src/ src/
COPY gradle/ gradle/
COPY gradlew gradlew
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle



CMD ["gradle", "bootrun"]