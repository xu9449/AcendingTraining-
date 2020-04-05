package com.sean.debug12.service;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.repository.AdopterDao;
import com.sean.debug12.repository.ShelterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdopterService {
    @Autowired
    private AdopterDao adopterDao;

    public Adopter save(Adopter adopter) {
        Adopter a1 = adopterDao.save(adopter);
        return a1;
    }

    public boolean update(Adopter adopter){
        return adopterDao.update(adopter);
    }

    public boolean delete(Adopter adopter) {

        return adopterDao.delete(adopter);
    }

    public List<Adopter> getAdopters() {
        return adopterDao.getAdopters();
    }


    public Adopter getAdopterEagerBy(long Id) {

        return adopterDao.getAdopterEagerById(Id);
    }

    public Adopter getShelterById(long Id) {
        return adopterDao.getAdopterById(Id);
    }

    public Adopter getAdopterByName(String name) {
        return adopterDao.getAdopterByName(name);
    }

}
