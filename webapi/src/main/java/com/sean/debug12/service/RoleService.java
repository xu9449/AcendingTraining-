package com.sean.debug12.service;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Role;
import main.java.com.sean.debug12.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }
}
