package com.example.MyBookShopApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagsDto {

    private String tagClass;

    private Integer countBooks;

    private String name;
}
