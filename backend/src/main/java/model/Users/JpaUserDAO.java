package model.Users;

import model.Helpers.Helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaUserDAO implements UserDAO {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kocsmarosPersistence");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveUser(User u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeUser(User u) {
        entityManager.getTransaction().begin();
        entityManager.remove(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateUser(User u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM Users u", User.class);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public User Login(String username, String password) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM USERS u Where username = \'"+username+"\' AND password = \'"+Helper.encryptThisString(password)+"\'", User.class);
        User u = query.getSingleResult();
        entityManager.getTransaction().begin();



        u.setLastLogin(new java.sql.Timestamp(System.currentTimeMillis()));
        entityManager.persist(u);
        entityManager.getTransaction().commit();
        return u;
    }

    @Override
    public User Register(String username, String password, String email, String name) {
        User u = new User();
        try {
            u.setUsername(username);
            u.setPassword(Helper.encryptThisString(password));
            u.setEmail(email);
            u.setName(name);
            u.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
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


    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
