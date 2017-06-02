package com.classifier.Domain;

import java.util.ArrayList;

/**
 * Created by Catarina Cardoso on 02/06/2017.
 */
public class AttentionTask {

    private String user;
    private ArrayList<App> listAplication;
    private double timeActivity;
    private double timeAplication;
    private double timeOther;
    private double percentagemAplication;
    private double percentagemOther;

    public AttentionTask() {
    }

    public AttentionTask(String user, ArrayList<App> listAplication, double timeActivity, double timeAplication, double timeOther, double percentagemAplication, double percentagemOther) {
        this.user = user;
        this.listAplication = listAplication;
        this.timeActivity = timeActivity;
        this.timeAplication = timeAplication;
        this.timeOther = timeOther;
        this.percentagemAplication = percentagemAplication;
        this.percentagemOther = percentagemOther;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ArrayList<App> getListAplication() {
        return listAplication;
    }

    public void setListAplication(ArrayList<App> listAplication) {
        this.listAplication = listAplication;
    }

    public double getTimeActivity() {
        return timeActivity;
    }

    public void setTimeActivity(double timeActivity) {
        this.timeActivity = timeActivity;
    }

    public double getTimeAplication() {
        return timeAplication;
    }

    public void setTimeAplication(double timeAplication) {
        this.timeAplication = timeAplication;
    }

    public double getTimeOther() {
        return timeOther;
    }

    public void setTimeOther(double timeOther) {
        this.timeOther = timeOther;
    }

    public double getPercentagemAplication() {
        return percentagemAplication;
    }

    public void setPercentagemAplication(double percentagemAplication) {
        this.percentagemAplication = percentagemAplication;
    }

    public double getPercentagemOther() {
        return percentagemOther;
    }

    public void setPercentagemOther(double percentagemOther) {
        this.percentagemOther = percentagemOther;
    }
}
