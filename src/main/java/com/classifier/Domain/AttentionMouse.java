package com.classifier.Domain;

import java.util.ArrayList;

/**
 * Created by Catarina Cardoso on 02/06/2017.
 */
public class AttentionMouse {
    private String User;
    private ArrayList<Mouse> listMouse;
    private double mediaMA;
    private double pMA;
    private double mediaMV;
    private double pMV;
    private double mediaCD;
    private double pCD;
    private double mediaDBC;
    private double pDBC;
    private double mediaDDC;
    private double pDDC;
    private double mediaDPLBC;
    private double pDPLBC;
    private double mediaTBC;
    private double pTBC;
    private double mediaTDC;
    private double pTDC;

    public AttentionMouse() {
    }

    public AttentionMouse(String user, ArrayList<Mouse> listMouse, double mediaMA, double pMA, double mediaMV, double pMV, double mediaCD, double pCD, double mediaDBC, double pDBC, double mediaDDC, double pDDC, double mediaDPLBC, double pDPLBC, double mediaTBC, double pTBC, double mediaTDC, double pTDC) {
        User = user;
        this.listMouse = listMouse;
        this.mediaMA = mediaMA;
        this.pMA = pMA;
        this.mediaMV = mediaMV;
        this.pMV = pMV;
        this.mediaCD = mediaCD;
        this.pCD = pCD;
        this.mediaDBC = mediaDBC;
        this.pDBC = pDBC;
        this.mediaDDC = mediaDDC;
        this.pDDC = pDDC;
        this.mediaDPLBC = mediaDPLBC;
        this.pDPLBC = pDPLBC;
        this.mediaTBC = mediaTBC;
        this.pTBC = pTBC;
        this.mediaTDC = mediaTDC;
        this.pTDC = pTDC;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public ArrayList<Mouse> getListMouse() {
        return listMouse;
    }

    public void setListMouse(ArrayList<Mouse> listMouse) {
        this.listMouse = listMouse;
    }

    public double getMediaMA() {
        return mediaMA;
    }

    public void setMediaMA(double mediaMA) {
        this.mediaMA = mediaMA;
    }

    public double getpMA() {
        return pMA;
    }

    public void setpMA(double pMA) {
        this.pMA = pMA;
    }

    public double getMediaMV() {
        return mediaMV;
    }

    public void setMediaMV(double mediaMV) {
        this.mediaMV = mediaMV;
    }

    public double getpMV() {
        return pMV;
    }

    public void setpMV(double pMV) {
        this.pMV = pMV;
    }

    public double getMediaCD() {
        return mediaCD;
    }

    public void setMediaCD(double mediaCD) {
        this.mediaCD = mediaCD;
    }

    public double getpCD() {
        return pCD;
    }

    public void setpCD(double pCD) {
        this.pCD = pCD;
    }

    public double getMediaDBC() {
        return mediaDBC;
    }

    public void setMediaDBC(double mediaDBC) {
        this.mediaDBC = mediaDBC;
    }

    public double getpDBC() {
        return pDBC;
    }

    public void setpDBC(double pDBC) {
        this.pDBC = pDBC;
    }

    public double getMediaDDC() {
        return mediaDDC;
    }

    public void setMediaDDC(double mediaDDC) {
        this.mediaDDC = mediaDDC;
    }

    public double getpDDC() {
        return pDDC;
    }

    public void setpDDC(double pDDC) {
        this.pDDC = pDDC;
    }

    public double getMediaDPLBC() {
        return mediaDPLBC;
    }

    public void setMediaDPLBC(double mediaDPLBC) {
        this.mediaDPLBC = mediaDPLBC;
    }

    public double getpDPLBC() {
        return pDPLBC;
    }

    public void setpDPLBC(double pDPLBC) {
        this.pDPLBC = pDPLBC;
    }

    public double getMediaTBC() {
        return mediaTBC;
    }

    public void setMediaTBC(double mediaTBC) {
        this.mediaTBC = mediaTBC;
    }

    public double getpTBC() {
        return pTBC;
    }

    public void setpTBC(double pTBC) {
        this.pTBC = pTBC;
    }

    public double getMediaTDC() {
        return mediaTDC;
    }

    public void setMediaTDC(double mediaTDC) {
        this.mediaTDC = mediaTDC;
    }

    public double getpTDC() {
        return pTDC;
    }

    public void setpTDC(double pTDC) {
        this.pTDC = pTDC;
    }

    @Override
    public String toString() {
        return "AttentionMouse{" +
                "User='" + User + '\'' +
                ", listMouse=" + listMouse +
                ", mediaMA=" + mediaMA +
                ", pMA=" + pMA +
                ", mediaMV=" + mediaMV +
                ", pMV=" + pMV +
                ", mediaCD=" + mediaCD +
                ", pCD=" + pCD +
                ", mediaDBC=" + mediaDBC +
                ", pDBC=" + pDBC +
                ", mediaDDC=" + mediaDDC +
                ", pDDC=" + pDDC +
                ", mediaDPLBC=" + mediaDPLBC +
                ", pDPLBC=" + pDPLBC +
                ", mediaTBC=" + mediaTBC +
                ", pTBC=" + pTBC +
                ", mediaTDC=" + mediaTDC +
                ", pTDC=" + pTDC +
                '}';
    }
}

