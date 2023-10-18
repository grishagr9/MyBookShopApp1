package com.example.MyBookShopApp.mappers;

import com.example.MyBookShopApp.dto.AuthorDto;
import com.example.MyBookShopApp.entity.Authors;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDto toDTO(Authors author);
}
