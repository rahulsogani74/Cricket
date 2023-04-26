package com.cricket.tournament;

import com.cricket.model.TeamInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 yha dono group ke win hui team ko map me dala gya h ...
 or unko team ke match jitne ya group tie hone pr
 unke bnaaege gye ran's se win btaya jata h
 or dono group me jo jita h unke bich
 match krane ke liy list me dala gya h.
 */
public class GroupMatchWinner {

        public List<String> getTopGroupWinner(List<List<TeamInfo>> winningTeamsByGroup) {
            List<String> topWinningTeams = new ArrayList<>();

            int maxWinCount = 0;
            final Map<String, Integer> winCountMap = new HashMap<>();

            for (List<TeamInfo> winningTeams : winningTeamsByGroup) {
                for (TeamInfo team : winningTeams) {
                    String teamName = team.getName();
                    int winCount = winCountMap.getOrDefault(teamName, 0) + 1;
                    winCountMap.put(teamName, winCount);

                    if (winCount > maxWinCount) {
                        maxWinCount = winCount;
                        topWinningTeams.clear();
                    }

                    if (winCount == maxWinCount) {
                        topWinningTeams.add(teamName);
                    }
                }
            }
            return topWinningTeams;
        }
}
