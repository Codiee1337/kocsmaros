package inf.unideb.hu.model.Kocsmak;

import inf.unideb.hu.model.Exceptions.Exceptions;
import inf.unideb.hu.model.Users.User;

import javax.persistence.*;
import java.util.List;

import static inf.unideb.hu.main.entityManager;
import static inf.unideb.hu.main.entityManagerFactory;

public class JpaKocsmaDAO implements KocsmaDAO {

    @Override
    public void saveKocsma(Kocsma u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeKocsma(Kocsma u) throws Exceptions.KocsmaDoesNotExists {
        entityManager.getTransaction().begin();

        getKocsma(u.getId());

        entityManager.remove(u);

        entityManager.getTransaction().commit();
    }

    @Override
    public void updateKocsma(Kocsma u) throws Exceptions.KocsmaDoesNotExists {
        entityManager.getTransaction().begin();
        getKocsma(u.getId());
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
    public Kocsma getKocsma(int id) throws Exceptions.KocsmaDoesNotExists {
        try {
            TypedQuery<Kocsma> query = entityManager.createQuery("SELECT k FROM Kocsma k WHERE k.id = " + id, Kocsma.class);


            Kocsma kocsma = query.getSingleResult();
            return kocsma;
        }catch(NoResultException e){
            throw new Exceptions.KocsmaDoesNotExists();
        }



    }



    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
