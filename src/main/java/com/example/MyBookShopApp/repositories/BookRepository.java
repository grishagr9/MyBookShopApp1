package com.example.MyBookShopApp.repositories;

import com.example.MyBookShopApp.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {


    @Query("from Book")
    List<Book> customFindAllBooks();

    //New book rest repository commands

    List<Book> findBooksByTitleContaining(String bookTitle);

    List<Book> findBooksByPriceBetween(Integer min, Integer max);

    List<Book> findBooksByPriceIs(Integer price);

    @Query("from Book where isBestseller=1")
    List<Book> getBestsellers();

    @Query(value = "SELECT * FROM books WHERE discount = (SELECT MAX(discount) FROM books)", nativeQuery = true)
    List<Book> getBooksWithMaxDiscount();

    public Page<Book> findBooksByTitleContaining(String bookTitle, Pageable nextPage);

    Page<Book> findAllByOrderByPubDateDesc(Pageable pageable);

    Page<Book> findAllByPubDateBetween(Date from, Date to, Pageable nextPage);

    @Query(value = "SELECT * FROM books WHERE CAST(pub_date AS date) BETWEEN CAST(:fromDate AS date) AND CAST(:toDate AS date)",
            nativeQuery = true)
    Page<Book> findAllByPubDateBetweenAndOrderByPubDateDesc(@Param("fromDate") Date fromDate,
                                                            @Param("toDate") Date toDate,
                                                            Pageable nextPage);
}
