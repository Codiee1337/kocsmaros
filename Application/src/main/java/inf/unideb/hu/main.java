package inf.unideb.hu;

import inf.unideb.hu.model.Arlista.Arlista;
import inf.unideb.hu.model.Arlista.ArlistaDAO;
import inf.unideb.hu.model.Arlista.JpaArlistaDAO;
import inf.unideb.hu.model.Users.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.logging.Level;


public class main extends Application{

    private static Scene scene;
    public static User u;
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kocsmarosPersistence");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    public static Stage stage;
    @Override
    public void start(final Stage stage) throws Exception {

        main.stage = stage;

        scene = new Scene(loadFXML("kocsmaroslogin"));
        //scene = new Scene(loadFXML("main"));
        stage.setTitle("KocsmÁros");
        stage.setScene(scene);

        stage.show();


    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        stage.sizeToScene();
    }

    private static Parent loadFXML(String fxml) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);




        /*
        try (ArlistaDAO aDAO = new JpaArlistaDAO();) {

            for(Arlista arlista : aDAO.getArlistakByKocsmaId(3)){
                System.out.println(arlista.getProduct().getName());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }*/
        launch();

            //User u = uDAO.Register("Codiee1337", "P4ssw0rd","bvass18@gmail.com","Vass Tamás Balázs",1);
            //Helper.getArlistaByProductName("Royal Vodka");













    }

}
