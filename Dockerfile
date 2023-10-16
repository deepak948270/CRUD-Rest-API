FROM openjdk
WORKDIR /app
COPY target/*.jar /app/springboot.jar
CMD [ "java","-jar","springboot.jar" ]