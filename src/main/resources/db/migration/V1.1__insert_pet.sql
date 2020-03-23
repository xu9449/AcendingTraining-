CREATE TABLE Shelter (
    /*id                INTEGER NOT NULL default nextval('department_id_seq'), */
    id                SERIAL NOT NULL,
    name              VARCHAR(30) not null unique,
    tel               VARCHAR(150),
    email             VARCHAR(50),
    location          VARCHAR(100),
    description       VARCHAR(150),
    principle         VARCHAR(50)
);

CREATE TABLE Pet (
    /*id                INTEGER NOT NULL default nextval('department_id_seq'), */
id                SERIAL NOT NULL,
sex               VARCHAR (50),
breed             VARCHAR(100),
name              VARCHAR(30) not null unique,
age               VARCHAR(150),
shelter           INTEGER NOT NUll,
description       VARCHAR(150),
adoptable         boolean
);

CREATE TABLE adopter (
    /*id                INTEGER NOT NULL default nextval('department_id_seq'), */
id                SERIAL NOT NULL,
name              VARCHAR(30) not null unique,
tel               VARCHAR(40),
email             VARCHAR(50),
location          VARCHAR(100),
description       VARCHAR(150),
adopt_date        TIMESTAMP,
pet_id            INTEGER

);


