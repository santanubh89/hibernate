package com.java.hibernate;


import com.java.hibernate.entity.single_table.FourWheelerVehicle;
import com.java.hibernate.entity.single_table.TwoWheelerVehicle;
import com.java.hibernate.entity.single_table.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class VehicleApplication {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("V1", "Tata Nexon");
        TwoWheelerVehicle bike = new TwoWheelerVehicle("Bike1", "KTM Duke", "Handle Bar");
        FourWheelerVehicle car1 = new FourWheelerVehicle("Car1", "Hyundai Creta", "Steering Wheel");
        FourWheelerVehicle car2 = new FourWheelerVehicle("Car2", "Audi A8", "Round Wheel");

        Configuration hibernateConfiguration = new Configuration().configure();
        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(vehicle);
        session.persist(bike);
        session.persist(car1);
        session.persist(car2);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }

}
