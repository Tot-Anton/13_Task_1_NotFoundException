package ru.netology.domain;

public class Smartphone extends Product {
    protected String name;
    protected String manufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int cost, String manufacturer) {
        super(id, name, cost);
        this.manufacturer = manufacturer;
    }
}
