package com.reins.bookstore.controller;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.Image;
import com.reins.bookstore.service.BookService;
import com.reins.bookstore.entity.vo.BookStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName BookController
 * @Description TODO
 * @Author thunderBoy
 * @Date 2019/11/6 16:07
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/getBooks")
    public List<Book> getBooks(@RequestBody Map<String, String> params) {
        return bookService.getBooks();
    }

    @RequestMapping("/getBook")
    public Book getBook(@RequestParam("id") Integer id){
        return bookService.findBookById(id);
    }

    @RequestMapping("/getBookImage")
    public Image getBookImage(@RequestParam("id") Integer id){
        return bookService.findImageByBookId(id);
    }

    @RequestMapping("/getBookStatistic")
    public BookStatistic getBookStatistic(@RequestBody Map<String, String> params) {return bookService.getBookStatistic();}

}
