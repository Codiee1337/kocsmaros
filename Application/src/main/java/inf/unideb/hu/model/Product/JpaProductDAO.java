package inf.unideb.hu.model.Product;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

import static inf.unideb.hu.main.entityManager;
import static inf.unideb.hu.main.entityManagerFactory;

public class JpaProductDAO implements ProductDAO {


    @Override
    public void saveProduct(Product u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeProduct(Product u) {
        entityManager.getTransaction().begin();
        entityManager.remove(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateProduct(Product u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public Product getProductByName(String name){
        TypedQuery<Product> query = entityManager.createQuery("SELECT u from Product u WHERE u.productname="+ "'" +name+ "'", Product.class);
        return query.getSingleResult();
    }

    @Override
    public ObservableList<Product> getProducts() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT u FROM Product u", Product.class);

        List<Product> kekw = query.getResultList();

        ObservableList<Product> users = FXCollections.observableArrayList();

        for (Product p : kekw){
            users.add(p);
        }


        return users;
    }

    @Override
    public Product getProduct(int id){
        TypedQuery<Product> query = entityManager.createQuery("SELECT k FROM Product k WHERE k.id = "+id, Product.class);


        Product Product = query.getSingleResult();
        return Product;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
