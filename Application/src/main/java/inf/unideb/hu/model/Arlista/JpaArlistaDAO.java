package inf.unideb.hu.model.Arlista;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.TypedQuery;
import java.util.List;

import static inf.unideb.hu.main.entityManager;
import static inf.unideb.hu.main.entityManagerFactory;

public class JpaArlistaDAO implements ArlistaDAO {



    @Override
    public void saveArlista(Arlista u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();

    }

    @Override
    public void removeArlista(Arlista u)  {
        entityManager.getTransaction().begin();
        entityManager.remove(u);
        entityManager.getTransaction().commit();
    }



    @Override
    public Arlista updateArlista(Arlista u)  {

        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
        return u;

    }

    @Override
    public List<Arlista> getArlistak()  {
        TypedQuery<Arlista> query = entityManager.createQuery(
                "SELECT u FROM Arlista u", Arlista.class);
        List<Arlista> users = query.getResultList();

        return users;
    }

    @Override
    public ObservableList<Arlista> getArlistakByKocsmaId(int kocsma_id) {


        ObservableList<Arlista> arlistak = FXCollections.observableArrayList();
        TypedQuery<Arlista> query = entityManager.createQuery("SELECT a FROM Arlista a WHERE a.kocsma_id = "+kocsma_id, Arlista.class);


        List<Arlista> arlistaObservableList = query.getResultList();

        for(Arlista arlista : arlistaObservableList){
            arlistak.add(arlista);
        }

        return arlistak;

    }



    @Override
    public boolean isThereAnyMoreProductListings(int product_id, int kocsma_id) {
        TypedQuery<Arlista> query = entityManager.createQuery("Select a FROM Arlista a WHERE a.product_id = "+product_id+" AND a.kocsma_id="+kocsma_id, Arlista.class);

        boolean asd = false;
        asd = query.getResultList().size() > 1;


        return asd;
    }

    @Override
    public boolean isItTheOne(int arlista_id){
        TypedQuery<Arlista> query = entityManager.createQuery("Select a FROM Arlista a WHERE a.id="+arlista_id, Arlista.class);


        return query.getSingleResult().getId() == arlista_id;



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
