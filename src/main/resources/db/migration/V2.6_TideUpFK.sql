Alter table pet
add constraint shelter_pk FOREIGN KEY (shelter_id)
REFERENCES shelter(id);

Alter table adopter
ADD pet_id INTEGER;