package inf.unideb.hu.model.Product;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    public String productname;


    //geoloc, longitude, latitude

    

    @Override
    public String toString() {
        return productname;
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

