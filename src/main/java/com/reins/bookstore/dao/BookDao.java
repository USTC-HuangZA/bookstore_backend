package com.reins.bookstore.dao;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.Image;

import java.util.List;

public interface BookDao {
    Book findOne(Integer id);

    List<Book> getBooks();

    Image getBookImage(Integer id);

    Integer getBookNumber();

    Integer getBookInventorySum();
}
