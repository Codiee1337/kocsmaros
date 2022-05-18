package inf.unideb.hu.Controller;

import inf.unideb.hu.main;
import inf.unideb.hu.model.Arlista.Arlista;
import inf.unideb.hu.model.Arlista.ArlistaDAO;
import inf.unideb.hu.model.Arlista.JpaArlistaDAO;
import inf.unideb.hu.model.Product.JpaProductDAO;
import inf.unideb.hu.model.Product.Product;
import inf.unideb.hu.model.Product.ProductDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;


public class ujablakController {


    @FXML
    private Button arlistaSaveButton;

    @FXML
    private VBox megjelenitofelulet;

    @FXML
    public TableView<Arlista> table;

    @FXML
    public TableView<Product> table2;

    @FXML
    private TextField productPrice;



    @FXML
    private ChoiceBox<String> productSelectableList;

    @FXML
    private Button saveButton;

    public Arlista currentlySelectedArlista;

    @FXML
    private Label errorkuldoLabel;

    @FXML
    private Label termekLabel;

    @FXML
    private Label termekpriceLaber;

    @FXML
    private Label termeklabel2;

    @FXML
    private Button saveProductButton;

    @FXML
    private TextField productNameTextField;

    @FXML
    private Button saveNewArlista;

    //beloadolja a data-t attól függően h mire kattintasz, árlistákra(1) vagy pedig termékekre(2)
    void loadData(int option) {
        errorkuldoLabel.setVisible(false);

        productSelectableList.getSelectionModel().clearSelection();
        productSelectableList.getItems().clear();
        table.getColumns().clear();
        table.getItems().clear();

        if (option == 1) {
            productPrice.setVisible(true);
            productSelectableList.setVisible(true);
            arlistaSaveButton.setVisible(true);
            termekLabel.setVisible(true);
            termekpriceLaber.setVisible(true);
            saveNewArlista.setVisible(true);

            table.setVisible(true);
            table2.setVisible(false);

            termeklabel2.setVisible(false);
            saveProductButton.setVisible(false);
            productNameTextField.setVisible(false);

            TableColumn<Arlista, Integer> arlista_idColumn = new TableColumn<>("Termék sorszáma");
            arlista_idColumn.setMinWidth(150);
            arlista_idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

            TableColumn<Arlista, String> product_name = new TableColumn<>("Termék megnevezése");
            product_name.setMinWidth(200);
            //product_name.setCellValueFactory(new PropertyValueFactory<>("product"));
            product_name.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getProduct().productname));

            TableColumn<Arlista, Integer> product_price = new TableColumn<>("Termék ára");
            product_price.setMinWidth(200);
            product_price.setCellValueFactory(new PropertyValueFactory<>("productprice"));

            ArlistaDAO aDAO = new JpaArlistaDAO();

            table.getColumns().addAll(arlista_idColumn, product_name, product_price);
            //table.setItems();
            table.setItems(aDAO.getArlistakByKocsmaId(main.u.getKocsma_id()));

            ProductDAO pDAO = new JpaProductDAO();

            for (Product p : pDAO.getProducts()) {
                productSelectableList.getItems().add(p.getName());
            }

            table.setOnMouseClicked((MouseEvent event) -> {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    currentlySelectedArlista = table.getSelectionModel().getSelectedItem();
                    productSelectableList.getSelectionModel().select(currentlySelectedArlista.getProduct().getName());
                    productPrice.setText(currentlySelectedArlista.getProductprice() + "");
                    errorkuldoLabel.setVisible(false);
                }
            });
        }
        if (option == 2) {
            productPrice.setVisible(false);
            productSelectableList.setVisible(false);
            arlistaSaveButton.setVisible(false);
            termekLabel.setVisible(false);
            termekpriceLaber.setVisible(false);
            saveNewArlista.setVisible(false);

            table.setVisible(false);
            table2.setVisible(true);

            termeklabel2.setVisible(true);
            saveProductButton.setVisible(true);
            productNameTextField.setVisible(true);

            errorkuldoLabel.setVisible(false);

            table2.getColumns().clear();
            table2.getItems().clear();

            TableColumn<Product, Integer> product_idColumn = new TableColumn<>("Termék ID-je");
            product_idColumn.setMinWidth(150);
            product_idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

            TableColumn<Product, String> product_name1 = new TableColumn<>("Termék megnevezése");
            product_name1.setMinWidth(200);
            product_name1.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().productname));

            ProductDAO pDAO = new JpaProductDAO();
            table2.getColumns().addAll(product_idColumn, product_name1);
            table2.getItems().setAll(pDAO.getProducts());
        }
    }

    @FXML
    void saveProductButtonAction(ActionEvent event) {
        ProductDAO pDAO = new JpaProductDAO();
        Product p = new Product();
        p.setName(productNameTextField.getText());
        pDAO.saveProduct(p);
        table2.getItems().setAll(pDAO.getProducts());
        table2.refresh();
    }

    @FXML
    void arlistaButton(ActionEvent event) throws Exception {
        loadData(1);
    }

    @FXML
    void saveButton(ActionEvent event) throws Exception {
        ArlistaDAO aDAO = new JpaArlistaDAO();
        ProductDAO pDAO = new JpaProductDAO();
        if (currentlySelectedArlista != null) {
            currentlySelectedArlista.setProduct_id(pDAO.getProductByName(productSelectableList.getSelectionModel().getSelectedItem()).getId());
            currentlySelectedArlista.setProductprice(Integer.parseInt(productPrice.getText()));
            if (aDAO.isThereAnyMoreProductListings(currentlySelectedArlista.getProduct_id(), currentlySelectedArlista.getKocsma_id()) == false) {
                if (aDAO.isItTheOne(currentlySelectedArlista.getId())) {
                    currentlySelectedArlista = aDAO.updateArlista(currentlySelectedArlista);
                    table.setItems(aDAO.getArlistakByKocsmaId(main.u.getKocsma_id()));
                }
            } else {
                errorkuldoLabel.setVisible(true);
            }
        }
    }

    @FXML
    void saveNewArlistaAction(ActionEvent event) {
        System.out.println("KURVA ANYAD");
        ArlistaDAO aDAO = new JpaArlistaDAO();
        ProductDAO pDAO = new JpaProductDAO();

        Arlista arlista = new Arlista();
        arlista.setProduct_id(pDAO.getProductByName(productSelectableList.getSelectionModel().getSelectedItem()).getId());
       /* System.out.println(pDAO.getProductByName(productSelectableList.getSelectionModel().getSelectedItem()).getName());
        System.out.println(Integer.parseInt(productPrice.getText()));
        System.out.println(main.u.getKocsma_id());
        */arlista.setProductprice(Integer.parseInt(productPrice.getText()));
        arlista.setKocsma_id(main.u.getKocsma_id());

        aDAO.saveArlista(arlista);
        table.getItems().setAll(aDAO.getArlistakByKocsmaId(main.u.getKocsma_id()));
        table.refresh();




    }

    @FXML
    void termekekButton(ActionEvent event) {
        loadData(2);
    }


}

