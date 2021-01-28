FROM gradle:6.8-jdk15-hotspot
WORKDIR /app
COPY settings*.gradle .
COPY build*.gradle*.kts .
COPY src src
RUN gradle build

FROM adoptopenjdk/openjdk15:jre-15.0.1_9
COPY --from=0 /app/build/libs/aws-services-training-0.0.1.jar /usr/local/lib/app.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]