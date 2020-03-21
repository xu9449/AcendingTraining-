package com.sean.debug12.model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pet")
// invert side
public class Pet {
    public Pet() {};
    public Pet(Integer id, String name, String age, String breed, Integer shelter, Date adoptdate) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.shelter = shelter;
        this.adoptdate = adoptdate;

//        @OneToOne(mappedBy = "pet");
//        private Adopter adopter;


    };

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")



    @Id
    // 每次会加一
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "breed")
    private String breed;

    @Column(name = "shelter_id")
    private Integer shelter;


    @Column(name = "adop_date", columnDefinition = "DATE")

    private Date adoptdate;

//    @JsonInclud()



//    settings.put(Environment.HBM2DD_AUTO, "validate");
    // Set
    public void setId(Integer id) { this.id = id; }
    public void setBreed(String breed) {this.breed = breed;}
    public void setName(String name) {
        this.name = name;
    }


    public void setAge(String age) { this.age = age;}

    public void setAdoptdate(Date adoptdate) {
        this.adoptdate = adoptdate;
    }

    public void setShelter(Integer shelter) {
        this.shelter = shelter;
    }

    // Get
    public Integer getId() { return id; }
    public String getBreed() { return breed; }
    public Date getAdoptdate() { return adoptdate; }
    public String getName() { return name; }
    public Integer getShelter() { return shelter; }
    public String getAge() { return age; }


}