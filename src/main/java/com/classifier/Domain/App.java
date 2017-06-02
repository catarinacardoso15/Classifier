package com.classifier.Domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Catarina Cardoso on 02/06/2017.
 */
public class App {
    private ArrayList<String> listT;
    private String name;
    private Date time;
    private String user;

    public App() {
    }

    public App(ArrayList<String> listT, String name, Date time, String user) {
        this.listT = listT;
        this.name = name;
        this.time = time;
        this.user = user;
    }

    public ArrayList<String> getListT() {
        return listT;
    }

    public void setListT(ArrayList<String> listT) {
        this.listT = listT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Aplication{" +
                "listT=" + listT +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", user='" + user + '\'' +
                '}';
    }
}
