insert into roles (role_name, role_allowed_resource, role_allowed_read, role_allowed_create, role_allowed_update, role_allowed_delete) values
('Admin', '/', TRUE , TRUE, TRUE, TRUE),
('Manager', '/depts,/departments,/employees,/ems,/acnts,/accounts', TRUE, TRUE, TRUE, FALSE),
('user', '/employees,/ems,/acnts,/accounts', TRUE, FALSE, FALSE, FALSE)
;
commit;

insert into users_roles values
(1, 1),
(2, 2),
(3, 3),
(1, 2)
;
commit;