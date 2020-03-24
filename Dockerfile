FROM openjdk:8
COPY . /
COPY src/main/resources/GeoLite2-Country.mmdb /tmp/
WORKDIR target
CMD ["java", "-jar", "getting-started-1.0-SNAPSHOT-runner.jar"]
EXPOSE 80/tcp

