FROM hypriot/rpi-java

ADD target/*.jar /opt/discbot-service-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/opt/discbot-service-0.0.1-SNAPSHOT.jar"]
