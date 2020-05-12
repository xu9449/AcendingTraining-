# PetHelp Website by Kexin XU

## Description  
A website to help people find their ideal pets.  
This application is developed using Spring Boot, Spring Data, Spring RESTful web services, Maven, PostgreSql, Docker, Amazon SQS, Amazon S3.  
## Project Technical Overview:
This application is developed in Spring Framework by using Spring Boot, Spring Data, Hibernate, Spring RESTful web services, Postman, Maven, PostgresSql, Docker, Amazon SQS, and Amazon S3.  
## Assumption 
Users are provided shelters and pets information based on the authorities.
The users information need to be created before searching.
The relation between shelter and pets is "One to Many", the relationship between adopter and pets statistics is "One to Many".
## Approach 
* Project Businese Rules:  
1. Object: Adopter, Pet, Shelter, Role, 
2. Relationships:
    i. One Adopter could adopt many Pets.   
    ii. One Adopter could only have one role.   
    iii. One Shelter could have many Pets.   
    iV. One Adopter could have many favorite pets.   
    V. One pet could have many people who are interested in them.  
* Project Approach
    i. Created adopters, pets, shelters, roles
    ii. Used Hibernate to do the database schema migration
    iii. Used JDBC to connect project with Postgres  
    iv. Configured Spring Security for Authentication  
    v. Created repository, service and did test  
    vi. Created Controllers and Restful APIs  
    Vii. Used Postman to interact with back-end project    
## Configure local environment  
```
docker pull postgres

docker run --name ${PostgresContainerName} -e POSTGRES_USER=${username} -e POSTGRES_PASSWORD=${password} -e POSTGRES_DB=${databaseName} -p ${hostport}:${containerport} -d postgres
```

## Environment properity configuration
```

```

## Flyway migration
```
mvn compile flyway:migrate -P unit -Ddb_username=${username} -Ddb_url=localhost:${containerport}/${databasename} -Ddb_password=${password} 
```

## Build project   
1. Clone the project
    git clone https://github.com/xu9449/Pet-Adoption-Helper.git  
2. Install docker if needed. Please use docker maven openjdk and select the 3.6-jdk-8 version.  
    [3.6.0-jdk-8, 3.6-jdk-8, 3-jdk-8 (jdk-8/Dockerfile)](https://hub.docker.com/_/maven?tab=description)
3. Open a new command line window and Spin up the PostgreSql database server using Postgres docker image
```
docker pull postgres
```
```
docker run --name ${dealerDB2} -e POSTGRES_DB=${pethelp} -e POSTGRES_USER=${admin} -e POSTGRES_PASSWORD=${password} -p 5430:5432 -d postgres
```

4.Create Unit database on PGAdmin for unit testing

5.Update application.properties and share-runtime.properties as following format:

6.Package installation with 2 time. 1. run this commend on debug12 folder and 2. run this commend on src folder.
  ```
  mvn clean compile install -DskipTests=true
  ```
## compile

## run migration

## package

## API guideline

## screenshots
