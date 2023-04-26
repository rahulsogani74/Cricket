package com.cricket.utils;

import com.cricket.model.TeamInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * yha pe winning team ko group me store kiya jata h
 */
public class TeamInfoConverter {

    public List<String> winningTeamNames;

    public TeamInfoConverter(List<TeamInfo> winningTeams) {
        this.winningTeamNames = new ArrayList<>();
        for (TeamInfo team : winningTeams) {
            this.winningTeamNames.add(team.getName());
        }
    }
    public List<String> getWinningTeamNames()
    {
        return winningTeamNames;
    }
}
