package com.sean.debug12.repository;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Pet;
import com.sean.debug12.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

//@Repository
//public class AdopterDaoImpl {
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    private PetDao petDao;
//
//    @Override
//    public boolean save(Adopter adopter, String petName) {
//        String msg = String.format("The Adopter %s was inserted into the table.", adopter.toString());
//        Transaction transaction = null;
//        boolean isSuccess = false;
//
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Pet pet = petDao.getPetByName(petName);
//
//            if (pet != null) {
//                transaction = session.beginTransaction();
//                adopter.setEmployee(employee);
//                session.save(account);
//                transaction.commit();
//                isSuccess = true;
//            }
//            else {
//                msg = String.format("The employee [%s] doesn't exist.", employeeName);
//            }
//        }
//        catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            msg = e.getMessage();
//        }
//
//        logger.debug(msg);
//        return isSuccess;
//    }
//}
