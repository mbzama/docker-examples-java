cd customer-api
mvn clean compile package -DskipTests=true

cd ..

pwd

docker-compose build
docker-compose up -d
