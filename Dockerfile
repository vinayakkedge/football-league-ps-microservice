# For Java 8, try this
FROM openjdk:8-jdk-alpine

# Refer to Maven build -> finalName
ARG JAR_FILE=target/football-league-kedge.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/football-league-abansal.jar /opt/app/football-league-kedge.jar
COPY ${JAR_FILE} football-league-kedge.jar
EXPOSE 8085
# java -jar /opt/app/football-league-kedge.jar
ENTRYPOINT ["java","-jar","football-league-kedge.jar"]
# sudo docker build -t spring-boot:1.0 .
# sudo docker run -d -p 8085:8085 -t spring-boot:1.0
