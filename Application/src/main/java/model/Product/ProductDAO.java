package model.Product;

import java.util.List;

public interface ProductDAO extends AutoCloseable{


    public abstract void saveProduct(Product u);

    public abstract void removeProduct(Product u);

    public abstract void updateProduct(Product u);

    Product getProductByName(String name);

    public abstract List<Product> getProducts();

    public abstract Product getProduct(int id);

    public abstract void close() throws Exception;
}
