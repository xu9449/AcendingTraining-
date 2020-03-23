Alter table adopter
add constraint adopter_pet_fk FOREIGN KEY (pet_id)
    REFERENCES pet(id);

Alter table pet
add constraint shelter_pk FOREIGN KEY (shelter_id)
REFERENCES shelter(id);