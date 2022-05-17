package model.Product;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String productname;
    //geoloc, longitude, latitude


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + productname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return productname;
    }

    public void setName(String name) {
        this.productname = name;
    }
}

