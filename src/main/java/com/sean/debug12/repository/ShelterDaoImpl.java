package com.sean.debug12.repository;

import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ShelterDaoImpl implements ShelterDao {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<Shelter> getShelters() {

         List<Shelter> shelts = new ArrayList<>();
        String hql = "FROM Shelter";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Shelter> query = session.createQuery(hql);
            shelts = query.list();
            session.close();
            return shelts;
        }
        catch (Exception e){
            logger.debug(e.getMessage());
            session.close();
            return shelts;
        }
    }

    @Override
    public Shelter save(Shelter shelter){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(shelter);
            transaction.commit();
            session.close();
            return shelter;
        } catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error("Failure to insert record", e);

        }
        if (shelter != null)logger.debug("The department was inserted into database");
        return null;
    }

    @Override
    public boolean delete(String sheltName) {

    }
}
