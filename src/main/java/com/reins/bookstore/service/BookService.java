package com.reins.bookstore.service;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.Image;
import com.reins.bookstore.vo.BookStatistic;

import java.util.List;


public interface BookService {

    Book findBookById(Integer id);

    List<Book> getBooks();

    Image findImageByBookId(Integer id);

    BookStatistic getBookStatistic();
}
