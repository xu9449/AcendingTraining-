update pet
SET Adopter = 01;
where name = 'Pepper';

update pet
SET Adopter = 02;
where name = 'Shadow';

Alter table pet
    add constraint adopter_pk FOREIGN KEY (Adopter)
        references adopter (id);ƒ