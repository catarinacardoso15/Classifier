package com.classifier.Controller;


import Controller.DataBaseController;
import Model.*;
import com.classifier.Domain.App;
import com.classifier.Domain.Data;
import com.classifier.Domain.Keyboard;
import com.classifier.Domain.Mouse;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Catarina Cardoso on 03/06/2017.
 */
public class DataController {
    private ArrayList<Data> data;
    private DataBaseController dbcont;
    private Connection conn;

    public DataController() {
        this.data = new ArrayList<Data>();
        initiateConnection();
    }

    public DataController(Data data, DataBaseController dbcont) {
        this.data = new ArrayList<Data>();
        initiateConnection();
    }

    private void initiateConnection() {
        conn = new Connection("davide", "test1234", "islab.di.uminho.pt", "27017", "test", "test");
        dbcont = new DataBaseController(conn.getDataBase());
    }

    private void closeConnection() {
        conn.getMongoClient().close();
    }

    public void createData(Date i, Date f) {

        ArrayList<App> a = getAplications(i, f);
        data = getUserTask(a);
        for (int j = 0; j < data.size(); j++) {
            data.get(j).setInitialDate(i);
            data.get(j).setFinalDate(f);
            getDados(data.get(j).getInitialDate(), data.get(j).getFinalDate(), data.get(j));

        }

    }

    public ArrayList<Data> getData() {
        return data;
    }

    public ArrayList<App> getAplications(Date i, Date f) {
        i.setYear(i.getYear() + 1969);
        f.setYear(f.getYear() + 1969);
        System.out.println("-------------------");
        System.out.println(i.toGMTString());
        System.out.println(f.toGMTString());
        ArrayList<TaskRecords> records = dbcont.searchTasksByDate(i, f);
        System.out.println("Records Number: "+records.size());
        ArrayList<App> listT = new ArrayList<App>();
        for (int j = 0; j < records.size(); j++) {
            listT.addAll(getTaskFromRecords(records.get(j)));
            System.out.println("------"+j);
        }

        return listT;
    }

    public ArrayList<App> getAplications(Date i, Date f, String user) {
        i.setYear(i.getYear() + 1969);
        f.setYear(f.getYear() + 1969);
        User username = dbcont.searchTasksByUserName(i, f, user);
        ArrayList<TaskRecords> records = username.getTask();
        ArrayList<App> listT = new ArrayList<App>();
        for (int j = 0; j < records.size(); j++) {
            listT.addAll(getTaskFromRecords(records.get(j)));
        }
        return listT;
    }

    public ArrayList<App> getTaskFromRecords(TaskRecords t) {
        ArrayList<App> listT = new ArrayList<App>();
        for (int i = 0; i < t.getTasks().size() - 1; i++) {

            if (!t.getTasks().get(i).getName().equals("")) {
                // System.out.println(t.getTasks().get(i).getName());
                listT.add(new App(t.getTasks().get(i).getName(), t.getTasks().get(i).getData(), t.getUser()));
            }
        }
        return listT;
    }

    public ArrayList<Mouse> getMouse(Date i, Date f, String user) {

        User u = dbcont.searchMouseByUserName(i, f, user);
        ArrayList<Mouse> listM = new ArrayList<Mouse>();
        for (MouseRecords r : u.getMouse()) {
            listM.add(new Mouse(r.getMv(), r.getMa(), r.getCd(), r.getTbc(), r.getDbc(), r.getDdc(), r.getEdbc(), r.getAedbc(), r.getSsdbc(), r.getAsdbc(), r.getTdc(), r.getDplbc(), r.getAdpbc(), r.getDate().getTime()));
        }

        return listM;
    }

    public ArrayList<Keyboard> getKeyboard(Date i, Date f, String user) {

        User u = dbcont.searchKeyboardByUserName(i, f, user);
        ArrayList<Keyboard> listM = new ArrayList<Keyboard>();
        for (KeyboardRecords r : u.getKeyboard()) {
            listM.add(new Keyboard(r.getDate().getTime(), r.getKdt(), r.getTbk()));
        }
        return listM;
    }

    public Data getDados(Date i, Date f, Data user) {
        User u = dbcont.searchKeyboardMouseByUserName(i, f, user.getUser());

        ArrayList<Mouse> listM = new ArrayList<Mouse>();

        for (MouseRecords r : u.getMouse()) {
            listM.add(new Mouse(r.getMv(), r.getMa(), r.getCd(), r.getTbc(), r.getDbc(), r.getDdc(), r.getEdbc(), r.getAedbc(), r.getSsdbc(), r.getAsdbc(), r.getTdc(), r.getDplbc(), r.getAdpbc(), r.getDate().getTime()));
        }
        user.setListMouse(listM);
        ArrayList<Keyboard> listK = new ArrayList<Keyboard>();
        for (KeyboardRecords r : u.getKeyboard()) {
            listK.add(new Keyboard(r.getDate().getTime(), r.getKdt(), r.getTbk()));
        }
        user.setListKeyboard(listK);
        return user;
    }

    public ArrayList<Data> getUserTask(ArrayList<App> p) {
        HashMap<String, ArrayList<App>> listU = new HashMap<String, ArrayList<App>>();
        for (App aplication : p) {
            //if(aplication.getUser().startsWith("T2")){
            // System.out.println("sssssss");
            if (listU.containsKey(aplication.getUser())) {
                ArrayList<App> f = listU.get(aplication.getUser());
                f.add(aplication);
                listU.remove(aplication.getUser());

                listU.put(aplication.getUser(), f);
            } else {
                ArrayList<App> f = new ArrayList<App>();
                f.add(aplication);
                listU.put(aplication.getUser(), f);
            }

        }
        ArrayList<Data> d = new ArrayList<Data>();
        for (String key : listU.keySet()) {
            Data data = new Data();
            data.setUser(key);
            data.setListApp(listU.get(key));
            d.add(data);
        }
        return d;
    }
}
