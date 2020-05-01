CREATE TABLE shelters (
    id                BIGSERIAL NOT NULL,
    name              VARCHAR(30) not null unique,
    tel               VARCHAR(150),
    email             VARCHAR(50),
    location          VARCHAR(100),
    description       VARCHAR(512),
    principle         VARCHAR(50)
);


CREATE TABLE pets (
id                BIGSERIAL NOT NULL,
name              VARCHAR(30) not null unique,
sex               VARCHAR (10),
age               VARCHAR(30),
size              VARCHAR (10),
breed             VARCHAR(50),
description       VARCHAR(512),
adoptable         BOOLEAN not null default TRUE,
shelter_id        BIGINT,
adopter_id        BIGINT
);


CREATE TABLE adopters (
id                BIGSERIAL NOT NULL,
name              VARCHAR(30) not null unique,
password          VARCHAR(64),
tel               VARCHAR(40),
email             VARCHAR(50) not null unique,
location          VARCHAR(100),
description       VARCHAR(512),
secret_key        VARCHAR(512),
first_name        VARCHAR(30),
last_name         VARCHAR(30),
image_url         VARCHAR(512),
adopt_date        TIMESTAMP,
pet_id            BIGINT
);

CREATE TABLE roles (
    id                   BIGSERIAL NOT NULL,
    name                 VARCHAR(30) not null unique,
    allowed_resource     VARCHAR(200),
    allowed_read         BOOLEAN not null default FALSE,
    allowed_create       BOOLEAN not null default FALSE,
    allowed_update       BOOLEAN not null default FALSE,
    allowed_delete       BOOLEAN not null default FALSE
);

ALTER TABLE roles
ADD CONSTRAINT role_pk PRIMARY KEY ( id );

Alter table shelters
Add constraint shelters_pk PRIMARY KEY (id);

Alter table pets
Add constraint pets_pk PRIMARY KEY (id);

Alter table adopters
Add constraint adopters_pk PRIMARY KEY (id);






