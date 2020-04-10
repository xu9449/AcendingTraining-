# Ascending Training course by Liwei Wang & Ryo Hang

## Description  
A website to help people find their ideal pets.  
This application is developed using Spring Boot, Spring Data, Spring RESTful web services, Maven, PostgreSql, Docker, Amazon SQS, Amazon S3.
## Assumption 
Users are provided shelters and pets information based on the authorities.
The users information need to be created before searching.
The relation between shelter and pets is "One to Many", the relationship between adopter and pets statistics is "One to Many".
## Approach 
Created Adopter, Shelter, Pets, and Roles object, and created related table and col in the database.
The relation between Shelter and Pets is One to Many, the Shelter_id will be the foreign key and will be stored in the pet table.
The relation between Adopters and Pets Statistics is One to Many, the adopter_id will be the foreign key and will be stored in the pet table.
## Build project   
1. Clone the project
    git clone https://github.com/xu9449/Pet-Adoption-Helper.git
Install docker if needed. Please use docker maven openjdk and select the 3.6-jdk-8 version.
## compile

## run migration

## package

## API guideline

## screenshots