CREATE TABLE images (
  id                BIGSERIAL NOT NULL,
  file_name         VARCHAR(512) not null,
  upload_time       TIMESTAMP,
  s3key             VARCHAR(150),
  url               VARCHAR(512),
  extension         VARCHAR(150),
  uuid              VARCHAR(300),
  description       VARCHAR(512),
  pet_id            BIGINT,
  adopter_id        BIGINT
);
ALTER TABLE images ADD CONSTRAINT images_pk PRIMARY KEY(id);

ALTER TABLE images
    ADD CONSTRAINT images_pet_fk FOREIGN KEY (pet_id)
    REFERENCES pets(id);

ALTER TABLE images
ADD CONSTRAINT images_adopter_fk FOREIGN KEY (adopter_id)
REFERENCES adopters(id);