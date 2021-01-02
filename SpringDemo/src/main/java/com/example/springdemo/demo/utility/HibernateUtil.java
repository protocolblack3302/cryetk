package com.example.springdemo.demo.utility;


import com.example.springdemo.demo.domains.Order;
import com.example.springdemo.demo.domains.Taco;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {


    static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        Configuration cfg=new Configuration().configure().addAnnotatedClass(Order.class).addAnnotatedClass(Taco.class);
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        sessionFactory= cfg.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}
