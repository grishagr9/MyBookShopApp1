package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.GenresDto;
import com.example.MyBookShopApp.dto.TagsDto;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.entity.TagsEntity;
import com.example.MyBookShopApp.entity.book.links.Book2GenreEntity;
import com.example.MyBookShopApp.entity.genre.GenreEntity;
import com.example.MyBookShopApp.repositories.Book2GenreRepository;
import com.example.MyBookShopApp.repositories.BookRepository;
import com.example.MyBookShopApp.repositories.GenresRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenresRepository genresRepository;

    private final Book2GenreRepository book2GenreRepository;

    private final BookRepository bookRepository;

    public GenreEntity getGenreByName(String name){
        return genresRepository.findByName(name);
    }
    public Map<Integer, GenresDto> getAllGenres(){
        final List<GenreEntity> genreEntities = genresRepository.findAll();
        return toDtoList(genreEntities);
    }

    public Integer getIdByGenre(String genre){
        GenreEntity res = genresRepository.findByName(genre);
        Logger.getLogger(GenreService.class.getSimpleName()).info(genre + " id = " + res);
        if(res != null){
            return res.getId();
        }else{
            return 0;
        }
    }

    public GenreEntity getParentGenre(GenreEntity genre){
        if(genre.getParentId()==0){
            return new GenreEntity();
        }
        Integer parId = genre.getParentId();
        return genresRepository.findById(parId).orElse(new GenreEntity());
    }

    public List<Book> getAllBookByName(String genre){
        Integer genreId = getIdByGenre(genre);
        List<Book2GenreEntity> booksId = book2GenreRepository.findAllByGenreId(genreId);
        List<Book> books = new ArrayList<>();
        for (Book2GenreEntity id: booksId) {
            books.add(bookRepository.findBookById(id.getBookId()));
        }
        return books;
    }

    private Map<Integer, GenresDto> toDtoList(List<GenreEntity> genreEntities) {

        final Map<Integer, GenresDto> genresDto = new HashMap<>();
        for (GenreEntity genre : genreEntities) {
            genresDto.put(genre.getId(), toDto(genre));
        }
        for (GenresDto item: genresDto.values()) {
            if(item.getParent() != 0){
                genresDto.get(item.getParent()).getChildren().add(item);
            }
        }
        return genresDto;
    }

    private GenresDto toDto(GenreEntity genreEntity){
        if(genreEntity != null){
            GenresDto genresDto = new GenresDto();
            genresDto.setName(genreEntity.getName());
            genresDto.setChildren(new ArrayList<>());
            genresDto.setParent(genreEntity.getParentId());
            return genresDto;
        }
        else{
            return new GenresDto();
        }
    }
}
