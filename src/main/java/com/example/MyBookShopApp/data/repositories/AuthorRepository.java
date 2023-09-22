package com.example.MyBookShopApp.data.repositories;


import com.example.MyBookShopApp.data.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Authors, Integer> {


}
