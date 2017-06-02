package com.classifier.Domain;

import java.util.ArrayList;

/**
 * Created by Catarina Cardoso on 02/06/2017.
 */

public class AttentionKeyboard {
    private String User;
    private ArrayList<Keyboard> listKeyboard;
    private double mediaKDT;
    private double pKDT;
    private double mediaTBK;
    private double pTBK;

    public AttentionKeyboard() {
    }

    public AttentionKeyboard(String user, ArrayList<Keyboard> listKeyboard, double mediaKDT, double pKDT, double mediaTBK, double pTBK) {
        User = user;
        this.listKeyboard = listKeyboard;
        this.mediaKDT = mediaKDT;
        this.pKDT = pKDT;
        this.mediaTBK = mediaTBK;
        this.pTBK = pTBK;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public ArrayList<Keyboard> getListKeyboard() {
        return listKeyboard;
    }

    public void setListKeyboard(ArrayList<Keyboard> listKeyboard) {
        this.listKeyboard = listKeyboard;
    }

    public double getMediaKDT() {
        return mediaKDT;
    }

    public void setMediaKDT(double mediaKDT) {
        this.mediaKDT = mediaKDT;
    }

    public double getpKDT() {
        return pKDT;
    }

    public void setpKDT(double pKDT) {
        this.pKDT = pKDT;
    }

    public double getMediaTBK() {
        return mediaTBK;
    }

    public void setMediaTBK(double mediaTBK) {
        this.mediaTBK = mediaTBK;
    }

    public double getpTBK() {
        return pTBK;
    }

    public void setpTBK(double pTBK) {
        this.pTBK = pTBK;
    }

    @Override
    public String toString() {
        return "AttentionKeyboard{" +
                "User='" + User + '\'' +
                ", listKeyboard=" + listKeyboard +
                ", mediaKDT=" + mediaKDT +
                ", pKDT=" + pKDT +
                ", mediaTBK=" + mediaTBK +
                ", pTBK=" + pTBK +
                '}';
    }
}
