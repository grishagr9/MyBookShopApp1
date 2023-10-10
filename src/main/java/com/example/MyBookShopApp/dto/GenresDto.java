package com.example.MyBookShopApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenresDto {

    String name;

    List<GenresDto> children;

    Integer parent;

    @Override
    public String toString() {
        return name + " " + parent + children.toString();
    }
}
