# This is a neat idea from Google. More info here: https://github.com/GoogleContainerTools/distroless
FROM gcr.io/distroless/java:11

# We add the jar spring-boot generated with all the dependencies
COPY target/run-spring-boot.jar /opt/run-spring-boot.jar

# Remember to start your gRPC server on this port
EXPOSE 8080

# The jar we just copied above
ENTRYPOINT ["java", "-jar", "/opt/run-spring-boot.jar"]