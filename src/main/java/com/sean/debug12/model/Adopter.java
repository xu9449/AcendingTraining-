package com.sean.debug12.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "adopters")

// owning set
public class Adopter {
    public Adopter() {
    }

    public Adopter(long id, String name, String password, String tel, String email, String location, String description, String secretKey, String firstName, String lastName, String imageUrl, Timestamp adoptDate, long pet_id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.email = email;
        this.location = location;
        this.description = description;
        this.secretKey = secretKey;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.adopt_date = adopt_date;
        this.pet_id = pet_id;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "tel")
    private String tel;
    @Column(name = "email")
    private String email;
    @Column(name = "location")
    private String location;
    @Column(name = "description")
    private String description;
    @Column(name = "secret_key")
    private String secretKey;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "adopt_date")
    private Timestamp adopt_date;
    @Column(name = "pet_id")
    private Long pet_id;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "adopters_roles",
            joinColumns = {@JoinColumn(name = "adopter_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )

    //@JsonIgnore
    private List<Role> roles;

    // Adopter's favorite Pets
    @OneToMany(mappedBy = "adopter", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Pet> pets;


    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAdopt_date(Timestamp adopt_date) {
        this.adopt_date = adopt_date;
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

    public Timestamp getAdopt_date() {
        return adopt_date;
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
