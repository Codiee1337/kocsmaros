import model.Users.UserDAO;
import model.Users.User;
import model.Users.JpaUserDAO;


public class main {

    public static void main(String[] args) {



        try (UserDAO uDAO = new JpaUserDAO();) {



            //User u = uDAO.Register("Codiee1337", "P4ssw0rd","bvass18@gmail.com","Vass Tamás Balázs");
            User u = uDAO.Login("Codiee1337","P4ssw0rd");
            System.out.println(u.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
