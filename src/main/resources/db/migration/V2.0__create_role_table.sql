CREATE TABLE roles (
  id                   BIGSERIAL NOT NULL,
  name                 VARCHAR(30) not null unique,
  allowed_resource     VARCHAR(200),
  allowed_read         BOOLEAN not null default FALSE,
  allowed_create       BOOLEAN not null default FALSE,
  allowed_update       BOOLEAN not null default FALSE,
  allowed_delete       BOOLEAN not null default FALSE
);

ALTER TABLE roles ADD CONSTRAINT role_pk PRIMARY KEY ( id );