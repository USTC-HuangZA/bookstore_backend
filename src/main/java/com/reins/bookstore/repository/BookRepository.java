package com.reins.bookstore.repository;

import com.reins.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("select b from Book b")
    List<Book> getBooks();

    @Query("SELECT count(*) FROM Book")
    Integer getBookNumber();

    @Query("SELECT sum(inventory) FROM Book")
    Integer getBookInventorySum();
}
