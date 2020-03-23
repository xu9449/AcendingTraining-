--Alter table pet
--add constraint pet_shelter_fk FOREIGN KEY (shelter)
--    REFERENCES shelter(id);

Alter table adopter
add constraint adopter_pet_fk FOREIGN KEY (pet_id)
    REFERENCES pet(id);