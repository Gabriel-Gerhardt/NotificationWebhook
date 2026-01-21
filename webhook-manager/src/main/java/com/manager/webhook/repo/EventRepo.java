package com.manager.webhook.repo;

import com.manager.webhook.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepo extends JpaRepository<Event,UUID> {
    Event findByNameIgnoreCase(String name);
}
