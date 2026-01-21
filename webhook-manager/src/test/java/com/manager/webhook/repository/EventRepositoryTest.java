package com.manager.webhook.repository;

import com.manager.webhook.entities.Event;
import com.manager.webhook.repo.EventRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class EventRepositoryTest {

    @Autowired
    private EventRepo eventRepo;



    @Test
    public void saveTest(){
        Event event = new Event();
        event.setId(UUID.randomUUID());
        event.setName("name");
        event.setUrl("url");

        eventRepo.save(event);
    }

    @Test
    public void getEventByNameIgnoresCase(){
        Event event = eventRepo.findByNameIgnoreCase("NAME");
        assert(event.getUrl().equals("url"));
        assert(event.getName().equals("name"));
    }

}
