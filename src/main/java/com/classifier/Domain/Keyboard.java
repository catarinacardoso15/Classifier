package com.classifier.Domain;

/**
 * Created by Trabalho on 27/05/2017.
 */
public class Keyboard {
    private long timestamp;
    private double ktd;
    private double tbk;

    public Keyboard() {
    }

    public Keyboard(long timestamp, double ktd, double tbk) {
        this.timestamp = timestamp;
        this.ktd = ktd;
        this.tbk = tbk;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getKtd() {
        return ktd;
    }

    public double getTbk() {
        return tbk;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setKtd(double ktd) {
        this.ktd = ktd;
    }

    public void setTbk(double tbk) {
        this.tbk = tbk;
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "timestamp=" + timestamp +
                ", ktd=" + ktd +
                ", tbk=" + tbk +
                '}';
    }
}
