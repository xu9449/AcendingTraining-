package com.sean.debug12.model;



import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "pet")
// invert side
public class Pet {
    public Pet() {};
    public Pet(Integer id, String sex, String name, String age, String breed, Integer shelter, String description, boolean adoptable, String adopter) {

        this.id = id;
        this.sex = sex;
        this.name = name;
        this.age = age;
        this.shelter = shelter;
        this.breed = breed;
        this.description = description;
        this.adoptable = adoptable;
        this.adopter = adopter;






    };

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userid")



    @Id
    // 每次会加一
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    @Column(name = "id")
    private Integer id;

    @Column(name = "sex")
    private String sex;

    @Column(name = "breed")
    private String breed;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "shelter")
    private Integer shelter;

    @Column(name = "description")
    private String description;

    @Column(name = "adoptable")
    private boolean adoptable;

    @Column(name = "adopter")
    private String adopter;



//    @JsonInclud()



//    settings.put(Environment.HBM2DD_AUTO, "validate");
    // Set
    public void setId(Integer id) { this.id = id; }
    public void setSex(String sex) { this.sex = sex;}
    public void setBreed(String breed) {this.breed = breed;}
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(String age) { this.age = age;}
    public void setShelter(Integer shelter) {
        this.shelter = shelter;
    }
    public void setDescription(String description) { this.description = description;}
    public void setAdoptable(Boolean adoptable) {this.adoptable = adoptable;}
    public void setAdopter(String adopter) {this.adopter = adopter;}

    // Get
    public Integer getId() { return id; }
    public String getSex() {return sex; }
    public String getBreed() { return breed; }
    public String getName() { return name; }
    public String getAge() {return age; }
    public Integer getShelter() { return shelter; }
    public String getDescription() {return description;}
    public Boolean getAdoptable() {return adoptable;}
    public String getAdopter() {return adopter;}




}