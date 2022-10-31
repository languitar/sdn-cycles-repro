package com.example.sdnproblem;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TestNodeRepository extends CrudRepository<TestNode, UUID> {
}
