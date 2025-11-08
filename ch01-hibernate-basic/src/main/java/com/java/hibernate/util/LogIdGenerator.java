package com.java.hibernate.util;

import com.java.hibernate.entity.LogEvent;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class LogIdGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object o) {
        int randomNum = new Random().nextInt(900) + 100;
        LogEvent logEvent = (LogEvent) o;
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Session hibernateSession = session.unwrap(Session.class);
        return logEvent.getEventType() + "_" + timestamp + "_" + randomNum;
    }
}
