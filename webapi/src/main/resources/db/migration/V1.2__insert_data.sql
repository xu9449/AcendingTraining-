insert into pets (name, sex, breed, age, shelter_id, adoptable, description) values
('Pepper', 'M', 'Domestic Short Hair', '18 mohs', '1',TRUE, 'Perfect Condition'),
('Shadow','F', 'Domestic Short Hair', '2 years', '1',TRUE, 'Perfect Condition'),
('Eva','M', 'Domestic Medium Hair', '3 years', '2',TRUE, 'Perfect Condition'),
('Oki','F', 'Domestic Long Hair', '12 years', '1',TRUE, 'Perfect Condition')
;
commit;

insert into shelters (name, tel, email, location, description, principle ) values
('falls church', '222-444-2213', 'xu9449@gmail.com', 'Room 100, 999 Washington Ave. Falls Church, VA', '1', 'Sean Xu' ),
('Silver Spring', '222-444-2213', 'xu9448@gmail.com', 'Room 101, 999 Washington Ave. Falls Church, VA', '2', 'Nancy Chen'),
('Crystal City', '222-444-2213', 'xu9447@gmail.com', 'Room 102, 999 Washington Ave. Falls Church, VA', '4', 'Eric Liu'),
('Friendship Height', '222-444-2213', 'xu9446@gmail.com', 'Room 103, 999 Washington Ave. Falls Church, VA', '6', 'Fan')
;
commit;

insert into adopters (name, password, tel, email, location, description, first_name, last_name, pet_id ) values
('Sean Xu', 'password','222-444-2213', 'xu9449@gmail.com', 'Room 100, 999 Washington Ave. Falls Church, VA', '1','Sean','Xu', '2' ),
('Alex Jira', 'password', '222-444-2213', 'xu944@gmail.com', 'Room 101, 999 Washington Ave. Falls Church, VA', '2','Alex', 'Jira', '3'),
('Max Brown', 'password', '222-444-2213', 'xu94@gmail.com', 'Room 102, 999 Washington Ave. Falls Church, VA', '4', 'Max', 'Brown','1'),
('Hugh Jackman', 'password', '222-444-2213', 'xu9@gmail.com', 'Room 103, 999 Washington Ave. Falls Church, VA', '6','Hugh','Jackman', '4')
;
commit;

Alter table adopters
add constraint adopters_pets_fk FOREIGN KEY (pet_id)
REFERENCES pets(id);

Alter table pets
add constraint shelters_pets_fk FOREIGN KEY (shelter_id)
REFERENCES shelters(id);

Alter table pets
add constraint adopters_pets_fk FOREIGN KEY (adopter_id)
REFERENCES adopters(id);