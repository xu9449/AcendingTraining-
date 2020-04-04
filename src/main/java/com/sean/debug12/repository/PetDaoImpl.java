package com.sean.debug12.repository;

import com.sean.debug12.model.Pet;
import com.sean.debug12.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


import static org.hibernate.cfg.AvailableSettings.USER;

@Repository
public class PetDaoImpl implements PetDao{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean save (Pet pet){
        Transaction transaction = null;
        boolean isSuccess = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try  {
            transaction = session.beginTransaction();
            session.save(pet);
            transaction.commit();
            session.close();
        }
        catch(Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error("failure to instert record", e);
            session.close();
        }
        return isSuccess;

    }

    @Override
    public boolean update(String name, boolean adoptable) {
        String msg;
        String hql = "UPDATE Pet as p set p.adoptable = :adoptable where p.name = :name";

        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Pet> query = session.createQuery(hql);
            query.setParameter("name", name);
            query.setParameter("adoptable", adoptable);

            transaction = session.beginTransaction();
            transaction.commit();
            msg = String.format("The employee %s was updated, the adoptable condition is : %d", name, "Ready for adopt");
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            msg = e.getMessage();
        }

        logger.debug(msg);
        return isSuccess;
    }


    @Override
    public List<Pet> getPets() {
//FROM Shelter s LEFT JOIN FETCH s.pets
        List<Pet> pets = new ArrayList<>();
//        String hql = "FROM Pet";
        String hql = "FROM Pet p LEFT JOIN FETCH p.shelter";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Pet> query = session.createQuery(hql);
            pets = query.list();

            return pets;
        } catch (Exception e) {
            logger.error("failure to retrieve data record", e);

            return pets;
        }
    }

    @Override
    public boolean delete(Pet pet) {
        String hql = "DELETE Pet as p where p.id = :Id";
        int deletedCount = 0;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query<Pet> query = session.createQuery(hql);
            query.setParameter("Id", pet.getId());
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

    @Override
    public Pet getPetByName(String name) {
        String hql = "FROM Pet as p left join fetch p.adopter where p.name = :name";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Pet> query = session.createQuery(hql);
            query.setParameter("name", name);

            return query.uniqueResult();
        }
    }
}
