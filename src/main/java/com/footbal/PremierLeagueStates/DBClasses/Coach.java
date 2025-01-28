package com.footbal.PremierLeagueStates.DBClasses;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("coach")
public class Coach {
    public String name;
    public String dateOfBirth;
    public String nationality;
}


