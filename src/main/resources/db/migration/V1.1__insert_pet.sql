CREATE TABLE Shelter (
    id                BIGSERIAL NOT NULL,
    name              VARCHAR(30) not null unique,
    tel               VARCHAR(150),
    email             VARCHAR(50),
    location          VARCHAR(100),
    description       VARCHAR(150),
    principle         VARCHAR(50)
);




CREATE TABLE Pet (
id                BIGSERIAL NOT NULL,
name              VARCHAR(30) not null unique,
sex               VARCHAR (50),
age               VARCHAR(150),
breed             VARCHAR(100),
description       VARCHAR(150),
adoptable         boolean,
shelter_id        BIGINT
);


CREATE TABLE adopter (
id                BIGSERIAL NOT NULL,
name              VARCHAR(30) not null unique,
tel               VARCHAR(40),
email             VARCHAR(50),
location          VARCHAR(100),
description       VARCHAR(150),
adopt_date        TIMESTAMP,
pet_id            BIGINT
);


Alter table shelter
Add constraint shelter_pk PRIMARY KEY (id);

Alter table pet
Add constraint pet_pk PRIMARY KEY (id);

Alter table adopter
Add constraint adopter_pk PRIMARY KEY (id);



