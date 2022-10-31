package com.example.sdnproblem;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.UUID;

@Service
public class ReproTrigger {

    private final TestNodeRepository testNodeRepository;

    public ReproTrigger(final TestNodeRepository testNodeRepository) {
        this.testNodeRepository = testNodeRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void repro() {

        final TestNode before = new TestNode(UUID.randomUUID(), new LinkedList<>());
        before.getCycles().add(before);

        testNodeRepository.save(before);
        System.out.println("Save data");

        System.out.println(testNodeRepository.findById(before.getUuid()));

    }

}
