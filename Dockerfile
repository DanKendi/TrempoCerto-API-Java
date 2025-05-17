FROM eclipse-temurin:21-jdk-alpine


WORKDIR /app


COPY . .


RUN chmod +x ./mvnw


RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install


CMD ["java", "-jar", "target/quarkus-app/quarkus-run.jar"]