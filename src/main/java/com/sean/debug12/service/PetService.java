package com.sean.debug12.service;

import com.sean.debug12.repository.PetDao;
import org.springframework.beans.factory.annotation.Autowired;

public class PetService {
    @Autowired
    private PetDao petDao;
}
