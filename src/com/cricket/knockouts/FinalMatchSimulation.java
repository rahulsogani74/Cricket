package com.cricket.knockouts;

import com.cricket.Interface.FinalMatchSimulationInterface;
import com.cricket.model.TeamInfo;
import com.cricket.utils.AdditionalUtils;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * yha pr match ko kraya gya h...
 * teams ko random trh se batting di jaati h or unke score ko likha jata h.
 */
public class FinalMatchSimulation implements FinalMatchSimulationInterface {
    public TeamInfo playMatch(List<String> array) {
    return getWinTeam(storeRunForFinalMatch(array),array);
    }

    private int[] storeRunForFinalMatch(List<String> array) {
        Scanner in = new Scanner(System.in);
        int runs[] = new int[2];
        String names[] = getTeamNames(array);
        int randomNum = getRandom();
        for (int i = 0; i < array.size(); i++) {
            System.out.println("Team " + (randomNum + 1) + " Name: " + names[randomNum]);
            System.out.println("Enter Team " + (randomNum + 1) + " Score: ");
            runs[randomNum] = in.nextInt();
            in.nextLine();
            if (randomNum == 0) {
                randomNum = 1;
            } else {
                randomNum = 0;
            }
        }
        return runs;
    }

    private TeamInfo getWinTeam(int[] runs, List<String> array) {
        int highScore = 0;
        for (int i = 1; i < array.size(); i++) {
            if (runs[i] > runs[highScore]) {
                highScore = i;
            }
        }
        System.out.println("Winning Team : " + array.get(highScore) + " , Team Run : " + runs[highScore]);
        return new TeamInfo(array.get(highScore), runs[highScore]);
    }

    /**
     * yha pr team ko split kiya jata h...
     * split krne ke baad unhe upper code me dala gya h...
     *taaki team ka name apne aap aa jaae.
     * @param match
     * @return
     */
    public String[] getTeamNames(List<String> match) {
        String[] array = new String[2];
        String first = match.get(0);
        String[] arrOfStr = first.split("v/s");
        array[0] = arrOfStr[0].trim();
        array[1] = arrOfStr[1].trim();
        return array;
    }

    /**
     * yh ek random krne ka code h...
     * isme team ko upper ke code me random trh se batting krne ke liy likha gya h.
     * @return
     */
    private int getRandom() {
        Random rand = new Random();
        final int randomNumber = rand.nextInt(1000);
        return randomNumber % 2;
    }
}
