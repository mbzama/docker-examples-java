# This defines our starting point
FROM node 

RUN mkdir /usr/src/app 
 
WORKDIR /usr/src/app

RUN npm install -g @angular/cli 

COPY . . 

RUN npm install 

