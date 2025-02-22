#FROM que se utilizo para llamar la imagen para compilar
#FROM openjdk:17-oracle
FROM docker.io/library/openjdk:17-oracle
#From 	ue manda a llamar mi imagen ya funcional
#FROM docker.io/doriceli/avance_rest:v4

LABEL mainainer="DIM"
EXPOSE 8085	
ARG JAR_FILE=targat/*.jar
COPY target/*.jar app.jar
CMD ["java", "-jar", "/app.jar"]
LABEL version=v5

ENV MIAPP_PORT 8087
ENV MI_URL mongodb+srv://doriceliixtla:hnrJmpnrgA6POrVj@rest.vrfw9.mongodb.net/sample_mflix
ENV MI_BD sample_mflix
ENV EL_USER doriceliixtla
ENV EL_PASS hnrJmpnrgA6POrVj

