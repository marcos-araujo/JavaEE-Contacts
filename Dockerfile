FROM tomcat:7.0.90-jre8
MAINTAINER Marcos Araújo
ARG JAR_FILE=target/*.war
COPY target/*.war /usr/local/tomcat/webapps/