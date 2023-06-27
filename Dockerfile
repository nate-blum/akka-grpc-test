FROM gradle:6.9.4-jdk11
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN ./gradlew
RUN ./gradlew compileScala

ENTRYPOINT exec ./gradlew runServer