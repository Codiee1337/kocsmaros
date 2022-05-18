package inf.unideb.hu.model.Kocsmak;

import inf.unideb.hu.model.Users.User;

import java.util.List;

public interface KocsmaDAO extends AutoCloseable {



    void saveKocsma(Kocsma k);
        void removeKocsma(Kocsma k);
        void updateKocsma(Kocsma k);
        List<Kocsma> getKocsmak();
        Kocsma getKocsma(int id);



}

