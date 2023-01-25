
FROM nginx:stable-alpine as production-stage
COPY ./front/dist/spa /usr/share/nginx/html
COPY default.conf /etc/nginx/conf.d/default.conf
COPY start.sh /tmp/start.sh
COPY start.sh /tmp/start.sh
CMD ["/tmp/start.sh"]


