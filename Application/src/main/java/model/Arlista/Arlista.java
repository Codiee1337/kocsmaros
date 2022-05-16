package model.Arlista;

import javax.persistence.*;

@Entity
public class Arlista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private int kocsma_id;

    @Basic
    private String productname;

    @Basic
    private int productprice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKocsma_id() {
        return kocsma_id;
    }

    public void setKocsma_id(int kocsma_id) {
        this.kocsma_id = kocsma_id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getProductprice() {
        return productprice;
    }

    public void setProductprice(int productprice) {
        this.productprice = productprice;
    }


    @Override
    public String toString() {
        return "Arlista{" +
                "id=" + id +
                ", kocsma_id=" + kocsma_id +
                ", productname='" + productname + '\'' +
                ", productprice=" + productprice +
                '}';
    }
}


