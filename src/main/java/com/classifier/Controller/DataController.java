package com.classifier.Controller;


import Controller.DataBaseController;
import Model.*;
import com.classifier.DTO.MongoDTO;
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
    private MongoDTO connectionMongo;


    public DataController() {
        this.data = new ArrayList<Data>();
        this.connectionMongo = new MongoDTO();
    }

    public DataController(Data data, DataBaseController dbcont) {
        this.data = new ArrayList<Data>();
        this.connectionMongo = new MongoDTO();
    }

    public ArrayList<Data> getData() {
        return data;
    }


    public ArrayList<Data> createData(Date i, Date f) {
        i.setYear(i.getYear() + 1969);
        f.setYear(f.getYear() + 1969);
        ArrayList<App> a = getAplications(i, f);
        data = getUserTask(a);
        data.forEach(d -> {
            d.setInitialDate(i);
            d.setFinalDate(f);
            getDados(d.getInitialDate(), d.getFinalDate(), d);

        });
        return data;
    }


    public ArrayList<App> getAplications(Date i, Date f) {
        ArrayList<TaskRecords> records = connectionMongo.getTaskDate(i,f);
        ArrayList<App> listT = new ArrayList<App>();
        records.forEach(taskRecords -> listT.addAll(getTaskFromRecords(taskRecords)));
        return listT;
    }

    public ArrayList<App> getAplications(Date i, Date f, String nameUser) {
        User user = connectionMongo.getTaskUser(i,f,nameUser);
        ArrayList<TaskRecords> records = user.getTask();
        ArrayList<App> listT = new ArrayList<App>();
        records.forEach(taskRecords -> listT.addAll(getTaskFromRecords(taskRecords)));
        return listT;
    }

    public ArrayList<App> getTaskFromRecords(TaskRecords t) {
        ArrayList<App> listT = new ArrayList<App>();
        t.getTasks().forEach(task -> {
            if (!task.getName().equals("")) {
                listT.add(new App(task.getName(), task.getData(), t.getUser()));
            }
        });
        return listT;
    }

    public ArrayList<Mouse> getMouse(Date i, Date f, String user) {

        User u = connectionMongo.getMouseUser(i, f, user);

        ArrayList<Mouse> listM = new ArrayList<Mouse>();
        u.getMouse().forEach(r -> listM.add(new Mouse(r.getMv(), r.getMa(), r.getCd(), r.getTbc(), r.getDbc(), r.getDdc()
                , r.getEdbc(), r.getAedbc(), r.getSsdbc(), r.getAsdbc(), r.getTdc(), r.getDplbc(),
                r.getAdpbc(), r.getDate().getTime())));


        return listM;
    }

    public ArrayList<Keyboard> getKeyboard(Date i, Date f, String user) {
        User u = connectionMongo.getKeyboardUser(i,f,user);
        ArrayList<Keyboard> listM = new ArrayList<Keyboard>();
        u.getKeyboard().forEach(r -> listM.add(new Keyboard(r.getDate().getTime(), r.getKdt(), r.getTbk())));
        return listM;
    }

    public Data getDados(Date i, Date f, Data user) {
        User u =connectionMongo.getMouseKeyboardUser(i,f,user.getUser());
        ArrayList<Keyboard> listK = new ArrayList<Keyboard>();
        ArrayList<Mouse> listM = new ArrayList<Mouse>();
        u.getMouse().forEach(r -> listM.add(new Mouse(r.getMv(), r.getMa(), r.getCd(), r.getTbc(), r.getDbc(), r.getDdc(), r.getEdbc(),
                r.getAedbc(), r.getSsdbc(), r.getAsdbc(), r.getTdc(), r.getDplbc(), r.getAdpbc(), r.getDate().getTime())));
        user.setListMouse(listM);
        u.getKeyboard().forEach(r -> listK.add(new Keyboard(r.getDate().getTime(), r.getKdt(), r.getTbk())));
        user.setListKeyboard(listK);
        return user;
    }

    public ArrayList<Data> getUserTask(ArrayList<App> p) {
        HashMap<String, ArrayList<App>> listU = new HashMap<String, ArrayList<App>>();
        p.forEach(app -> {
            if (listU.containsKey(app.getUser())) {
                ArrayList<App> f = listU.get(app.getUser());
                f.add(app);
                listU.remove(app.getUser());
                listU.put(app.getUser(), f);
            } else {
                ArrayList<App> f = new ArrayList<App>();
                f.add(app);
                listU.put(app.getUser(), f);
            }

        });
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
