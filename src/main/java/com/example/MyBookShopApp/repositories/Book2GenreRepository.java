package com.example.MyBookShopApp.repositories;

import com.example.MyBookShopApp.entity.book.links.Book2GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Book2GenreRepository extends JpaRepository<Book2GenreEntity, Integer> {

    public List<Book2GenreEntity> findAllByGenreId(Integer genreId);
}
