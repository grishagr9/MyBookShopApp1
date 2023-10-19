package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.AuthorDto;
import com.example.MyBookShopApp.dto.BookDto;
import com.example.MyBookShopApp.dto.TagsDto;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.entity.TagsEntity;
import com.example.MyBookShopApp.mappers.AuthorMapper;
import com.example.MyBookShopApp.repositories.AuthorRepository;
import com.example.MyBookShopApp.entity.Authors;
import com.example.MyBookShopApp.repositories.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookService bookService;

    public Authors getAuthorByName(String name){
        return authorRepository.findByName(name);
    }

    public Map<String, List<Authors>> getAuthorsMap() {
        List<Authors> authors = authorRepository.findAll();
        return authors.stream().collect(Collectors.groupingBy((Authors a) -> a.getName().substring(0, 1)));
    }

    public List<BookDto> getBookByAuthor(String nameAuthor) {
        Authors author = getAuthorByName(nameAuthor);
        return bookService.toDtos(bookRepository.findBooksByAuthor(author));
    }
//    List<AuthorDto> toDtoList(List<Authors> authorsEntity) {
//        final List<AuthorDto> tagsDto = new ArrayList<>(authorsEntity.size());
//        for (Authors author : authorsEntity) {
//            tagsDto.add(AuthorMapper.INSTANCE.toDTO(author));
//        }
//        return tagsDto;
//    }
//    public AuthorDto toDTO(Authors author){
//        return new AuthorDto();
//    }
}
