#FROM maven:3.9.12-eclipse-temurin-25
##FROM maven:3.9.9-eclipse-temurin-21
#WORKDIR /app
#COPY ./pom.xml /app/pom.xml
#COPY ./src /app/src
#RUN mvn clean install
#CMD ["ls"]



FROM maven:3.9.12-eclipse-temurin-25
WORKDIR /app
COPY . .
RUN mvn clean install
RUN ls
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
