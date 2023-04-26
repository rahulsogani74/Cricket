package com.cricket.knockouts;

import com.cricket.Interface.FinalMatchInterface;
import com.cricket.model.TeamInfo;
import com.cricket.utils.AdditionalUtils;

import java.util.List;
import java.util.Scanner;

/**
 yha final match ka code likha h...
 isme final match khilaya gya h or btaya gya h ki
 tournament me konsi team winner rhi h.
 */
public class FinalMatch implements FinalMatchInterface {
    public TeamInfo play(List<String> names) {
        return getWinTeam(storeRunForEachTeam(names), names);
    }

    private int[] storeRunForEachTeam(List<String> names) {
        Scanner in = new Scanner(System.in);
        int runs[] = new int[names.size()];
        int randomNum = AdditionalUtils.getRandom();    //yha random team ko match khilata h...
        for (int i = 0; i < names.size(); i++) {
            System.out.println(" Team " + (randomNum + 1) + " Name: " + names.get(randomNum));
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

    private TeamInfo getWinTeam(int[] runs, List<String> names) {
        int highScore = 0;    //yha highScore ke hissab se team ko win kiya jata h
        for (int i = 1; i < 2; i++) {
            if (runs[i] > runs[highScore]) {
                highScore = i;
            }
        }
        if (runs[0] == runs[1]) {
            System.out.println("Match Draw");
        } else {
            System.out.println("Wining Team : " + names.get(highScore) + " , Team Run : " + runs[highScore]);
            System.out.println(names.get(highScore) + " Win the Match");
        }
        return new TeamInfo(names.get(highScore), runs[highScore]);
    }
}
