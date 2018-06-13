package com.imie;

/**
 * Created by Blackwaxx on 13/06/2018.
 */
public class Player {
    protected int id;
    protected String name;
    protected boolean isConnected;

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

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }
}
