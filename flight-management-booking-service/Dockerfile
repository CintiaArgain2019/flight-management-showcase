FROM openjdk:8-jre-alpine

ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh wait-for-it.sh
RUN chmod 777 wait-for-it.sh
RUN apk add --no-cache bash

ADD ["target/flight-management-booking-service-0.0.1-SNAPSHOT.jar", "app.jar"]
EXPOSE 9020 8787
#ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8787,suspend=n"
ENV JAVA_OPTS="-Xmx128M -Xms128M"
RUN sh -c 'touch /app.jar'
HEALTHCHECK CMD curl -f http://localhost:9020/actuator/health || exit 1
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=production -jar /app.jar" ]
