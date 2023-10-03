package com.example.MyBookShopApp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "tags")
@FieldDefaults(level = AccessLevel.PRIVATE)
//@ToString
@NoArgsConstructor
@Entity
public class TagsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /*@OneToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Book> bookList = new ArrayList<>();*/
}
