package model.Kocsmak;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaKocsmaDAO implements KocsmaDAO {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kocsmarosPersistence");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveKocsma(Kocsma u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeKocsma(Kocsma u) {
        entityManager.getTransaction().begin();
        entityManager.remove(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateKocsma(Kocsma u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Kocsma> getKocsmak() {
        TypedQuery<Kocsma> query = entityManager.createQuery(
                "SELECT u FROM Kocsma u", Kocsma.class);
        List<Kocsma> users = query.getResultList();
        return users;
    }

    @Override
    public Kocsma getKocsma(int id){
        TypedQuery<Kocsma> query = entityManager.createQuery(
                "SELECT k FROM Kocsma Where id = \""+id+"\"", Kocsma.class);
        Kocsma Kocsma = query.getSingleResult();
        return Kocsma;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
