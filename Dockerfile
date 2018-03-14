FROM java:8
WORKDIR /rugbymatch
VOLUME ["/rugbymatch"]
EXPOSE 8080
ADD /target/rugbymatch-1.0-SNAPSHOT.jar rugbymatch-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","rugbymatch-1.0-SNAPSHOT.jar"]