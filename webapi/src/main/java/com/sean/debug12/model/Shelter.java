package com.sean.debug12.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.sean.debug12.model.View.PetViews;
import com.sean.debug12.model.View.ShelterViews;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shelters")
public class Shelter implements Serializable {


    public Shelter() {
    }

    public Shelter(Long id, String name, String email, String tel, String location, String description, String principle) {
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
    @JsonView({ShelterViews.Public.class, ShelterViews.Internal.class, PetViews.Public.class, PetViews.Internal.class})
    private Long id;

    @Column(name = "name")
    @JsonView({ShelterViews.Public.class, ShelterViews.Internal.class, PetViews.Public.class, PetViews.Internal.class})
    private String name;

    @Column(name = "tel")
    @JsonView({ShelterViews.Public.class, ShelterViews.Internal.class})
    private String tel;

    @Column(name = "email")
    @JsonView({ShelterViews.Public.class, ShelterViews.Internal.class})
    private String email;

    @Column(name = "location")
    @JsonView({ShelterViews.Public.class, ShelterViews.Internal.class})
    private String location;

    @Column(name = "description")
    @JsonView({ShelterViews.Public.class, ShelterViews.Internal.class})
    private String description;

    @Column(name = "principle")
    @JsonView({ShelterViews.Internal.class})
    private String principle;

    @JsonView({ShelterViews.Internal.class})
    @OneToMany(mappedBy = "shelter", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Pet> pets;

    //Set

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

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
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

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public Set<Pet> getPets() {
        try {
            int size = pets.size();
        } catch (Exception e) {
            return null;
        }
        return pets;
    }


    public String getPrinciple() {
        return principle;
    }
}


