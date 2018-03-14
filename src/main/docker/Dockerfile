# Pull in the smallest Docker image with OracleJDK 8 (167MB)
FROM frolvlad/alpine-oraclejdk8:slim

# add bash and coreutils
RUN apk add --no-cache bash coreutils

MAINTAINER negrean.cristina@gmail.com

VOLUME /tmp

#ADD rugbymatch-1.0.0-SNAPSHOT.jar app.jar

RUN bash -c 'touch /app.jar'

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]