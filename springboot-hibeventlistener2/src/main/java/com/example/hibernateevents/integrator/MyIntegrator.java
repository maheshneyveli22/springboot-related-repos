package com.example.hibernateevents.integrator;

import com.example.hibernateevents.listener.MyPostInsertEventListener;
import org.hibernate.boot.Metadata;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyIntegrator implements Integrator {

    private static final Logger log = LoggerFactory.getLogger(MyIntegrator.class);

    @Override
    public void integrate(
            Metadata metadata,
            SessionFactoryImplementor sessionFactory,
            SessionFactoryServiceRegistry serviceRegistry) {

        final EventListenerRegistry eventListenerRegistry =
                serviceRegistry.getService(EventListenerRegistry.class);
        System.out.println("Mahesh");
        // Register our custom PostInsertEventListener
        eventListenerRegistry.appendListeners(
                EventType.POST_INSERT,
                new MyPostInsertEventListener()
        );

        System.out.println("MyIntegrator: Custom PostInsertEventListener registered successfully!");
    }

    @Override
    public void disintegrate(
            SessionFactoryImplementor sessionFactory,
            SessionFactoryServiceRegistry serviceRegistry) {
        log.info("MyIntegrator: Disintegrating...");
        // Clean up resources if necessary when SessionFactory shuts down
    }
}