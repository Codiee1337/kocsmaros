
import model.Users.UserDAO;
import model.Users.User;
import model.Users.JpaUserDAO;

import java.util.logging.Level;


public class main {

    public static void main(String[] args) {
        //java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);


        try (UserDAO uDAO = new JpaUserDAO();) {



            //User u = uDAO.Register("Codiee1337", "P4ssw0rd","bvass18@gmail.com","Vass Tamás Balázs");
            User u = uDAO.Login("Codiee1337","P4ssw0rd");

            uDAO.removeFavoriteDrinks(u);

            System.out.println(u.toString());


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
