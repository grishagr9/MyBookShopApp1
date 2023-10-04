package com.example.MyBookShopApp.repositories;

import com.example.MyBookShopApp.entity.book.links.Book2TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book2TagRepository extends JpaRepository<Book2TagEntity,Integer> {

    Integer countBook2TagEntitiesByTagId(Integer tag_id);
}
