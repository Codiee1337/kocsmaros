package model.Kocsmak;

import javax.persistence.*;

@Entity
public class Kocsma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String name;
    //geoloc, longitude, latitude


    @Basic
    private Double Latitude;

    @Basic
    private Double Longitude;

    @Basic
    private int admin_id;


    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    @Override
    public String toString() {
        return "Kocsma{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Latitude=" + Latitude +
                ", Longitude=" + Longitude +
                ", admin_id=" + admin_id +
                '}';
    }
}

