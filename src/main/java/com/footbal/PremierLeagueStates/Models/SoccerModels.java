package com.footbal.PremierLeagueStates.Models;

import java.util.ArrayList;

public class SoccerModels {

    public record Coaches(
            String firstName,
            String dob,
            String nationality,
            String contractStart,
            String contractEnd
    ){}

    public record Player(
            String name,
            String position,
            String dateOfBirth,
            String nationality
    ){}

    public record Team(
            String name,
            String venue,
            String clubColors,
            String lastUpdated,
            Coaches coach,
            ArrayList<Player> players
    ){}

}



