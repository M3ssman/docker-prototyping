FROM "node:8.9-alpine"

RUN apk add --no-cache git mercurial \
    && git clone https://github.com/mobz/elasticsearch-head \
    && apk del git

RUN ls -la

RUN cd /elasticsearch-head && npm install
RUN ls -la

WORKDIR /elasticsearch-head
ENTRYPOINT [ "npm", "start" ]