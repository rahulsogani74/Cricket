package com.cricket.league;

import com.cricket.Interface.LeagueMatchInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * yha group ke league match krane ke liy matches bnaee gye h.
 */
public class TeamMatchFormation implements LeagueMatchInterface {

    public List<String> createMatches(List<String> firstGroup) {
        List<String> pair = new ArrayList<>();
        int j = firstGroup.size() - 1;
        for (int i = 0; i < j; i++) {
            for (int k = i + 1; k <= j; k++) {
                pair.add(firstGroup.get(i) + " v/s " + firstGroup.get(k));
            }
        }
        return pair;
    }
}
