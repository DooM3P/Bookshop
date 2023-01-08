package com.example.Bookshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;


@Entity
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Collection<Book> books;

    public Category(Long code) {
        this.code = code;
        this.name= null;
    }

    public Category(String code) {
        this.code = 1L;
    }
    public Category(){

        }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public Collection<Book> getBooks() {
        return books;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

}
