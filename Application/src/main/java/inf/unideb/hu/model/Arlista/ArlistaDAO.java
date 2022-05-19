package inf.unideb.hu.model.Arlista;

import inf.unideb.hu.model.Exceptions.Exceptions;
import inf.unideb.hu.model.Product.Product;
import javafx.collections.ObservableList;

import java.util.List;

public interface ArlistaDAO extends AutoCloseable {



    void saveArlista(Arlista a);
    void removeArlista(Arlista a);


    List<Arlista> getAllProductListingsByProductId(int product_id);

    Arlista updateArlista(Arlista a);
    List<Arlista> getArlistak();

    ObservableList<Arlista> getArlistakByKocsmaId(int kocsma_id);



    boolean isThereAnyMoreProductListings(int product_id, int kocsma_id);



    boolean isItTheOne(int arlista_id);

    Arlista getArlista(int id);


}

