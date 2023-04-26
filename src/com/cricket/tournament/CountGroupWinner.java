package com.cricket.tournament;

import com.cricket.model.TeamInfo;
import com.cricket.model.TeamAdditionalInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    /**
       yha group ke win hui team ko coumt kiya jata h
       ki konsi team kitna match jeeti h
    */
public class CountGroupWinner {

    public List<TeamInfo> getGroupWinners(List<List<TeamInfo>> winningTeamsByGroup) {
        final List<TeamInfo> groupWinners = new ArrayList<>();

        for (List<TeamInfo> group : winningTeamsByGroup) {
            final Map<TeamInfo, TeamAdditionalInfo> teamWinCounts = getTeamWinCounts(group);
            final List<TeamAdditionalInfo> groupWinner = getGroupWinner(teamWinCounts);
            final TeamInfo winningTeamInaGroup = getOneTeamFromEachGroup(groupWinner, group);
            groupWinners.add(winningTeamInaGroup);
        }
        return groupWinners;
    }

        //now, in some cases there can be possibility that multiple teams can
        // have same amount of wins
        private TeamInfo getOneTeamFromEachGroup(final List<TeamAdditionalInfo> groupWinner,
                                                 final List<TeamInfo> group) {
            int maxScore = 0;
            TeamInfo winningTeam = null;
            if (groupWinner.size() > 1) {
                for (TeamAdditionalInfo teamWinAndScore : groupWinner) {
                    int totalScore = 0;
                    for (TeamInfo team : group) {
                        if (team.getName().equals(teamWinAndScore.getName())) {
                            totalScore += teamWinAndScore.getScore();
                        } else {
                            totalScore += team.getRuns();
                        }
                    }
                    if (totalScore > maxScore) {
                        maxScore = totalScore;
                        winningTeam = new TeamInfo(teamWinAndScore.getName(), totalScore);
                    }
                }
            } else {
                winningTeam = new TeamInfo(groupWinner.get(0).getName(), groupWinner.get(0).getScore());
            }
            return winningTeam;
        }

        private List<TeamAdditionalInfo> getGroupWinner(Map<TeamInfo, TeamAdditionalInfo> teamWinCounts) {
            List<TeamAdditionalInfo> groupWinner = new ArrayList<>();
            int maxWins = 0;
            for (Map.Entry<TeamInfo, TeamAdditionalInfo> entry : teamWinCounts.entrySet()) {
                TeamAdditionalInfo teamWinAndScores = entry.getValue();
                int wins = teamWinAndScores.getWin();
                if (wins > maxWins) {                       // yha pr count kiya gya h team name se or score se
                    maxWins = wins;
                    groupWinner.clear();
                    groupWinner.add(teamWinAndScores);
                } else if (wins == maxWins) {
                    groupWinner.add(teamWinAndScores);
                }
            }
            return groupWinner;
        }

        /**
         * //key is team and value is how many team that team has won
         * @param group
         * @return
         */
        private Map<TeamInfo, TeamAdditionalInfo> getTeamWinCounts(List<TeamInfo> group) {
            Map<TeamInfo, TeamAdditionalInfo> teamWinCounts = new HashMap<>();
            for (TeamInfo team : group) {
                if (teamWinCounts.containsKey(team)) {          // team win ko count kiya gya h
                    TeamAdditionalInfo teamWinAndScores = teamWinCounts.get(team);
                    int previousWin = teamWinAndScores.getWin();
                    int previousScore = teamWinAndScores.getScore();

                    teamWinAndScores.setWin(previousWin + 1);
                    teamWinAndScores.setScore(previousScore + team.getRuns());
                    teamWinCounts.put(team, teamWinAndScores);
                } else {
                    TeamAdditionalInfo teamWinAndScores = new TeamAdditionalInfo();
                    teamWinAndScores.setWin(1);
                    teamWinAndScores.setScore(team.getRuns());
                    teamWinAndScores.setName(team.getName());
                    teamWinCounts.put(team, teamWinAndScores);
                }
            }
            return teamWinCounts;
        }
    }
