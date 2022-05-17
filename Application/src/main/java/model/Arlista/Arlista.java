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
    private int product_id;

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

    public int getProduct_id() {
        return product_id;
    }



    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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
                ", product_id=" + product_id +
                ", productprice=" + productprice +
                '}';
    }
}


