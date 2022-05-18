package inf.unideb.hu.model.Product;

import javafx.collections.ObservableList;

import java.util.List;

public interface ProductDAO extends AutoCloseable{


    void saveProduct(Product u);

    void removeProduct(Product u);

    void updateProduct(Product u);

    Product getProductByName(String name);

    ObservableList<Product> getProducts();

    Product getProduct(int id);

    void close() throws Exception;
}
