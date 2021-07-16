package com.reins.bookstore.daoimpl;

import com.reins.bookstore.dao.BookDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.Image;
import com.reins.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName BookDaoImpl
 * @Description TODO
 * @Author thunderBoy
 * @Date 2019/11/5 20:20
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book findOne(Integer id){
        return bookRepository.getOne(id);
    }


    @Override
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public Image getBookImage(Integer id) {
        return bookRepository.getOne(id).getBookImage();
    }

    @Override
    public Integer getBookNumber() {
        return bookRepository.getBookNumber();
    }

    @Override
    public Integer getBookInventorySum() {
        return bookRepository.getBookInventorySum();
    }
}
