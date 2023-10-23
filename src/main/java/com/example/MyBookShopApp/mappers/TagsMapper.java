package com.example.MyBookShopApp.mappers;

import com.example.MyBookShopApp.dto.AuthorDto;
import com.example.MyBookShopApp.dto.TagsDto;
import com.example.MyBookShopApp.entity.Authors;
import com.example.MyBookShopApp.entity.TagsEntity;
import com.example.MyBookShopApp.repositories.Book2TagRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TagsMapper {
    TagsMapper INSTANCE = Mappers.getMapper(TagsMapper.class);

    //@Mapping(target = "tagClass", expression = "java(getClassOfTag(countBook))")
    TagsDto toDTO(TagsEntity tags, Integer countBooks);



}
