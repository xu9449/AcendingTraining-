package com.sean.debug12.service;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.repository.ShelterDao;
import com.sean.debug12.repository.ShelterDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterService {

    @Autowired
    private ShelterDao shelterDao;

    public Shelter save(Shelter shelter) {
        Shelter s1 = shelterDao.save(shelter);
        return s1;
    }

    public boolean update(Shelter shelter) {
        return shelterDao.update(shelter);
    }

    public boolean delete(Shelter shelter) {
        return shelterDao.delete(shelter);
    }

    public List<Shelter> getShelters() {
        return shelterDao.getShelters();
    }


    public Shelter getShelterEagerBy(long Id) {
        return shelterDao.getShelterEagerBy(Id);
    }

    public Shelter getShelterById(long Id) {
        return shelterDao.getShelterBy(Id);
    }

    public Shelter getShelterByName(String name) {
        return shelterDao.getShelterByName(name);
    }


}
