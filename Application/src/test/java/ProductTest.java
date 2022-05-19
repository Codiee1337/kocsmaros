import inf.unideb.hu.model.Exceptions.Exceptions;
import inf.unideb.hu.model.Product.JpaProductDAO;
import inf.unideb.hu.model.Product.Product;
import inf.unideb.hu.model.Product.ProductDAO;
import javafx.collections.FXCollections;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductTest {

    static Product GlobalProduct;

    @Test
    @Order(1)
    public void ProductSaveTest(){
        ProductDAO pDAO = new JpaProductDAO();

        Product p = new Product();
        p.setName("asdasd");

        pDAO.saveProduct(p);


        assertDoesNotThrow(()->GlobalProduct=pDAO.getProduct(p.getId()));

        assertTrue(GlobalProduct != null);

    }

    @Test
    @Order(2)
    public void ProductRemoveTest() {





      ProductDAO pDAO = new JpaProductDAO();


        assertDoesNotThrow(()->pDAO.removeProduct(GlobalProduct));




    }

    @Test
    @Order(3)
    public void ProductGetNotRight(){
        ProductDAO pDAO = new JpaProductDAO();

        assertTrue(pDAO.getProducts()!=null);


    }

}


