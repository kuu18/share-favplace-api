#
# Build stage
#
FROM amazoncorretto:17 AS builder
ARG WORKDIR
ARG DB_URL
ENV HOME=/${WORKDIR} \
    LANG=C.UTF-8 \
    TZ=Asia/Tokyo \
    HOST=0.0.0.0
WORKDIR ${HOME}
COPY ./ ${HOME}
RUN echo ${DB_URL}
RUN echo ${WORKDIR}
RUN echo ${DB_USERNAME}
RUN echo ${DB_PASSWORD}
RUN ./gradlew build
#
# Package stage
#
FROM amazoncorretto:17-alpine
ARG WORKDIR
ENV HOME=${WORKDIR} \
    LANG=C.UTF-8 \
    TZ=Asia/Tokyo \
    HOST=0.0.0.0
COPY --from=builder ${HOME}/build/libs/share-favplace-api-0.0.1-SNAPSHOT.jar share-favplace-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","share-favplace-api.jar"]
