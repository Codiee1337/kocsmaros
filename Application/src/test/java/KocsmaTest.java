import inf.unideb.hu.model.Kocsmak.JpaKocsmaDAO;
import inf.unideb.hu.model.Kocsmak.Kocsma;
import inf.unideb.hu.model.Kocsmak.KocsmaDAO;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KocsmaTest {

    @Test
    void saveKocsmaTest(){
        Kocsma testemp = new Kocsma();
        testemp.setName("tesztkocsma");
        testemp.setLatitude((double) 0);
        testemp.setLongitude((double) 0);



        KocsmaDAO kocsmaDao = new JpaKocsmaDAO();
        kocsmaDao.saveKocsma(testemp);

        var users = kocsmaDao.getKocsma(testemp.getId());
        assertTrue(users.equals(testemp));
    }
}
