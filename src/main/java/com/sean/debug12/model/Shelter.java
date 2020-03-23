package com.sean.debug12.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shelter")
public class Shelter {
    public Shelter(){};

    public Shelter(Integer id, String name, String email, String location, String description, String principle) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.location = location;
        this.description = description;
        this.principle = principle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name ="tel")
    private String tel;
    @Column(name = "email")
    private String email;
    @Column(name = "location")
    private String location;
    @Column(name = "description")
    private String description;
    @Column(name = "principle")
    private String principle;

    @OneToMany(mappedBy = "shelter", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Pet> pets;

    //Set

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrinciple(String principle) {
        this.principle = principle;
    }

    public void setPets(Set<Pet> pets) {this.pets = pets;}
    //Get

    public String getTel() {
        return tel;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Set<Pet> getPets() {
        try {
            int size = pets.size();
        }
        catch (Exception e){
            return null;
        }
        return pets;
    }

    public String getPrinciple() {
        return principle;
    }
}


