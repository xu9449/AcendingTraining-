CREATE TABLE adopters_roles (
  adopter_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL
);

ALTER TABLE adopters_roles
  ADD CONSTRAINT adopters_fk FOREIGN KEY (adopter_id)
      REFERENCES adopters(id);

ALTER TABLE adopters_roles
  ADD CONSTRAINT roles_fk FOREIGN KEY (role_id)
      REFERENCES roles(id);

