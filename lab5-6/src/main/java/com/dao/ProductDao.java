package com.dao;
import com.Model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.utils.HibernateSessionFactoryUtil;
import java.util.List;


public class ProductDao {
    public Product findByName(String name) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class, name);
    }

    public void add(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(product);
        tx1.commit();
        session.close();
    }

    public void update(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(product);
        tx1.commit();
        session.close();
    }

    public void delete(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(product);
        tx1.commit();
        session.close();
    }


    public List<Product> findAll() {
        List<Product> productList = (List<Product>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from Product").list();
        return productList;
    }
}