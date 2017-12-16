package com.example.oliver.vezba161217_recyclerviewfragmenti;

import java.io.Serializable;

/**
 * Created by Oliver on 12/16/2017.
 */

public class User implements Serializable {

    public String name;
    public String lastname;

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
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
