package com.example.MyBookShopApp.entity;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@ApiResponse(description = "id")
    private Integer id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String description;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    //@ApiModelProperty("name of author")
    private String name;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String photo;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String slug;

    public Authors() {
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", slug='" + slug + '\'' +
                '}';
    }

}
