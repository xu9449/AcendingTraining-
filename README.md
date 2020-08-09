
# BudE+

BudE+ is a website to help street pets find their sweet home.  

## Description  
What I want to build is a website to help street pets find their homes. Especially during the COVID-19 period, hope they can still find their new homes.  


## Project Technical Overview:
This application is developed in Spring Framework by using Spring Boot, Spring Data, Hibernate, Spring RESTful web services, Postman, Maven, PostgresSql, Docker, Amazon SQS, and Amazon S3.  

## Assumption 
1. It's will be a website to help shelters find homes for their pets, especially after COVID - 19, it will help them to recovery the adopt market.
2. The adopters need to sign up before access any data.
3. Adopters can get all the info such as pet's breed, age, images, shelter's location, news etc.
4. Shelters can post their info about pets and adoption information.
## Approach 
* Project Businese Rules:  
1. Object: Adopter, Pet, Shelter, Role, 
2. Relationships:  
    i. One Adopter could adopt many Pets.   
    ii. One Adopter could only have one role.   
    iii. One Shelter could have many Pets.   
    iV. One Adopter could have many favorite pets.   
    V. One Pet could have many people who are interested in them.  
    Vi. One Pet can have only one shelter.  
    ![database](https://raw.githubusercontent.com/xu9449/BudE_Plus/master/image/BudE%2B.png)
* Project Approach  
    i.      Created adopters, pets, shelters, roles.   
    ii.     Used Hibernate to do the database schema migration.  
    iii.    Used JDBC to connect project with Postgres  
    iv.     Configured Spring Security for Authentication  
    v.      Created repository, service and did test  
    vi.     Created Controllers and Restful APIs  
    Vii.    Used Postman to interact with back-end project   
    Viii.   Did mock test for AWS S3 Storage service.  
    iX.     Integrated third-party application AWS SQS and did Mock test.

## Build project   
1.Clone the project
````
git clone https://github.com/xu9449/Pet-Adoption-Helper.git  
````
2.Install docker if needed. Please use docker maven openjdk and select the 3.6-jdk-8 version.  

[3.6.0-jdk-8, 3.6-jdk-8, 3-jdk-8 (jdk-8/Dockerfile)](https://hub.docker.com/_/maven?tab=description)

3.Open a new command line window and Spin up the PostgreSql database server using Postgres docker image
```
docker pull postgres
```
```
docker run --name ${dealerDB2} -e POSTGRES_DB=${pethelp} -e POSTGRES_USER=${admin} -e POSTGRES_PASSWORD=${password} -p 5430:5432 -d postgres
```

4.Create Unit database on PGAdmin for unit testing
````
create database pethelp_database_demo;
````
5.Environment properties configuration
````
location:./src/main/resources/META-INF/env
   
Template:
database.driverName=${driverName}
database.url=${url}
database.port=${port}
database.name=${name}
database.username=${username}
database.password=${password}
   
mvn compile -Dspring.profiles.active=${env}
````

6.Schema Flyway migration for creating tables in database  
 ````
mvn compile flyway:migrate -P unit -Ddb_username=${username} -Ddb_url=localhost:${containerport}/${databasename} -Ddb_password=${password} 
````
## Test

* Package installation with 2 time. 
1. run this commend on {project-name} folder. 
2. run this commend on src folder.
  ```
  mvn clean compile install -DskipTests=true
  ```
* Run the test with the command. All the Test are done using JUnit and Mockito
````
mvn compile test -Dspring.profiles.active=${unit} -Daws.region=${region} -Ddb_url=${localhost:5432/pigge_unit} -Ddb.username=${username} -Ddb.password=${password} 
````
## API guideline and Reference DEMO
* You need to sign up for authority to get access.
  Make a get request in this address to create a new account.
````
GET - http://localhost:8080/auth/signUp
````

Put the request body.
````
{
    "name": "UserForTest",
    "email": "UserForTest@gmail.com",
    "password": "123456789"
}
````

Then you can get the response login token.

Demo Screen Shot:
![screenshot_signup](https://github.com/xu9449/Pet-Adoption-Helper/blob/master/image/screenshot_signup.png)

* Then we can login with the token 
make a post request in the address:
````
POST - http://localhost:8080/auth
````

* Put the request body.（ You can chose login with username or email)
````
{
    "email": "UserForTest@gmail.com",
    "password": "123456789"
}
````

* Then you can get the response like:
````
{
    "token": "...."
}
````
* This token is need for the future access other api. So you don't need to login to the every API.
 DEMO screen shoot:
 ![screenshot_signin](https://github.com/xu9449/Pet-Adoption-Helper/blob/master/image/screenshot_signin.png)

* Then you can get some info with the token
DEMO screen shoot:
![screenshot_findshelters](https://github.com/xu9449/Pet-Adoption-Helper/blob/master/image/screenshot_findshelters.png)
## CICD  
You should have completed the following stages before you work with DevOps engineer.

1. Upload source code to GitHub repository
2. Fulfill unit test stage in docker container
3. Package .war file in docker container
4. Build Docker image with .war file and Dockerfile
5. Launch containerized application successfully
## GitHub
GitHub
Make sure the source code in the github is the latest(runnable) version.

**IMPORTANT: DO NOT INCLUDE ANY CREDENTIAL IN THE CODE.**

## Unit Test
>Use `Docker` to pull `Maven` image and run an interactive container.
>
    docker pull maven:3.6.0-jdk-8
    docker run -it maven:3.6.0-jdk-8 /bin/bash

>Use `Git` to retrieve source code from `GitHub`.
>
    git clone <repository_url>
    
>Get into the project's folder, then use `Flyway` to migrate data.
>
    mvn clean compile flyway:migrate -Ddatabase.url=jdbc:postgresql://${database_url}:5432/${database_name} 
    -Ddatabase.user=${user_name} -Ddatabase.password=${password}
    
Notice: Cause we are currently run in the container. Thus, the database connection is no longer localhost:5432.
You should inspect `postgreSQL` server container to find the IP address. Find the internal IP address of the container by using:
    
    docker inspect ${container_id} | grep "IPAddress"
    
>Run unit tests in the container.
>
    mvn test -Ddatabase.url=jdbc:postgresql://${database_url}:5432/${database_name} -Dspring.profiles.active=unit -Ddatabase.user=${user_name} 
    -Ddatabase.password=${password} -Daws.accessKeyId=${access_key} -Daws.secretKey=${secret_key} 
    -Ddatabase.dialect=org.hibernate.dialect.PostgreSQL9Dialect -Ddatabase.driver=org.postgresql.Driver




