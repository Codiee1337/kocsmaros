package inf.unideb.hu.model.Users;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name="USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String username;
    @Basic
    private String password;
    @Basic
    private String name;
    @Basic
    private String email;

    @Basic
    private java.sql.Timestamp LastLogin;

    @Basic
    private java.sql.Timestamp CreatedAt;

    @Basic
    private String favoritedrinks;

    @Basic
    private int userLevel;

    @Basic
    private int kocsma_id;

    public int getKocsma_id() {
        return kocsma_id;
    }

    public void setKocsma_id(int kocsma_id) {
        this.kocsma_id = kocsma_id;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public String getFavoritedrinks() {
        return favoritedrinks;
    }

    public void setFavoritedrinks(String favoritedrinks) {
        this.favoritedrinks = favoritedrinks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        LastLogin = lastLogin;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        CreatedAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", LastLogin=" + LastLogin +
                ", CreatedAt=" + CreatedAt +
                ", favoritedrinks='" + favoritedrinks + '\'' +
                ", userLevel=" + userLevel +
                ", kocsma_id=" + kocsma_id +
                '}';
    }
}
