insert into roles (name, allowed_resource, allowed_read, allowed_create, allowed_update, allowed_delete) values
('Admin', '/', TRUE , TRUE, TRUE, TRUE),
('Manager', '/depts,/departments,/employees,/ems,/acnts,/accounts', TRUE, TRUE, TRUE, FALSE),
('user', '/employees,/ems,/acnts,/accounts', TRUE, FALSE, FALSE, FALSE)
;
commit;

insert into adopters_roles values
(1, 1),
(2, 2),
(3, 3),
(1, 2),
(1, 3)
;
commit;