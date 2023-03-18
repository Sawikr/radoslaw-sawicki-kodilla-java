package com.kodilla.hibernate.invoice;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    private int id;
    private String name;
    private List<Item> item = new ArrayList<>();

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
            )
    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
