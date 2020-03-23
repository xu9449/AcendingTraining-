package com.sean.debug12.model;



import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "pet")

// invert side
public class Pet {
    public Pet() {};
    public Pet(long id, String sex, String name, String age, String breed, String description, boolean adoptable) {

        this.id = id;
        this.sex = sex;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.description = description;
        this.adoptable = adoptable;
//        this.adopter = adopter;

    };


    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userid")



    @Id
    // 每次会加一
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    @Column(name = "id")
    private long id;

    @Column(name = "sex")
    private String sex;

    @Column(name = "breed")
    private String breed;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

//    @Column(name = "shelter_id")
//    private long shelter_id;

    @Column(name = "description")
    private String description;

    @Column(name = "adoptable")
    private boolean adoptable;

//    @Column(name = "adopter")
//    private String adopter;



//    @JsonInclud()



//    settings.put(Environment.HBM2DD_AUTO, "validate");
    // Set
    public void setId(long id) { this.id = id; }
    public void setSex(String sex) { this.sex = sex;}
    public void setBreed(String breed) {this.breed = breed;}
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(String age) { this.age = age;}
//    public void setShelter(long shelter_id) { this.shelter_id = shelter_id; }
    public void setDescription(String description) { this.description = description;}
    public void setAdoptable(Boolean adoptable) {this.adoptable = adoptable;}
//    public void setAdopter(String adopter) {this.adopter = adopter;}
    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    // Get
    public long getId() { return id; }
    public String getSex() {return sex; }
    public String getBreed() { return breed; }
    public String getName() { return name; }
    public String getAge() {return age; }
//    public long getShelter_id() { return shelter_id; }
    public String getDescription() {return description;}
    public Boolean getAdoptable() {return adoptable;}
//    public String getAdopter() {return adopter;}
    public Shelter getShelter() {
        return shelter;
    }




}