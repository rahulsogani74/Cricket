package com.cricket;

import com.cricket.knockouts.FinalMatch;
import com.cricket.league.LeagueMatchSimulation;
import com.cricket.model.TeamInfo;
import com.cricket.tournament.*;
import com.cricket.utils.TeamInfoConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * YH main method or main class h
 * yha pr bhi class Ko add kiya gya h
 * or unko use kiya gya h.
 */
public class Starter {

    public static void main(String[] args) {
        CountGroupWinner countGroupWinner = new CountGroupWinner();
        GroupMatchWinner groupMatchWinner = new GroupMatchWinner();
        final LeagueMatchSimulation matchPair = new LeagueMatchSimulation();

        List<List<TeamInfo>> winningTeamsByGroup = matchPair.leagueMatch();
        List<TeamInfo> groupWinner = countGroupWinner.getGroupWinners(winningTeamsByGroup);

        for (int i = 0; i < groupWinner.size(); i++) {
            System.out.println("Group " + (i + 1) + " winner : " + groupWinner.get(i));
        }

        List<TeamInfoConverter> groupWinners = new ArrayList<>();
        for (int i = 0; i < winningTeamsByGroup.size(); i++) {
            List<TeamInfo> groupWinningTeams = winningTeamsByGroup.get(i);
            TeamInfoConverter groupWinne = new TeamInfoConverter(groupWinningTeams);
            groupWinners.add(groupWinne);
        }

        for (int i = 0; i < groupWinners.size(); i++) {
            System.out.println("Group " + (i + 1) + " winner : " + groupWinners.get(i).getWinningTeamNames());
        }

        List<String> topGroupWinner = groupMatchWinner.getTopGroupWinner(winningTeamsByGroup);
        System.out.println("Top group winners: " + topGroupWinner);

        FinalMatch finalMatch = new FinalMatch();
        List<String> groupWinnerr = new ArrayList<>();
        for (int i = 0; i < groupWinner.size(); i++) {
            groupWinnerr.add(groupWinner.get(i).getName());
        }

        TeamInfo winningTeam = finalMatch.play(groupWinnerr);
        System.out.println("Winning Team: " + winningTeam.getName());
    }
}
