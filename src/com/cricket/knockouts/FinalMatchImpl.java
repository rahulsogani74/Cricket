package com.cricket.knockouts;

import com.cricket.Interface.FinalMatchInterface;
import com.cricket.model.TeamInfo;

import java.util.List;

public class FinalMatchImpl implements FinalMatchInterface {


    /**
     * Store values in files
     * @param topGroupWinner
     * @return
     */
    @Override
    public TeamInfo play(List<String> topGroupWinner) {
        FinalMatchInterface finalMatch = new FinalMatch();
        TeamInfo team = finalMatch.play(topGroupWinner);
        return team;
    }
}
