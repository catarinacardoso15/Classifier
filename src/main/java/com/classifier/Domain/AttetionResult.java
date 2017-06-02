package com.classifier.Domain;

import java.util.Date;

/**
 * Created by Catarina Cardoso on 02/06/2017.
 */
public class AttetionResult {

    private AttentionTask ResultTask;
    private AttentionMouse ResultMouse;
    private AttentionKeyboard ResultKeyboard;
    private String user;
    private Date initialDate;
    private Date currentDate;

    public AttetionResult() {
    }

    public AttetionResult(AttentionTask resultTask, AttentionMouse resultMouse, AttentionKeyboard resultKeyboard, String user, Date initialDate, Date currentDate) {
        ResultTask = resultTask;
        ResultMouse = resultMouse;
        ResultKeyboard = resultKeyboard;
        this.user = user;
        this.initialDate = initialDate;
        this.currentDate = currentDate;
    }

    public AttentionTask getResultTask() {
        return ResultTask;
    }

    public void setResultTask(AttentionTask ResultTask) {
        this.ResultTask = ResultTask;
    }

    public AttentionMouse getResultMouse() {
        return ResultMouse;
    }

    public void setResultMouse(AttentionMouse ResultMouse) {
        this.ResultMouse = ResultMouse;
    }

    public AttentionKeyboard getResultKeyboard() {
        return ResultKeyboard;
    }

    public void setResultKeyboard(AttentionKeyboard ResultKeyboard) {
        this.ResultKeyboard = ResultKeyboard;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AttetionResult{" +
                "ResultTask=" + ResultTask +
                ", ResultMouse=" + ResultMouse +
                ", ResultKeyboard=" + ResultKeyboard +
                ", user='" + user + '\'' +
                ", initialDate=" + initialDate +
                ", currentDate=" + currentDate +
                '}';
    }
}
