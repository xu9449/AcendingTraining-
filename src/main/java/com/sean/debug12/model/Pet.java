package com.sean.debug12.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.sean.debug12.model.View.PetViews;
import com.sean.debug12.model.View.ShelterViews;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "pets")

// invert side
public class Pet {
    public Pet() {}
    public Pet(long id, String sex, String name, String age, String breed, String description, boolean adoptable) {

        this.id = id;
        this.sex = sex;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.description = description;
        this.adoptable = adoptable;
//        this.adopter = adopter;

    }





    @Id
    // 每次会加一
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    @Column(name = "id")
    @JsonView({ShelterViews.Public.class, ShelterViews.Internal.class,PetViews.Public.class, PetViews.Internal.class})
    private long id;

    @Column(name = "sex")
    @JsonView({ShelterViews.Public.class, ShelterViews.Internal.class,PetViews.Public.class, PetViews.Internal.class})
    private String sex;

    @Column(name = "breed")
    @JsonView({ShelterViews.Public.class, ShelterViews.Internal.class})
    private String breed;

    @Column(name = "name")
    @JsonView({ShelterViews.Public.class, ShelterViews.Internal.class})
    private String name;

    @Column(name = "age")
    @JsonView({ShelterViews.Public.class, ShelterViews.Internal.class})
    private String age;

    @Column(name = "description")
    @JsonView({ShelterViews.Public.class, ShelterViews.Internal.class})
    private String description;

    @Column(name = "adoptable")
    @JsonView({ShelterViews.Public.class, ShelterViews.Internal.class})
    private boolean adoptable;

    @JsonView({PetViews.Public.class, PetViews.Internal.class})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;





//    settings.put(Environment.HBM2DD_AUTO, "validate");
    // Set
    public void setId(long id) { this.id = id; }
    public void setSex(String sex) { this.sex = sex;}
    public void setBreed(String breed) {this.breed = breed;}
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(String age) { this.age = age;}
    public void setDescription(String description) { this.description = description;}
    public void setAdoptable(Boolean adoptable) {this.adoptable = adoptable;}
    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    // Get
    public long getId() { return id; }
    public String getSex() {return sex; }
    public String getBreed() { return breed; }
    public String getName() { return name; }
    public String getAge() {return age; }
    public String getDescription() {return description;}
    public Boolean getAdoptable() {return adoptable;}
    public Shelter getShelter() {
        return shelter;
    }




}