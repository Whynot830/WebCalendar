FROM node:14 as build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
FROM node:14-slim
WORKDIR /app
COPY --from=build-stage /app/dist /app/dist
RUN npm install -g http-server
EXPOSE 8081
CMD ["http-server", "-g", "-p", "8081", "dist"]
