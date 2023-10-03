package com.example.MyBookShopApp.repositories;

import com.example.MyBookShopApp.dto.TagsDto;
import com.example.MyBookShopApp.entity.TagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<TagsEntity, Integer> {

}
