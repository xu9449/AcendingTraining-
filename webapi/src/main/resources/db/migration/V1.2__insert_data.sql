insert into pets (pet_name, pet_sex, pet_breed, pet_age, pet_shelter_id, pet_adoptable, pet_description) values
('Pepper', 'M', 'Domestic Short Hair', '18 mohs', '1',TRUE, 'Perfect Condition'),
('Shadow','F', 'Domestic Short Hair', '2 years', '1',TRUE, 'Perfect Condition'),
('Eva','M', 'Domestic Medium Hair', '3 years', '2',TRUE, 'Perfect Condition'),
('Oki','F', 'Domestic Long Hair', '12 years', '1',TRUE, 'Perfect Condition')
;
commit;

insert into shelters (shelter_name, shelter_tel, shelter_email, shelter_location, shelter_description, shelter_principle ) values
('falls church', '222-444-2213', 'xu9449@gmail.com', 'Room 100, 999 Washington Ave. Falls Church, VA', '1', 'Sean Xu' ),
('Silver Spring', '222-444-2213', 'xu9448@gmail.com', 'Room 101, 999 Washington Ave. Falls Church, VA', '2', 'Nancy Chen'),
('Crystal City', '222-444-2213', 'xu9447@gmail.com', 'Room 102, 999 Washington Ave. Falls Church, VA', '4', 'Eric Liu'),
('Friendship Height', '222-444-2213', 'xu9446@gmail.com', 'Room 103, 999 Washington Ave. Falls Church, VA', '6', 'Fan')
;
commit;

insert into users (user_password, user_tel, user_email, user_location, user_description, user_first_name, user_last_name, user_pet_id ) values
('password','222-444-2213', 'xu9449@gmail.com', 'Room 100, 999 Washington Ave. Falls Church, VA', '1','Sean','Xu', '2' ),
('password', '222-444-2213', 'xu944@gmail.com', 'Room 101, 999 Washington Ave. Falls Church, VA', '2','Alex', 'Jira', '3'),
('password', '222-444-2213', 'xu94@gmail.com', 'Room 102, 999 Washington Ave. Falls Church, VA', '4', 'Max', 'Brown','1'),
('password', '222-444-2213', 'xu9@gmail.com', 'Room 103, 999 Washington Ave. Falls Church, VA', '6','Hugh','Jackman', '4')
;
commit;

Alter table users
add constraint users_pets_fk FOREIGN KEY (user_pet_id)
REFERENCES pets(pet_id);

Alter table pets
add constraint shelters_pets_fk FOREIGN KEY (pet_shelter_id)
REFERENCES shelters(shelter_id);

Alter table pets
add constraint users_pets_fk FOREIGN KEY (pet_adopter_id)
REFERENCES users(user_id);