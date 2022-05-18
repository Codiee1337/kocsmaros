package inf.unideb.hu.model.Helpers;

import inf.unideb.hu.model.Arlista.Arlista;
import inf.unideb.hu.model.Arlista.ArlistaDAO;
import inf.unideb.hu.model.Arlista.JpaArlistaDAO;
import inf.unideb.hu.model.Exceptions.Exceptions;
import inf.unideb.hu.model.Kocsmak.JpaKocsmaDAO;
import inf.unideb.hu.model.Kocsmak.Kocsma;
import inf.unideb.hu.model.Kocsmak.KocsmaDAO;
import inf.unideb.hu.model.Product.JpaProductDAO;
import inf.unideb.hu.model.Product.Product;
import inf.unideb.hu.model.Product.ProductDAO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Helper {
    public static String encryptThisString(String input)
    {
        try {
            // getInstance() method is called with algorithm SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getArlistaByProductName(String productname) throws Exception {
        ProductDAO pDAO = new JpaProductDAO();
        Product p = pDAO.getProductByName(productname);

        ArlistaDAO aDAO = new JpaArlistaDAO();

        List<Arlista> Arlistaforcertainproduct = null;
        /*try {
            //Arlistaforcertainproduct = aDAO.getAllProductListingsByProductId(p.getId());
        } catch (Exceptions.ArlistaExists e) {
            e.printStackTrace();
        }

        KocsmaDAO kDAO = new JpaKocsmaDAO();

        for(Arlista a : Arlistaforcertainproduct){
            Kocsma k = kDAO.getKocsma(a.getKocsma_id());
            System.out.println(k.getName()+" kocsmában ennyibe kerül a "+p.getName()+": "+a.getProductprice());
        }*/






    }

}