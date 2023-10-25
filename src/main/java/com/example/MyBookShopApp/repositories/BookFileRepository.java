package com.example.MyBookShopApp.repositories;

import com.example.MyBookShopApp.entity.BookFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookFileRepository extends JpaRepository<BookFileEntity, Integer> {

    public BookFileEntity findBookFileEntitiesByHash(String hash);
}
