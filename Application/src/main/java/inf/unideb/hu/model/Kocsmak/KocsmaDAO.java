package inf.unideb.hu.model.Kocsmak;

import inf.unideb.hu.model.Exceptions.Exceptions;
import inf.unideb.hu.model.Users.User;

import java.util.List;

public interface KocsmaDAO extends AutoCloseable {



    void saveKocsma(Kocsma k);
        void removeKocsma(Kocsma k) throws Exceptions.KocsmaDoesNotExists;
        void updateKocsma(Kocsma k) throws Exceptions.KocsmaDoesNotExists;
        List<Kocsma> getKocsmak();
        Kocsma getKocsma(int id) throws Exceptions.KocsmaDoesNotExists;



}

