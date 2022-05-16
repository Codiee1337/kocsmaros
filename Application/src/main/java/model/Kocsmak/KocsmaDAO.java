package model.Kocsmak;

import java.util.List;

public interface KocsmaDAO extends AutoCloseable {



    public void saveKocsma(Kocsma k);
        public void removeKocsma(Kocsma k);
        public void updateKocsma(Kocsma k);
        public List<Kocsma> getKocsmak();
        public Kocsma getKocsma(int id);


}

