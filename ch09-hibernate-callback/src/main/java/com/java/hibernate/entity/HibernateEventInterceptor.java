package com.java.hibernate.entity;


import org.hibernate.Interceptor;
import org.hibernate.type.Type;

public class HibernateEventInterceptor implements Interceptor {

    public boolean onPersist(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("onPersist called for entity: " + entity);
        System.out.println("Object ID: " + id);
        for (int i = 0; i < propertyNames.length; i++) {
            System.out.println("Attribute: " + propertyNames[i] + ", Type: " + types[i] + ", Value: " + state[i]);
        }
        return false;
    }

    public void onRemove(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("onRemove called for entity: " + entity);
    }

    public void onInsert(Object entity, Object id, Object[] state, String[] propertyNames, Type[] propertyTypes) {
        System.out.println("onInsert called for entity: " + entity);
    }

    public void onUpdate(Object entity, Object id, Object[] state, String[] propertyNames, Type[] propertyTypes) {
        System.out.println("onUpdate called for entity: " + entity);
    }

    public void onUpsert(Object entity, Object id, Object[] state, String[] propertyNames, Type[] propertyTypes) {
        System.out.println("onUpsert called for entity: " + entity);
    }

    public void onDelete(Object entity, Object id, String[] propertyNames, Type[] propertyTypes) {
        System.out.println("onDelete called for entity: " + entity);
    }

}
