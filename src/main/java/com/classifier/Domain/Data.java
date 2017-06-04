package com.classifier.Domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Trabalho on 27/05/2017.
 */
public class Data {
    private Date initialDate;
    private Date finalDate;
    private String user;
    private ArrayList<App> listTask;
    private ArrayList<Mouse> listMouse;
    private ArrayList<Keyboard> listKeyboard;

    public Data() {
    }

    public Data(Date initialDate, Date finalDate, String user, ArrayList<App> listTask, ArrayList<Mouse> listMouse, ArrayList<Keyboard> listKeyboard) {
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.user = user;
        this.listTask = listTask;
        this.listMouse = listMouse;
        this.listKeyboard = listKeyboard;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setListApp(ArrayList<App> listTask) {
        this.listTask = listTask;
    }

    public void setListMouse(ArrayList<Mouse> listMouse) {
        this.listMouse = listMouse;
    }

    public void setListKeyboard(ArrayList<Keyboard> listKeyboard) {
        this.listKeyboard = listKeyboard;
    }

    public Date getInitialDate() {

        return initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public String getUser() {
        return user;
    }

    public ArrayList<App> getListApp() {
        return listTask;
    }

    public ArrayList<Mouse> getListMouse() {
        return listMouse;
    }

    public ArrayList<Keyboard> getListKeyboard() {
        return listKeyboard;
    }

    @Override
    public String toString() {
        return "Data{" +
                "initialDate=" + initialDate +
                ", finalDate=" + finalDate +
                ", user='" + user + '\'' +
                ", listTask=" + listTask +
                ", listMouse=" + listMouse +
                ", listKeyboard=" + listKeyboard +
                '}';
    }
}
