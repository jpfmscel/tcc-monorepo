#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/*.jar /usr/local/lib/
EXPOSE 8080
ENTRYPOINT ["java","-Xms500m" ,"-Xmx500m", "-jar","/usr/local/lib/demo.jar"]


#FROM openjdk:11
#ADD ./target/*.jar /app/service.jar

#Java execution
#EXPOSE 8080
#CMD ["java", "-Xms500m" ,"-Xmx500m", "-jar", "/app/service.jar"]
