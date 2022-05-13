package ru.netology.domain;

public class Book extends Product {
    protected String name;
    protected String author;

    public Book() {
        super();
    }

    public Book(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.author = author;
    }
}
