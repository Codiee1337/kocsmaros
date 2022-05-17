package model.Arlista;

import java.util.List;

public interface ArlistaDAO extends AutoCloseable {



    public void saveArlista(Arlista a);
    public void removeArlista(Arlista a);
    public void updateArlista(Arlista a);
    public List<Arlista> getArlistak();

    List<Arlista> getArlistakByKocsmaId(int kocsma_id);

    List<Arlista> getAllProductListingsByProductyId(int product_id);

    public Arlista getArlista(int id);


}

