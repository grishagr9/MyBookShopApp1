package com.example.MyBookShopApp.repositories;

import com.example.MyBookShopApp.entity.genre.GenreEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenresRepository extends JpaRepository<GenreEntity, Integer> {

    public GenreEntity findByName(String name);

    public Optional<GenreEntity> findById(Integer id);
}
