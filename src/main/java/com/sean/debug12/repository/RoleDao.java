package com.sean.debug12.repository;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Role;

public interface RoleDao {
    Role getRoleByName(String roleName);
    Role getRoleId(Long Id);

}
