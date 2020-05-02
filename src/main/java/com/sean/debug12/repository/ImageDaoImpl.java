package com.sean.debug12.repository;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDaoImpl implements ImageDao{

    @Autowired
    SessionFactory sessionFactory;


    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Image save(Image image) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(image);
            transaction.commit();
            session.close();
            return image;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("Failure to insert record", e);
        }
        if (image != null) logger.debug("The adopter was inserted into database");
        return null;
    }

}
