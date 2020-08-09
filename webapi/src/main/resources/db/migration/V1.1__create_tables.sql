CREATE TABLE shelters (
    shelter_id                BIGSERIAL NOT NULL,
    shelter_name              VARCHAR(30) not null,
    shelter_tel               VARCHAR(30),
    shelter_email             VARCHAR(50),
    shelter_location          VARCHAR(64),
    shelter_description       VARCHAR(512),
    shelter_principle         VARCHAR(50)
);


CREATE TABLE pets (
    pet_id                BIGSERIAL NOT NULL,
    pet_name              VARCHAR(30) not null,
    pet_sex               VARCHAR (10),
    pet_age               VARCHAR(30),
    pet_size              VARCHAR (10),
    pet_breed             VARCHAR(50),
    pet_description       VARCHAR(512),
    pet_adoptable         BOOLEAN not null default TRUE,
    pet_shelter_id        BIGINT,
    pet_adopter_id        BIGINT
);


CREATE TABLE users (
    user_id                BIGSERIAL NOT NULL,
--    user_name              VARCHAR(30) not null,
    user_password          VARCHAR(64) not null,
    user_tel               VARCHAR(40) ,
    user_email             VARCHAR(50) not null unique,
    user_location          VARCHAR(64),
    user_description       VARCHAR(512),
    user_secret_key        VARCHAR(512),
    user_first_name        VARCHAR(30),
    user_last_name         VARCHAR(30),
    user_image_url         VARCHAR(512),
    --adopt_date        TIMESTAMP,
    user_pet_id            BIGINT
);

CREATE TABLE roles (
    role_id                   BIGSERIAL NOT NULL,
    role_name                 VARCHAR(30) not null unique,
    role_allowed_resource     VARCHAR(200),
    role_allowed_read         BOOLEAN not null default FALSE,
    role_allowed_create       BOOLEAN not null default FALSE,
    role_allowed_update       BOOLEAN not null default FALSE,
    role_allowed_delete       BOOLEAN not null default FALSE
);

ALTER TABLE roles
ADD CONSTRAINT role_pk PRIMARY KEY ( role_id );

Alter table shelters
Add constraint shelters_pk PRIMARY KEY (shelter_id);

Alter table pets
Add constraint pets_pk PRIMARY KEY (pet_id);

Alter table users
Add constraint adopters_pk PRIMARY KEY (user_id);






