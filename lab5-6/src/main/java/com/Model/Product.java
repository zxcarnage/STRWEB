package com.Model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "product")
public class Product
{
    @Id
    @Column(name= "name")
    private String name;
    @Column(name= "type")
    private String type;
    @Column(name= "count")
    private int count;
    @Column(name= "price")
    private int price;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product()
    {

    }

    public Product(String name, String type, int count, int price)
    {
        this.name=name;
        this.type=type;
        this.count=count;
        this.price=price;
    }


}
