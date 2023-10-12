package org.example.Serialization.model;

import java.io.Serializable;

public class Theater implements Serializable {
    private String name;

    public Theater(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
