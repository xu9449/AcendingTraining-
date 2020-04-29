package com.sean.debug12.service;

import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.repository.PetDao;
import com.sean.debug12.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetDao petDao;

        private Logger logger = LoggerFactory.getLogger(getClass());



        public boolean save (Pet pet){
            boolean isSuccess = petDao.save(pet);
            return isSuccess;

        }

        public List<Pet> getPets() {
            return petDao.getPets();
        }


        public Pet getPetById(long Id) {
            return petDao.getPetById(Id);
        }

        public boolean update(Pet pet){
            return petDao.update(pet);
        }


        public boolean delete(Pet pet) {
           return petDao.delete(pet);
        }

//    public Pet getPetEagerBy(Integer id) {
//        String hql = "From Pet d LEFT JOIN FETCH d.emplyees where d.id = Id";
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            Query<Pet> query = session.createQuery(hql);
//            query.setParameter("Id", id);
//            Pet result = query.uniqueResult();
//            session.close();
//            return result;
//        }catch (HibernateException e) {
//            logger.error("failure to retrieve date record", e);
//            return null;
//        }
//    }
    }

