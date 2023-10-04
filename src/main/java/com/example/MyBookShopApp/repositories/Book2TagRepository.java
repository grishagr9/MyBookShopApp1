package com.example.MyBookShopApp.repositories;

import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.entity.book.links.Book2TagEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Book2TagRepository extends JpaRepository<Book2TagEntity,Integer> {

    Integer countBook2TagEntitiesByTagId(Integer tag_id);

    List<Book2TagEntity> getBook2TagEntitiesByTagId(Integer tag_id);
}
