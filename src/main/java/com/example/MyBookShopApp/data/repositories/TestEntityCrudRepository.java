package com.example.MyBookShopApp.data.repositories;

import com.example.MyBookShopApp.data.entity.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestEntityCrudRepository extends CrudRepository<TestEntity, Long> {

}
