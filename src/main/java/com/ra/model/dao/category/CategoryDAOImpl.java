package com.ra.model.dao.category;

import com.ra.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryDAOImpl implements CategoryDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        List<Category> categories = new ArrayList<>();
        try {
            categories = session.createQuery("from Category", Category.class).list();
        } catch (Exception exception){
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return categories;
    }

    @Override
    public Boolean create(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return false;
    }

    @Override
    public Boolean update(Category category) {
        return null;
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
