package com.sean.debug12.repository;

import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// repository 告诉我们这个class生成的instance会写到spring的container里面
// ShelterDao sd = new ShelterDaoImpl();

@Repository
public class ShelterDaoImpl implements ShelterDao {

    private Logger logger = LoggerFactory.getLogger(getClass());
    ShelterDao shelterDao;
    PetDao petDao;


    @Override
    public List<Shelter> getShelters() {

        List<Shelter> shelters = new ArrayList<>();
        String hql = "FROM Shelter s LEFT JOIN FETCH s.pets";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Shelter> query = session.createQuery(hql);
            shelters = query.list();

            return shelters;
        }
        catch (Exception e){
            logger.debug(e.getMessage());

            return shelters;
        }
    }

    @Override
    public Shelter getShelterEagerBy(long Id) {

        String hql = "FROM Shelter s LEFT JOIN FETCH s.pets where s.id = :Id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Shelter> query = session.createQuery(hql);
            query.setParameter("Id", Id);
            Shelter result = query.uniqueResult();
            session.close();
            return result;
        }
        catch (Exception e){
            logger.debug(e.getMessage());
            session.close();
            return null;
        }
    }

    @Override
    public Shelter getShelterBy(long Id) {
        String hql = "FROM Shelter s where s.id = :Id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Shelter> query = session.createQuery(hql);
            query.setParameter("Id", Id);
            Shelter result = query.uniqueResult();
            session.close();
            return result;
        }
        catch (Exception e){
            logger.debug(e.getMessage());
            session.close();
            return null;
        }
    }

    @Override
    public Shelter save(Shelter shelter){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(shelter);
            transaction.commit();

            return shelter;
        } catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error("Failure to insert record", e);
        }
        if (shelter != null)logger.debug("The shelter was inserted into database");
        return null;
    }

//    @Override
//    public Shelter getShelterByName(String deptName) {
//        String hql = "From Shelter as shelt left join fetch shelt.name as pe " +
//                "left join fetch em.accounts " + "WHERE lower(dept.name)= :deptName";
//
//        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Query<Department> query = session.createQuery(hql);
//            query.setParameter("deptName", deptName.toLowerCase());
//            return query.uniqueResult();
//        }
//        catch (Exception e){
//            logger.error(e.getMessage());
//        }
//        return null;
//    }


    @Override
    public boolean delete(Shelter shelter) {
        String hql ="DELETE Shelter as s where s.id =:Id";
        int deletedCount = 0;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query<Shelter> query = session.createQuery(hql);
            query.setParameter("Id", shelter.getId());
            deletedCount = query.executeUpdate();
            transaction.commit();

            return deletedCount>= 1? true: false;
        }catch (HibernateException e){
            if (transaction != null) transaction.rollback();

            logger.error("unable to delete record", e);
        }
        return false;
    }

    @Override
    public Shelter update(Shelter shelter) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(shelter);
            transaction.commit();
            return shelter;
        }
        catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error("Failure to update record", e.getMessage());
        }
        return null;
    }
}
