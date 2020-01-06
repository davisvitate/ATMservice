FROM openjdk:8
VOLUME /tmp
EXPOSE 8806
ADD ./target/Atm-0.0.1-SNAPSHOT.jar atm-server.jar
ENTRYPOINT ["java","-jar","/atm-server.jar"]