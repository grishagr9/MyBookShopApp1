package com.example.MyBookShopApp.repositories;

import com.example.MyBookShopApp.entity.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestEntityCrudRepository extends CrudRepository<TestEntity, Long> {

}