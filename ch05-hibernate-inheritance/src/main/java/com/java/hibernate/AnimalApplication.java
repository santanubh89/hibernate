package com.java.hibernate;

import com.java.hibernate.entity.table_per_class.Animal;
import com.java.hibernate.entity.table_per_class.Birds;
import com.java.hibernate.entity.table_per_class.Mammals;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AnimalApplication {

    public static void main(String[] args) {

        Animal human = new Animal(1, "Human");
        Animal parrot = new Birds(2, "Parrot", 30);
        Animal dog = new Mammals(3, "Dog", 50);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(human);
        session.persist(parrot);
        session.persist(dog);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }

}
