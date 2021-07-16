package com.reins.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.Fetch;


import javax.persistence.*;

/**
 * @ClassName Book
 * @Description Book Entity
 * @Author thunderBoy
 * @Date 2019/11/5 19:19
 */
@Data
@Entity
@Table(name = "book")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "bookId")
public class Book {

    @Id
    @Column(name = "id")
    private int bookId;

    private String isbn;
    private String name;
    private String type;
    private String author;
    private Double price;
    private String description;
    private Integer inventory;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imageId")
    private Image bookImage;

    public Image getBookImage() {
        return bookImage;
    }
}
