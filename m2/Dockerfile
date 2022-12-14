#build stage
# FROM node:lts-alpine as build-stage
# WORKDIR /app

# COPY ./front/package*.json ./
# COPY ./front .

# RUN npm install -g @quasar/cli 
# RUN npm i

# RUN quasar build

#production stage
FROM nginx:stable-alpine as production-stage
COPY ./front/dist/spa /usr/share/nginx/html
# COPY default.conf /etc/nginx/conf.d/default.conf
COPY start.sh /tmp/start.sh
COPY ./Spring-Rest-Car/target/car-dealer-application-0.0.1-SNAPSHOT.jar /server/car.jar
COPY ./Spring-Rest-Salon/target/car-dealer-application-0.0.1-SNAPSHOT.jar /server/salon.jar
COPY ./Spring-Rest-Gateway/target/car-dealer-application-0.0.1-SNAPSHOT.jar /server/gateway.jar
RUN apk add maven
CMD ["/tmp/start.sh"]



# CMD [ "quasar", "dev"]



