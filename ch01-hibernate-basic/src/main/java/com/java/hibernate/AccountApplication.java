package com.java.hibernate;


import com.java.hibernate.model.LoginId;
import com.java.hibernate.entity.UserAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AccountApplication {

    public static void main(String[] args) {
        UserAccount userAccount = UserAccount.builder()
                .loginId(LoginId.builder().emailId("a@b.com").phoneNumber("012345678900").build())
                .username("Foo Bar").accountType(1)
                .build();
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(userAccount);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }

}
