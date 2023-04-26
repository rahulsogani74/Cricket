package com.cricket.model;

/**
 * yha pr team ka name or runs ko store krne ke liy...
 * or unke gatter satter mathod bnaae gye h...
 * taaki inko use kr ske kisi dusri class me direct hi.
 */
public class TeamInfo {
    private String name;
    private int runs;

    public TeamInfo(String name, int runs) {
        this.name = name;
        this.runs = runs;
    }

    public String getName() {
        return name;
    }

    public int getRuns() {
        return runs;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", runs=" + runs +
                '}';
    }
}
