import inf.unideb.hu.model.Exceptions.Exceptions;
import inf.unideb.hu.model.Kocsmak.JpaKocsmaDAO;
import inf.unideb.hu.model.Kocsmak.Kocsma;
import inf.unideb.hu.model.Kocsmak.KocsmaDAO;
import inf.unideb.hu.model.Users.JpaUserDAO;
import inf.unideb.hu.model.Users.User;
import inf.unideb.hu.model.Users.UserDAO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {

    static User GlobalUser;

    @Test
    @Order(1)
    public void RegisterTest(){
        UserDAO UserDAO = new JpaUserDAO();


        assertDoesNotThrow(()->GlobalUser=UserDAO.Register("TestUser","P4ssw0rd","test@test.test","Teszt Elek", 2));

        assertTrue(GlobalUser != null);

    }

    @Test
    @Order(2)
    public void LoginTest() throws Exceptions.UserDoesNotExist {





        UserDAO UserDao = new JpaUserDAO();


        assertDoesNotThrow(()->GlobalUser=UserDao.Login("TestUser","P4ssw0rd"));


        assertTrue(GlobalUser!=null);

    }

    @Test
    @Order(3)
    public void removeUserTest(){
        UserDAO uDAO = new JpaUserDAO();

        assertDoesNotThrow(()->uDAO.removeUser(GlobalUser));

    }

}
