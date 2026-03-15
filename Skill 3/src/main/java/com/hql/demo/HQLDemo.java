package com.hql.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hql.entity.Product;
import com.hql.util.HibernateUtil;

public class HQLDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql = "FROM Product p ORDER BY p.price ASC";

        Query<Product> query = session.createQuery(hql, Product.class);

        List<Product> list = query.list();

        for(Product p : list) {
            System.out.println(p.getName() + " " + p.getPrice());
        }

        session.close();
    }
}