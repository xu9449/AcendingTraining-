package com.sean.debug12.repository;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// repository 告诉我们这个class生成的instance会写到spring的container里面
// ShelterDao sd = new ShelterDaoImpl();

@Repository
public class ShelterDaoImpl implements ShelterDao {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Shelter> getShelters() {
        List<Shelter> shelters = new ArrayList<>();
        String hql = "FROM Shelter";  // test if there is no left join
        Session session = sessionFactory.openSession();
        try {
            Query<Shelter> query = session.createQuery(hql);
            shelters = query.list();
            session.close();
            return shelters;
        } catch (Exception e) {
            logger.debug(e.getMessage());
            session.close();       // why we need to close the session here?
            return null;
        }
    }

//    @Override
//    public List<Shelter> getSheltersWithChildren() {
//        String hql = "FROM Shelter as s left join fetch s.pets as pets left join fetch pets.adopter";
//
//        try (Session session = sessionFactory.openSession()) {
//            Query<Shelter> query = session.createQuery(hql);
//            return query.list().stream().distinct().collect(Collectors.toList());
//        }
//    }

    @Override
    public Shelter getShelterEagerBy(Long Id) {
        String hql = "FROM Shelter s LEFT JOIN FETCH s.pets where s.id = :Id";
        Session session = sessionFactory.openSession();
        try {
            Query<Shelter> query = session.createQuery(hql);
            query.setParameter("Id", Id);
            Shelter result = query.uniqueResult();
            session.close();
            return result;
        } catch (Exception e) {
            logger.debug(e.getMessage());
            session.close();
            return null;
        }
    }

    @Override
    public Shelter getShelterBy(Long Id) {
        String hql = "FROM Shelter s where s.id = :Id";
        Session session = sessionFactory.openSession();
        try {
            Query<Shelter> query = session.createQuery(hql);
            query.setParameter("Id", Id);
            Shelter result = query.uniqueResult();
            session.close();
            return result;
        } catch (Exception e) {
            logger.debug(e.getMessage());
            session.close();
            return null;
        }
    }

    @Override
    public Shelter getShelterByName(String sheltName) {
        if (sheltName == null) return null;
        String hql = "From Shelter as s left join fetch s.pets as pet " +
                "left join fetch pet.adopter " + "WHERE lower(s.name)= :name";
        Session session = sessionFactory.openSession();
        // lower是啥意思
        try {
            Query<Shelter> query = session.createQuery(hql);
            query.setParameter("name", sheltName.toLowerCase());
            Shelter result = query.uniqueResult();
            session.close();
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage());
            session.close();
            return null;
        }

    }

    @Override
    public Shelter save(Shelter shelter) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(shelter);
            transaction.commit();
            return shelter;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Failure to insert record", e);
        }
        if (shelter != null) logger.debug("The shelter was inserted into database");
        return null;
    }

    @Override
    public boolean delete(Shelter shelter) {
        String hql = "DELETE Shelter as s where s.id =:Id";
        int deletedCount = 0;
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Query<Shelter> query = session.createQuery(hql);
            query.setParameter("Id", shelter.getId());
            deletedCount = query.executeUpdate();
            transaction.commit();
            session.close();
            return deletedCount >= 1 ? true : false;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();

            logger.error("unable to delete record", e);
            session.close();
            return false;
        }

    }

    @Override
    public Boolean update(Shelter shelter) {
        Transaction transaction = null;
        boolean isSuccess = true;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(shelter);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error("Failure to update record", e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public List<Object[]> getShelterAndPets(String sheltName) {
        if (sheltName == null) return null;
        String hql = "FROM Shelter as s left join s.pets where lower(s.name) = :name";

        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("name", sheltName.toLowerCase());

            List<Object[]> resultList = query.list();

            for (Object[] obj : resultList) {
                logger.debug(((Shelter) obj[0]).toString());
                logger.debug(((Pet) obj[1]).toString());
            }

            return resultList;
        }
    }

    @Override
    public List<Object[]> getShelterAndPetsAndAdopters(String sheltName) {
        if (sheltName == null) return null;

        String hql = "FROM Shelter as s " +
                "left join s.pets as pets " +
                "left join pets.adopter as adopter " +
                "where lower(s.name) = :name";

        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("name", sheltName.toLowerCase());

            List<Object[]> resultList = query.list();

            for (Object[] obj : resultList) {
                logger.debug(((Shelter) obj[0]).toString());
                logger.debug(((Pet) obj[1]).toString());
                logger.debug(((Adopter) obj[2]).toString());
            }

            return resultList;
        }
    }


}

