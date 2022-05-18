package inf.unideb.hu.Controller;

import inf.unideb.hu.main;
import inf.unideb.hu.model.Exceptions.Exceptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import inf.unideb.hu.model.Users.JpaUserDAO;
import inf.unideb.hu.model.Users.User;
import inf.unideb.hu.model.Users.UserDAO;

import java.io.IOException;

public class loginPanelController {



    @FXML
    private PasswordField password;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField username;

    @FXML
    void LoginButton(ActionEvent event) {
        try{
            UserDAO uDAO = new JpaUserDAO();

            main.u = uDAO.Login(username.getText(),password.getText());

            if(main.u!=null && main.u.getUserLevel() == 2) {
                main.setRoot("menu");
            }else if(main.u!=null && main.u.getUserLevel()==1){
                main.setRoot("ujablak");
            }

            //System.out.println(u.toString());

        } catch (Exceptions.UserDoesNotExist e) {
            errorLabel.setVisible(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    void RegisterButton(ActionEvent event) throws IOException {

        main.setRoot("register_panel");


    }

}
