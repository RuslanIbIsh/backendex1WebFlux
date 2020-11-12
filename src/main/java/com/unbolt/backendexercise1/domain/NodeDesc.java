package com.unbolt.backendexercise1.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "node")
@TypeAlias("nodeDesc")
public class NodeDesc extends NodeRoot{

    private String description;

    public NodeDesc() {

    }

    public NodeDesc(String description) {
        this.description = description;
    }

    public NodeDesc(String name, String description) {
        super(name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeDesc nodeDesc = (NodeDesc) o;
        return description.equals(nodeDesc.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
