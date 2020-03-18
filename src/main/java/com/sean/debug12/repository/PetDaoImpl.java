package com.sean.debug12.repository;

import com.sean.debug12.model.Pet;
import com.sean.debug12.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class PetDaoImpl implements PetDao{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Pet save (Pet pet){
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try  {
            transaction = session.beginTransaction();
            session.save(pet);
            transaction.commit();
            session.close();
            return pet;
        }
        catch(Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("failure to instert record", e);
            session.close();
            return null;
        }

    }

//    @Override
//    public boolean delete(Pet pet) {}
//    String hql = "DELETE Department as dep where dep.id = :Id";
//    int deletedCount = 0;
//    Transaction transaction = null;
//    Session session = HibernateUtil.getSessionFactory().openSession();
//    try{
//        transaction = session.beginTransaction();
//        Query<Pet> query = session.createQuery(hql);
//        query.setParameter("Id", pet.getId());
//        deletedCount = query.executeUpdate();
//        transaction.commit();
//        session.close();
//        return deletedCount >= 1? true: false;
//    }
//    catch(HibernateException e) {
//        if (transaction != null) transaction.rollback();
//        session.close();
//
//    }

    @Override
    public List<Pet> getPets() {
        List<Pet> pets = new ArrayList<>();
        String hql = "FROM Pet";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Pet> query = session.createQuery(hql);
            pets = query.list();
            session.close();
            return pets;
        } catch (Exception e) {
            logger.error("failure to retrieve data record", e);
            session.close();
            return pets;
        }
    }

    @Override
    public boolean delete(Pet pet) {
        String hql = "DELETE Pet as pet where pet.id = :Id";
        int deletedCount = 0;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query<Pet> query = session.createQuery(hql);
            query.setParameter("id", pet.getId());
            deletedCount = query.executeUpdate();
            transaction.commit();
            session.close();
            return deletedCount >= 1 ? true:false;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            session.close();
            logger.error("unable to delete record", e);
        }
        return false;
    }

}
