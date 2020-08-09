CREATE TABLE images (
  image_id                BIGSERIAL NOT NULL,
  image_file_name         VARCHAR(30) not null,
  image_upload_time       TIMESTAMP,
  image_s3key             VARCHAR(125),
  image_url               VARCHAR(125),
  image_extension         VARCHAR(150),
  image_uuid              VARCHAR(300),
  image_description       VARCHAR(512),
  image_pet_id            BIGINT,
  image_adopter_id        BIGINT
);
ALTER TABLE images ADD CONSTRAINT images_pk PRIMARY KEY(image_id);

ALTER TABLE images
    ADD CONSTRAINT images_pet_fk FOREIGN KEY (image_pet_id)
    REFERENCES pets(pet_id);

ALTER TABLE images
ADD CONSTRAINT images_adopter_fk FOREIGN KEY (image_adopter_id)
REFERENCES users(user_id);