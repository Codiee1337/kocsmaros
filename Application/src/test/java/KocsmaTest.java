import inf.unideb.hu.model.Exceptions.Exceptions;
import inf.unideb.hu.model.Kocsmak.JpaKocsmaDAO;
import inf.unideb.hu.model.Kocsmak.Kocsma;
import inf.unideb.hu.model.Kocsmak.KocsmaDAO;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.*;

public class KocsmaTest {

    static Kocsma globalkocsma;
    @Test
    public void saveKocsmaTest(){
        Kocsma kocsma = new Kocsma();
        kocsma.setName("savetesztkocsma");
        kocsma.setLatitude((double) 0);
        kocsma.setLongitude((double) 0);

        KocsmaDAO kocsmaDao = new JpaKocsmaDAO();
        kocsmaDao.saveKocsma(kocsma);

        assertDoesNotThrow(()->globalkocsma=kocsmaDao.getKocsma(kocsma.getId()));


        assertTrue(globalkocsma.equals(kocsma));

    }


    @Test
    public void removeKocsmaTestRight(){
        KocsmaDAO kocsmaDAO = new JpaKocsmaDAO();
        assertDoesNotThrow(()->kocsmaDAO.removeKocsma(globalkocsma));

    }

    @Test
    public void removeKocsmaTestNotRight(){
        KocsmaDAO kDAO = new JpaKocsmaDAO();
        assertThrows(Exceptions.KocsmaDoesNotExists.class,()->kDAO.removeKocsma(globalkocsma));
        ;
    }

}
