FROM openjdk:11
# MAINTAINER GSD
#TODO: change the name of the jar file
ADD ./target/*.jar /app/service.jar

#Java execution
#TODO: change the name of the jar file
EXPOSE 8080
CMD ["java", "-Xms500m" ,"-Xmx500m", "-jar", "/app/service.jar"]
