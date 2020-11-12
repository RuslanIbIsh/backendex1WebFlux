package com.unbolt.backendexercise1.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "node")
@TypeAlias("nodeRoot")
public class NodeRoot extends Node {

    private String name;

    public NodeRoot() {

    }

    public NodeRoot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeRoot nodeRoot = (NodeRoot) o;
        return name.equals(nodeRoot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
