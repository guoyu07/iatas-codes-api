package com.github.pablocloud.iataapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Iata implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String code;
    private String name;
    private String type;
    private String country;
    private String city;

    public Iata() {

    }

    public Iata(String code) {
        this.code = code;
    }

    public Iata(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Iata(String code, String name, String type) {
        this.code = code;
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
