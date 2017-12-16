package com.example.oliver.vezba161217_recyclerviewfragmenti.SharedPreferences;

import java.io.Serializable;

/**
 * Created by Oliver on 12/16/2017.
 */

public class User implements Serializable {

    public String name;
    public String lastname;
    public String slika;
    public int age;
    public String username;
    public String adress;
    public String password;

    public User(String name, String lastname,String slika,String username,String adress,int age,String password) {
        this.name = name;
        this.lastname = lastname;
        this.slika = slika;
        this.age = age;
        this.username = username;
        this.adress = adress;
        this.password = password;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
