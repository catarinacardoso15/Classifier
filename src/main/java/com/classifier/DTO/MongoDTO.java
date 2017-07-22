package com.classifier.DTO;

import Controller.DataBaseController;
import Model.Connection;
import Model.TaskRecords;
import Model.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Catarina Cardoso on 26/06/2017.
 */
public class MongoDTO {
    private DataBaseController dbcont;
    private Connection conn;

    public MongoDTO() {
        initiateConnection();
    }

    private void initiateConnection() {
        this.conn = new Connection("davide", "test1234", "islab.di.uminho.pt", "27017", "test", "test");
        this.dbcont = new DataBaseController(conn.getDataBase());
    }

    private void closeConnection() {
        this.conn.getMongoClient().close();
    }

    public User getMouseUser(Date i, Date f, String user) {
        return this.dbcont.searchMouseByUserName(i, f, user);
    }

    public User getKeyboardUser(Date i, Date f, String user) {
        return this.dbcont.searchKeyboardByUserName(i, f, user);
    }

    public User getMouseKeyboardUser(Date i, Date f, String user) {
        return this.dbcont.searchKeyboardMouseByUserName(i, f, user);
    }

    public User getTaskUser(Date i, Date f, String user) {
        return this.dbcont.searchTasksByUserName(i, f, user);
    }

    public ArrayList<TaskRecords> getTaskDate(Date i, Date f){
        return dbcont.searchTasksByDate(i,f);
    }
}
