package com.sean.debug12.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name ="images")
public class Image {
    public Image(){

    }

    public Image(String fileName){
        this.fileName = fileName;
    }
//
    @Id // will automatically add when create
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "upload_time")
    private Timestamp uploadTime;

    @Column(name = "s3key")
    private String s3Key;

    @Column(name = "url")
    private String url;

    @Column(name = "extension")
    private String extension;

    //TODO why
    @Column(name = "uuid")
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adopter_id")
    private Adopter adopter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public void setS3Key(String s3Key) {
        this.s3Key = s3Key;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public void setExtension(String extension) {
        this.extension = extension;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setAdopter(Adopter adopter) {
        this.adopter = adopter;
    }

    public Adopter getAdopter() {
        return adopter;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getFileName() {
        return fileName;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public String getS3Key() {
        return s3Key;
    }

    public String getUrl() {
        return url;
    }

    public String getExtension() {
        return extension;
    }

    public String getUuid() {
        return uuid;
    }

    public String getDescription() {
        return description;
    }
}
