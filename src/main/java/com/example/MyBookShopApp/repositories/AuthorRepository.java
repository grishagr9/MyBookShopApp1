package com.example.MyBookShopApp.repositories;


import com.example.MyBookShopApp.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Authors, Integer> {


    public Authors findByName(String name);
}
