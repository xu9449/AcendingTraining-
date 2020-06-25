package com.sean.debug12.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.sean.debug12.model.View.AdopterViews;
import com.sean.debug12.model.View.ShelterViews;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// ADOPTER MODULE
/*
    id, d



 */

@Entity
@Table(name = "adopters")
// owning set
public class Adopter implements Serializable {

    public Adopter() {

    }

    public Adopter(String name, String password){
        this.name = name;
        this.password = password;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonView({AdopterViews.Internal.class})
    @Column(name = "id")
    private Long id;

    @JsonView({AdopterViews.Public.class, AdopterViews.Internal.class})
    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @JsonView({AdopterViews.Public.class, AdopterViews.Internal.class})
    @Column(name = "tel")
    private String tel;

    @JsonView({AdopterViews.Public.class, AdopterViews.Internal.class})
    @Column(name = "email")
    private String email;

    @JsonView({AdopterViews.Public.class, AdopterViews.Internal.class})
    @Column(name = "location")
    private String location;

    @JsonView({AdopterViews.Public.class, AdopterViews.Internal.class})
    @Column(name = "description")
    private String description;

    @Column(name = "secret_key")
    private String secretKey;

    @JsonView({AdopterViews.Public.class, AdopterViews.Internal.class})
    @Column(name = "first_name")
    private String firstName;

    @JsonView({AdopterViews.Public.class, AdopterViews.Internal.class})
    @Column(name = "last_name")
    private String lastName;

    @JsonView({AdopterViews.Internal.class})
    @Column(name = "image_url")
    private String imageUrl;


    @JsonView({AdopterViews.Internal.class})
    @Column(name = "Active_status")
    private Boolean activeStatus;



    @JsonView({AdopterViews.Public.class, AdopterViews.Internal.class})
    @Column(name = "pet_id")
    private Long pet_id;

    @OneToMany(mappedBy = "adopter", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Image> images;



    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "adopters_roles",
            joinColumns = {@JoinColumn(name = "adopter_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )

    @JsonView({AdopterViews.Internal.class})
    private List<Role> roles;

    // Adopter's favorite Pets
    @OneToMany(mappedBy = "adopter", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Pet> pets;


    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }


    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.md5Hex(password.trim());
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }




    public void setPet_id(Long pet_id) {
        this.pet_id = pet_id;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    // get


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }




    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }




    public Long getPet_id() {
        return pet_id;
    }

    public String getTel() {
        return tel;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Set<Pet> getPets() {
        try {
            int size = pets.size();
        } catch (Exception e) {
            return null;
        }
        return pets;
    }

    public List<Role> getRoles() {
        return roles;
    }

}