package com.sean.debug12.model;

public class Adopter {
    private Long id;
    private String name;
    private String tel;
    private String email;
    private String location;
    private String description;
    private String pet_id;

    // set
    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmial(String emial) {
        this.email = email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPet_id(String pet_id) {
        this.pet_id = pet_id;
    }
    // get


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmial() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getPet_id() {
        return pet_id;
    }

    public String getTel() {
        return tel;
    }
}
