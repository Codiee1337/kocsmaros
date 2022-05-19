package inf.unideb.hu.Controller;

import inf.unideb.hu.main;
import inf.unideb.hu.model.Helpers.Helper;
import inf.unideb.hu.model.Product.JpaProductDAO;
import inf.unideb.hu.model.Product.Product;
import inf.unideb.hu.model.Product.ProductDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class userPanelController {

    @FXML
    private ChoiceBox<Product> productChoiceList;

    @FXML
    private Button getHolIgyakButton;

    @FXML
    private Label legolcsobbLaber;

    @FXML
    void onHolIgyakClick(ActionEvent event) {
        ProductDAO pDAO = new JpaProductDAO();
        productChoiceList.getItems().setAll(pDAO.getProducts());




    }

    @FXML
    void getHolIgyakButtonAction(ActionEvent event) throws Exception {


        legolcsobbLaber.setText(Helper.getArlistaByProductName(productChoiceList.getSelectionModel().getSelectedItem().getName()));
    }

}

