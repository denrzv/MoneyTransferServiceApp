FROM openjdk:8-jdk-alpine
EXPOSE 5500
ADD build/libs/MoneyTransferServiceApp-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java", "-jar", "myapp.jar"]