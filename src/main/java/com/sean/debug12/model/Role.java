package com.sean.debug12.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    public Role() {}
    public Role(long id, String name, String allowedResource, boolean allowedRead, boolean allowedCreate, boolean allowedUpdate, boolean allowedDelete, List<Adopter> adopters) {
        this.id = id;
        this.name = name;
        this.allowedResource = allowedResource;
        this.allowedRead = allowedRead;
        this.allowedCreate = allowedCreate;
        this.allowedUpdate = allowedUpdate;
        this.allowedDelete = allowedDelete;
        this.adopters = adopters;
    }


    @Id
    //@SequenceGenerator(name = "role_id_generator", sequenceName = "role_id_seq", allocationSize = 1)
    //@GeneratedValue(strategy = SEQUENCE, generator = "role_id_generator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "allowed_resource")
    private String allowedResource;
    @Column(name = "allowed_read")
    private boolean allowedRead;
    @Column(name = "allowed_create")
    private boolean allowedCreate;
    @Column(name = "allowed_update")
    private boolean allowedUpdate;
    @Column(name = "allowed_delete")
    private boolean allowedDelete;



    @ManyToMany(mappedBy = "roles")
    private List<Adopter> adopters;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllowedResource() {
        return allowedResource;
    }

    public void setAllowedResource(String allowedResource) {
        this.allowedResource = allowedResource;
    }

    public boolean isAllowedRead() {
        return allowedRead;
    }

    public void setAllowedRead(boolean allowedRead) {
        this.allowedRead = allowedRead;
    }

    public boolean isAllowedCreate() {
        return allowedCreate;
    }

    public void setAllowedCreate(boolean allowedCreate) {
        this.allowedCreate = allowedCreate;
    }

    public boolean isAllowedUpdate() {
        return allowedUpdate;
    }

    public void setAllowedUpdate(boolean allowedUpdate) {
        this.allowedUpdate = allowedUpdate;
    }

    public boolean isAllowedDelete() {
        return allowedDelete;
    }

    public void setAllowedDelete(boolean allowedDelete) {
        this.allowedDelete = allowedDelete;
    }

    public List<Adopter> getAdopters() {
        return adopters;
    }

    public void setAdopters(List<Adopter> adopters) {
        this.adopters = adopters;
    }

    //    public long getId() {
//        return id;
//    }
//    public String getName() {
//        return name;
//    }
//    public String getAllowedResource() {
//        return allowedResource;
//    }

}
