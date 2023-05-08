FROM openjdk:8-jre
ENV APP_PATH=/apps
WORKDIR $APP_PATH
ADD backend-0.0.1-SNAPSHOT.jar $APP_PATH/maple.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar"]
CMD ["maple.jar"]