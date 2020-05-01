package com.sean.debug12.repository;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Role;
import com.sean.debug12.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Role getRoleByName(String roleName) {
        if (roleName == null) return null;
        String hql = "FROM Role as r where r.name = :name";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Role> query = session.createQuery(hql);
            query.setParameter("name", roleName);
            return query.uniqueResult();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Role getRoleId(Long Id) {
        String hql = "FROM Role as r where r.id = :Id";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Role> query = session.createQuery(hql);
            query.setParameter("Id", Id);
            return query.uniqueResult();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
