
import model.Arlista.Arlista;
import model.Arlista.ArlistaDAO;
import model.Arlista.JpaArlistaDAO;
import model.Kocsmak.Kocsma;
import model.Kocsmak.JpaKocsmaDAO;
import model.Kocsmak.KocsmaDAO;
import model.Users.UserDAO;
import model.Users.User;
import model.Users.JpaUserDAO;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


public class main {

    public static void main(String[] args) {
        //java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);


        try (UserDAO uDAO = new JpaUserDAO(); KocsmaDAO kDAO = new JpaKocsmaDAO(); ArlistaDAO aDAO = new JpaArlistaDAO();) {



            //User u = uDAO.Register("Codiee1337", "P4ssw0rd","bvass18@gmail.com","Vass Tamás Balázs",1);
            User u = uDAO.Login("Codiee1337","P4ssw0rd");



            Kocsma k = kDAO.getKocsma(4);

            System.out.println(k.toString());

            List<Arlista> arlistaList = aDAO.getArlistakByKocsmaId(k.getId());



            for(Arlista a : arlistaList){
                System.out.println(a.toString());
            }



        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
