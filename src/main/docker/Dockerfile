FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp # reate a temporary file on my host under "/var/lib/docker" and link it to the container under "/tmp".
ADD spring-boot-docker-0.1.0.jar app.jar
RUN sh -c "touch /app.jar" #  "touch" the jar file so that it has a file modification time (Docker creates all container files in an "unmodified" state by default). This actually isn’t important for the simple app that we wrote, but any static content (e.g. "index.html") would require the file to have a modification time.
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"] # To reduce Tomcat startup time we added a system property pointing to "/dev/urandom" as a source of entropy.
