package com.footbal.PremierLeagueStates.DBClasses;

import org.springframework.data.relational.core.mapping.Table;

@Table("coach")
public class Coach {
    public String name;
    public String dateofbirth;
    public String nationality;

    public Coach(String name, String dateOfBirth, String nationality){
        this.name = name;
        this.dateofbirth = dateOfBirth;
        this.nationality = nationality;
    }
}


