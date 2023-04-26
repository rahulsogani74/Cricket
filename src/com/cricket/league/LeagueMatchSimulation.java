package com.cricket.league;

import com.cricket.model.TeamInfo;
import com.cricket.knockouts.FinalMatchSimulation;
import com.cricket.utils.AdditionalUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * yha se match ka start likha gya h...
 * or kuch class ko add bhi kiya gya h or unka use kiya gya h.
 * 1. Team Register
 * 2. Divide in group and provide match list
 * 3. provide match score for given matches should be in order
 * 4. Get Top teams in each group
 * 5. Get finalist
 * 6. step #3
 * 7. given #team how many matches won, score
 */
public class LeagueMatchSimulation {

    public List<List<TeamInfo>> leagueMatch() {
        List<List<TeamInfo>> winningTeamsByGroup = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the number of Teams you want to enter: ");
        String[] string = new String[sc.nextInt()];
        sc.nextLine();
        for (int i = 0; i < string.length; i++) {
            string[i] = sc.nextLine();
        }
        System.out.println("\nYou have entered: ");
        List<String> teams = new ArrayList<>();
        for (String str : string) {
            teams.add(str);
        }
        System.out.println("Total Teams : " + teams);
        List[] splittedIntoGroup = AdditionalUtils.splitInTwoParts(teams);
        for (int i = 0; i < splittedIntoGroup.length; i++) {   // group me team ko split krna
            List<String> Group = splittedIntoGroup[i];
            System.out.println("Group " + (i + 1) + " : " + Group);
            TeamMatchFormation matchList = new TeamMatchFormation();   // league match ka use kiya gya h
            List<String> matches = matchList.createMatches(Group);
            System.out.println("Group " + (i + 1) + " Match List : " + matches);
            List<TeamInfo> winningTeams = new ArrayList<>();
            for (int j = 0; j < matches.size(); j++) {       // yha pr winning team ke baare me btaya gya h
                List<String> match = Collections.singletonList(matches.get(j));
                System.out.println("Match Number " + (j + 1) + " : " + match);
                FinalMatchSimulation matchSc = new FinalMatchSimulation();
                TeamInfo team = matchSc.playMatch(match);    // match score class ka use kiya gya h...
                winningTeams.add(team);
            }
            winningTeamsByGroup.add(winningTeams);             // yha pr group ke win team ko alg se rkha gya h
            System.out.println(winningTeamsByGroup.get(i));
        }
        return winningTeamsByGroup;
    }
}




