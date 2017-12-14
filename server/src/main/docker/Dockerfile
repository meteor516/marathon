FROM java:8

VOLUME /tmp

RUN mkdir /app
ADD server.jar /app/app.jar

RUN bash -c 'touch /app/app.jar'
WORKDIR /app

EXPOSE 8888

CMD ["java","-Djava.security.egd=file:/dev/.urandom", "-jar","/app/app.jar"]