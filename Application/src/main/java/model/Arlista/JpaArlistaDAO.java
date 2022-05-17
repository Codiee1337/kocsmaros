package model.Arlista;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaArlistaDAO implements ArlistaDAO {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kocsmarosPersistence");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveArlista(Arlista u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeArlista(Arlista u) {
        entityManager.getTransaction().begin();
        entityManager.remove(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateArlista(Arlista u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Arlista> getArlistak() {
        TypedQuery<Arlista> query = entityManager.createQuery(
                "SELECT u FROM Arlista u", Arlista.class);
        List<Arlista> users = query.getResultList();
        return users;
    }

    @Override
    public List<Arlista> getArlistakByKocsmaId(int kocsma_id) {
        TypedQuery<Arlista> query = entityManager.createQuery("SELECT a FROM Arlista a WHERE a.kocsma_id = "+kocsma_id, Arlista.class);

        List<Arlista> arlistaList = query.getResultList();
        return arlistaList;
    }



    @Override
    public List<Arlista> getAllProductListingsByProductyId(int product_id){
        TypedQuery<Arlista> query = entityManager.createQuery("Select a FROM Arlista a WHERE a.product_id = "+product_id, Arlista.class);
        return query.getResultList();
    }

    @Override
    public Arlista getArlista(int id){
        TypedQuery<Arlista> query = entityManager.createQuery(
                "SELECT k FROM Arlista Where id = \""+id+"\"", Arlista.class);
        Arlista Arlista = query.getSingleResult();
        return Arlista;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

}
