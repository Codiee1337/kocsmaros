import inf.unideb.hu.model.Exceptions.Exceptions;
import inf.unideb.hu.model.Kocsmak.JpaKocsmaDAO;
import inf.unideb.hu.model.Kocsmak.Kocsma;
import inf.unideb.hu.model.Kocsmak.KocsmaDAO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KocsmaTest {

    static Kocsma globalkocsma;

    @Test
    @Order(1)
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
    @Order(2)
    public void updateKocsmaTestRight(){
        KocsmaDAO kocsmaDAO = new JpaKocsmaDAO();
        assertDoesNotThrow(()->kocsmaDAO.updateKocsma(globalkocsma));
    }

    @Test
    @Order(3)
    public void removeKocsmaTestRight(){
        KocsmaDAO kocsmaDAO = new JpaKocsmaDAO();
        assertDoesNotThrow(()->kocsmaDAO.removeKocsma(globalkocsma));
    }

    @Test
    @Order(4)
    public void updateKocsmaDoesNotTestRight(){
        KocsmaDAO kocsmaDAO = new JpaKocsmaDAO();
        assertThrows(Exceptions.KocsmaDoesNotExists.class,()->kocsmaDAO.updateKocsma(globalkocsma));
    }





}
