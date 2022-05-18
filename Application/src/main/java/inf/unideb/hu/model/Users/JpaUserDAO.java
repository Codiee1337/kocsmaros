package inf.unideb.hu.model.Users;

import inf.unideb.hu.model.Exceptions.Exceptions;
import inf.unideb.hu.model.Helpers.Helper;
import org.json.JSONObject;

import javax.persistence.*;
import java.sql.Types;
import java.util.List;

import static inf.unideb.hu.main.entityManager;
import static inf.unideb.hu.main.entityManagerFactory;


public class JpaUserDAO implements UserDAO {

    //java shit.



    //Save user to Database.
    @Override
    public void saveUser(User u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }

    //Remove user from Database.
    @Override
    public void removeUser(User u) {
        entityManager.getTransaction().begin();
        entityManager.remove(u);
        entityManager.getTransaction().commit();
    }

    //Update user in Database
    @Override
    public void updateUser(User u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }

    //Get ALL Users from Database. (GDPR LOL)
    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM Users u", User.class);
        List<User> users = query.getResultList();
        return users;
    }

    //Login with ID and PW encrypt on backend very unsafe but it works for now.
    @Override
    public User Login(String username, String password) throws Exceptions.UserDoesNotExist {
        User u;
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM USERS u Where username = '" +username+ "' AND password = '" +Helper.encryptThisString(password)+ "'", User.class);

        try {
            u = query.getSingleResult();
        }catch(NoResultException e)
        {
            throw new Exceptions.UserDoesNotExist();
        }
        entityManager.getTransaction().begin();



        u.setLastLogin(new java.sql.Timestamp(System.currentTimeMillis()));
        entityManager.persist(u);
        entityManager.getTransaction().commit();
        return u;
    }

    //addFavoriteDrinks (Gets an array that contains all the favorite drinks)
    @Override
    public User addFavoriteDrinks(User u, String[] drinksToAdd){
        JSONObject obj = new JSONObject();
        obj.put("favoritedrinks",drinksToAdd);
        u.setFavoritedrinks(obj.toString());

        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
        return u;
    }

    //Nulls out the favoriteDrinks attribute of the user.
    @Override
    public User removeFavoriteDrinks(User u){
        u.setFavoritedrinks(String.valueOf(Types.NULL));
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
        return u;
    }

    //Register method w/ username, password, email, name, userLevel.
    @Override
    public User Register(String username, String password, String email, String name, int userLevel) {
        User u = new User();
        try {
            //Esetleg a jövőben kód alapján kocsma regisztráció.
            u.setUsername(username);
            u.setPassword(Helper.encryptThisString(password));
            u.setEmail(email);
            u.setName(name);
            u.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
            u.setUserLevel(userLevel);
                entityManager.getTransaction().begin();
                entityManager.persist(u);
                entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            return u;
        }
    }

    //java shit.
    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
