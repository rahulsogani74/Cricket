package com.cricket.model;

/**
 * yha pr team kitni baar win hui unke number or...
 * score or team ke name ko store krke rkha gya h...
 * or inke gaater v satter method bnaae gye h taaki inko khi pr bhi use kiya jaa ske.
 */
public class TeamAdditionalInfo {

    private int win;
    private int score;
    private String name;

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
