package inf.unideb.hu.model.Arlista;


import inf.unideb.hu.model.Product.Product;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Arlista {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;


    private int kocsma_id;


    private int product_id;


    private int productprice;


    @ManyToOne(optional=false)
    @JoinColumn(name="product_id",referencedColumnName="id",insertable = false,updatable = false)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductName(){
        return this.product.getName();
    }

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
                ", product=" + product +
                '}';
    }
}


