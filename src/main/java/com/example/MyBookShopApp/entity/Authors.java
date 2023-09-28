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
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
@Table(name = "authors")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@NoArgsConstructor
@Entity
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@ApiResponse(description = "id")
    Integer id; //todo на будущее id лучше брать как Long

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String description;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    //@ApiModelProperty("name of author")
    String name;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String photo;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String slug;
}
