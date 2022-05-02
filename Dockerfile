FROM tomcat:9.0

MAINTAINER victoremanuelsr

EXPOSE 8080

COPY /build/libs/PetStore.war /usr/local/tomcat/webapps/
