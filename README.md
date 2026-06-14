# Mini Projet JEE - Student Management App

## Technologies
- Java 17 / Jakarta Servlet 6
- JSP
- JDBC + MySQL
- Maven
- Docker + Tomcat 10

## Lancer le projet
```bash
docker network create jee-network
docker run -d --name mysql --network jee-network \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=studentdb \
  -v $(pwd)/sql/init.sql:/docker-entrypoint-initdb.d/init.sql \
  -v mysql-data:/var/lib/mysql \
  mysql:8.0
sleep 10
docker run -p 8080:8080 --name course-web --network jee-network course-web
```

## Accès
http://localhost:8080
