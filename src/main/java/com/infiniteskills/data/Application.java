package com.infiniteskills.data;


import java.util.Date;

import com.infiniteskills.data.entities.Address;
import com.infiniteskills.data.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.infiniteskills.data.entities.TimeTest;

public class Application {

    public static void main(String[] args) {

        /* Configuration */
        Configuration configuration = new Configuration().configure();


//        System.out.println("Configuration Properties "+configuration.getProperties());
        /* Building SessionFactory */
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(new StandardServiceRegistryBuilder(
                ).applySettings(configuration.getProperties()).build());

        /* Obtain Session and Call Persistence Methods */
        Session session = sessionFactory.openSession();
        session.beginTransaction();


//        timeTest(session);
//        userTestAddress(session);
//        userTestAddressAdditional(session);
        userTestEmbededAddress(session);


        session.getTransaction().commit();
        session.close();

    }

    private static void timeTest(Session session) {
        TimeTest timeTest = new TimeTest(new Date());
        System.out.println(timeTest);
        session.save(timeTest);
    }

    private static void userTestAddress(Session session) {
        User user = new User();
        Address address = new Address();
        address.setAddressLine1("addressLine1");
        address.setAddressLine2("addressLine2");
        address.setCity("city1");

        user.setAddress(address);
        System.out.println(user);
        session.save(user);
    }

    private static void userTestEmbededAddress(Session session) {
        User user = new User();
        Address address = new Address();
        address.setAddressLine1("embeded Address line 1");
        address.setAddressLine2("embeded Address line 2");
        address.setCity("embdeded city1");

        user.setEmbededAddress(address);
        user.setAddress(address);
        System.out.println(user);
        session.save(user);
    }
    private static void userTestAddressAdditional(Session session) {
        User user = new User();
        Address address = new Address();
        address.setAddressLine1("additional addressLine1");
        address.setAddressLine2("additional addressLine2");
        address.setCity("additional city1");

        user.addAddress(address);
        System.out.println(user);
        session.save(user);
    }
}
