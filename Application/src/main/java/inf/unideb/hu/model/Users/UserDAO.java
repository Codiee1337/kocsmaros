package inf.unideb.hu.model.Users;

import inf.unideb.hu.model.Exceptions.Exceptions;

import java.util.List;

public interface UserDAO extends AutoCloseable {

    void saveUser(User u);
    void removeUser(User u);
    void updateUser(User u);
    List<User> getUsers();

    User Login(String username, String password) throws Exceptions.UserDoesNotExist;

    User addFavoriteDrinks(User u, String[] drinksToAdd);

    User removeFavoriteDrinks(User u);

    User Register(String username, String password, String email, String name, int userLevel);


}
