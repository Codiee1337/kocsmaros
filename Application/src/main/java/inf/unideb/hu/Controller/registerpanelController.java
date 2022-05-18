package inf.unideb.hu.Controller;

import inf.unideb.hu.main;
import inf.unideb.hu.model.Users.JpaUserDAO;
import inf.unideb.hu.model.Users.User;
import inf.unideb.hu.model.Users.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;

public class registerpanelController {

    @FXML
    private Button RegisterButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label registrationError;

    @FXML
    private Label registrationSuccessful;

    @FXML
    void backButtonPushed(ActionEvent event) throws IOException {
        main.setRoot("kocsmaroslogin");
    }

    @FXML
    void registerButtonPushed(ActionEvent event) {



        try(UserDAO u = new JpaUserDAO()){


        u.Register(username.getText() , password.getText(), email.getText(), name.getText(), 2);

        if(u!=null){
            registrationSuccessful.setVisible(true);
            name.setVisible(false);
            password.setVisible(false);
            email.setVisible(false);
            username.setVisible(false);
            RegisterButton.setVisible(false);


        }
        }catch(Exception e) {


            registrationError.setVisible(true);
            name.setVisible(false);
            password.setVisible(false);
            email.setVisible(false);
            username.setVisible(false);
            RegisterButton.setVisible(false);
        }

    }

}

