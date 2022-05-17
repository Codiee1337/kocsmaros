package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Users.JpaUserDAO;
import model.Users.User;
import model.Users.UserDAO;

public class loginPanelController {

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void LoginButton(ActionEvent event) {
        try{
            UserDAO uDAO = new JpaUserDAO();
            User u = uDAO.Login(username.getText(),password.getText());
            System.out.println(u.toString());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @FXML
    void RegisterButton(ActionEvent event) {

    }

}
