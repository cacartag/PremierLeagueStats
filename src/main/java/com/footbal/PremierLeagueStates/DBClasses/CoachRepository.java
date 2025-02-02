package com.footbal.PremierLeagueStates.DBClasses;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CoachRepository extends ReactiveCrudRepository<Coach, Long> {

//    @Query("SELECT * FROM coach")
//    Flux<Coach> findAll();

//    @Query("Select * from coach")
//    Flux<Coach> testing();

}
