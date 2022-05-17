import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Helpers.Helper;


import java.util.logging.Level;


public class main extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(main.class.getResource("/fxml/kocsmaroslogin.fxml"));

        Scene scene = new Scene(loader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);


       // try (KocsmaDAO kDAO = new JpaKocsmaDAO(); ArlistaDAO aDAO = new JpaArlistaDAO();) {

            //launch();

            //User u = uDAO.Register("Codiee1337", "P4ssw0rd","bvass18@gmail.com","Vass Tamás Balázs",1);
            Helper.getArlistaByProductName("Royal Vodka");













    }

}
