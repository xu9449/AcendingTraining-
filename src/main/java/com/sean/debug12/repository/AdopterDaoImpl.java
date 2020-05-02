package com.sean.debug12.repository;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Role;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdopterDaoImpl implements AdopterDao {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Adopter save(Adopter adopter) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(adopter);
            transaction.commit();
            session.close();
            return adopter;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Failure to insert record", e);
        }
        if (adopter != null) logger.debug("The adopter was inserted into database");
        return null;
    }

    @Override
    public boolean update(Adopter adopter) {
        Transaction transaction = null;
        boolean isSuccess = true;
        // TODO: change to dependency injection
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(adopter);
            transaction.commit();
            session.close();
            return isSuccess;
        } catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error("Failure to update record", e.getMessage());
            return isSuccess;
        }

    }

    @Override
    public boolean delete(Adopter adopter) {
        String hql = "DELETE Adopter as a where a.id =:Id";
        int deletedCount = 0;
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Query<Adopter> query = session.createQuery(hql);
            query.setParameter("Id", adopter.getId());
            deletedCount = query.executeUpdate();
            transaction.commit();

            return deletedCount >= 1 ? true : false;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();

            logger.error("unable to delete record", e);
        }
        return false;
    }


    @Override
    public List<Adopter> getAdopters() {
        List<Adopter> adopters = new ArrayList<>();
        String hql = "From Adopter";
        Session session = sessionFactory.openSession();
        try {
            Query<Adopter> query = session.createQuery(hql);
            adopters = query.list();
            session.close();
            return adopters;
        } catch (Exception e) {
            logger.debug(e.getMessage());
            session.close();
            return null;
        }
    }

    @Override
    public Adopter getAdopterById(Long Id) {
        String hql = "FROM Adopter a where a.id = :Id";
        Session session = sessionFactory.openSession();
        try {
            Query<Adopter> query = session.createQuery(hql);
            query.setParameter("Id", Id);
            Adopter result = query.uniqueResult();
            session.close();
            return result;
        } catch (Exception e) {
            logger.debug(e.getMessage());
            session.close();
            return null;
        }
    }

    @Override
    public Adopter getAdopterEagerById(Long Id) {
//        String hql = "FROM Adopter a LEFT JOIN FETCH a.pets where a.id = :Id";
        String hql = "FROM Adopter a LEFT JOIN FETCH a.roles where a.id = :Id";
        Session session = sessionFactory.openSession();
        try {
            Query<Adopter> query = session.createQuery(hql);
            query.setParameter("Id", Id);
            Adopter result = query.uniqueResult();
            session.close();
            return result;
        } catch (Exception e) {
            logger.debug(e.getMessage());
            session.close();
            return null;
        }
    }

    @Override
    public Adopter getAdopterByName(String adopterName) {
        if (adopterName == null) return null;
        String hql = "FROM Adopter as a LEFT JOIN FETCH a.pets where a.name = :name";
        try (Session session = sessionFactory.openSession()) {
            Query<Adopter> query = session.createQuery(hql);
            query.setParameter("name", adopterName);
            return query.uniqueResult();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean adopt(Adopter adopter, String petName) {
        return false;
    }

    @Override
    public Adopter getAdopterByCredentials(String email, String password) throws Exception {
        String hql = "FROM Adopter as a where (lower(a.email) = :email or lower(a.name) =:email) and a.password = :password";
        logger.debug(String.format("Adopter email: %s, password: %s", email, password));
        try (Session session = sessionFactory.openSession()) {
            Query<Adopter> query = session.createQuery(hql);
            query.setParameter("email", email.toLowerCase().trim());
            query.setParameter("password", password);
            return query.uniqueResult();
        } catch (Exception e) {
            throw new Exception("can't find user record or session");
        }
    }


}
