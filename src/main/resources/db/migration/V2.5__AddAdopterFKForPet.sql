ALTER TABLE pets
ADD adopter_id BIGINT;

Alter table pets
add constraint adopters_pets_fk FOREIGN KEY (adopter_id)
REFERENCES adopters(id);