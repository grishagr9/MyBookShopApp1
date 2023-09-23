package com.example.MyBookShopApp.repositories;


import com.example.MyBookShopApp.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Authors, Integer> {


}
