package com.example.MyBookShopApp.mappers;

import com.example.MyBookShopApp.dto.AuthorDto;
import com.example.MyBookShopApp.dto.TagsDto;
import com.example.MyBookShopApp.entity.Authors;
import com.example.MyBookShopApp.entity.TagsEntity;
import com.example.MyBookShopApp.repositories.Book2TagRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagsMapper {
    TagsMapper INSTANCE = Mappers.getMapper(TagsMapper.class);

    @Mapping(target = "tagClass", expression = "java(getClassOfTag(countBook))")
    TagsDto toDTO(TagsEntity tags, Integer countBooks);


    private String getClassOfTag(Integer count){
        if(count <= 40){
            return "Tag_xs";
        }
        if(count <= 46){
            return "Tag_sm";
        }
        if(count <= 54){
            return "Tag_md";
        }
        return "Tag_lg";
    }
}
