package com.example.MyBookShopApp.mappers;
import com.example.MyBookShopApp.dto.BookDto;
import com.example.MyBookShopApp.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto toDTO(Book book);
}
