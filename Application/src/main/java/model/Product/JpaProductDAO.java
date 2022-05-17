package model.Product;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaProductDAO implements ProductDAO {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kocsmarosPersistence");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

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
        TypedQuery<Product> query = entityManager.createQuery("SELECT u from Product u WHERE u.productname="+"\'"+name+"\'", Product.class);
        return query.getSingleResult();
    }

    @Override
    public List<Product> getProducts() {
        TypedQuery<Product> query = entityManager.createQuery(
                "SELECT u FROM Product u", Product.class);
        List<Product> users = query.getResultList();
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
