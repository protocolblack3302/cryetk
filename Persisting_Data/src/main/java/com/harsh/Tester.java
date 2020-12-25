package com.harsh;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;


public class Tester {

    public static void main(String[] args){

        Laptop laptop=new Laptop();
        laptop.setId(Long.parseLong("1"));
        laptop.setCompany("Dell");

        Laptop laptop1=new Laptop();
        laptop1.setId(Long.parseLong("2"));
        laptop1.setCompany("Lenovo");

        User user1=new User();
        user1.setId(Long.parseLong("1"));
        user1.setName("harsh");
        user1.setEmail("protocolblack3301@gmail.com");

        laptop.setUser(user1);
        laptop1.setUser(user1);

        user1.getList().add(laptop);
        user1.getList().add(laptop1);

        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction trx=session.beginTransaction();
        session.save(laptop);
        session.save(laptop1);
        session.save(user1);
        trx.commit();
        session.close();

        Session session3=sessionFactory.openSession();
        Transaction trx3=session3.beginTransaction();
        Query query=session3.createSQLQuery("select * from " +
                "laptop natural join people" );
        List<Object[]> list=query.getResultList();
        for(Object[] o:list){
            System.out.println(o[0]+" : "+o[1]+" : "+o[2]+" : "+o[3]+" : "+o[4]);
        }
        trx3.commit();
        session3.close();






    }

}
