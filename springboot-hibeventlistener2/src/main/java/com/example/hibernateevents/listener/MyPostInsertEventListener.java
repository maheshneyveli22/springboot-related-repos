package com.example.hibernateevents.listener;

import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyPostInsertEventListener implements PostInsertEventListener {

    private static final Logger log = LoggerFactory.getLogger(MyPostInsertEventListener.class);

    // Hibernate 6 requires this to return true for dirty checking.
    // For PostInsert, it typically doesn't affect subsequent dirty checking.

    // This method is deprecated in Hibernate 6, but still often implemented for backward compatibility.
    // The non-deprecated onPostInsert method is below.
    @Override
    public void onPostInsert(PostInsertEvent event) {
        log.info("MyPostInsertEventListener (Deprecated): Entity inserted: {}", event.getEntity());
        log.info("Entity ID: {}", event.getId());
        log.info("Entity Class Name: {}", event.getEntity().getClass().getName());
        log.info("------------------------------------------------------------------");
    }

    // The non-deprecated method in Hibernate 6.
    public void onPostInsert(PostInsertEvent event, EntityPersister persister) {
        log.info("MyPostInsertEventListener: Entity inserted: {}", event.getEntity());
        log.info("Entity ID: {}", event.getId());
        log.info("Entity Class Name: {}", event.getEntity().getClass().getName());
        log.info("Persister: {}", persister.getEntityName());
        log.info("------------------------------------------------------------------");
        // Add your custom logic here, e.g., send to an audit log, message queue, etc.
    }

    @Override
    public boolean requiresPostCommitHandling(EntityPersister entityPersister) {
        return false;
    }
}