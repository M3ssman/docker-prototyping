FROM node:8-alpine

RUN mkdir -p /usr/app
COPY ./package.json /usr/app/package.json
COPY ./package-lock.json /usr/app/package-lock.json
COPY ./tsconfig.json /usr/app/tsconfig.json
COPY ./memcache-example.ts /usr/app/memcache-example.ts

WORKDIR /usr/app
RUN npm i
RUN ./node_modules/.bin/tsc -p .

ENTRYPOINT [ "node", "/usr/app/memcache-example.js" ]