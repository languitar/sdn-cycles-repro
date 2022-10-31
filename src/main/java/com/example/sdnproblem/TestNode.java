package com.example.sdnproblem;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.UUID;

@Node("TestNode")
public class TestNode {

    @Id
    @GeneratedValue
    private UUID uuid;

    @Relationship("CYCLES_TO")
    private List<TestNode> cycles;

    public TestNode(final UUID uuid, final List<TestNode> cycles) {
        this.uuid = uuid;
        this.cycles = cycles;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<TestNode> getCycles() {
        return cycles;
    }

    public void setCycles(List<TestNode> cycles) {
        this.cycles = cycles;
    }

    @Override
    public String toString() {
        return "TestNode{" +
                "uuid=" + uuid +
                ", cycles=" + cycles +
                '}';
    }
}
