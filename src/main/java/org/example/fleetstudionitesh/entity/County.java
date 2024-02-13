package org.example.fleetstudionitesh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class County {
    @Id
    private String fips;
    private String state;
    private String name;


    public County() {

    }
    public County(String fips, String state, String name) {
        this.fips = fips;
        this.state = state;
        this.name = name;
    }

    public County(String county1, String state1) {
        this.name= county1;
        this.state = state1;
    }

    public String getFips() {
        return fips;
    }

    public void setFips(String fips) {
        this.fips = fips;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
