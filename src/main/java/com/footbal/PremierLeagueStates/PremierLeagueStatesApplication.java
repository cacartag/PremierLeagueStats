package com.footbal.PremierLeagueStates;

import com.fasterxml.jackson.databind.JsonNode;
import com.footbal.PremierLeagueStates.DBClasses.CoachRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.r2dbc.R2dbcDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.r2dbc.R2dbcRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcTransactionManagerAutoConfiguration;

import java.io.File;
import java.util.Scanner;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@SpringBootApplication(exclude = {
//		R2dbcAutoConfiguration.class,
//		R2dbcDataAutoConfiguration.class,
//		R2dbcRepositoriesAutoConfiguration.class,
//		R2dbcTransactionManagerAutoConfiguration.class
//})
@SpringBootApplication
public class PremierLeagueStatesApplication {


	public static void main(String[] args) {

		try{
			File file = new File("/Users/christophercartagena/Documents/englandOnly.json");
			Scanner myReader = new Scanner(file);

			StringBuilder jsonString = new StringBuilder();
			if(file.exists()){

				System.out.println("File exists!");

				while(myReader.hasNextLine()){
					jsonString.append(myReader.nextLine());
				}

				ObjectMapper mapper = new ObjectMapper();

				JsonNode node = mapper.readTree(jsonString.toString());

				JsonNode allTeams = node.get("teams");

				allTeams.forEach(team -> {
					System.out.println(team.get("name").asText());
					System.out.println(team.get("venue").asText());

					JsonNode coach = team.get("coach");
					System.out.println("Coach: name: " + coach.get("name") +
							", dateOfBirth: " + coach.get("dateOfBirth") +
							", nationality: " + coach.get("nationality"));

					JsonNode squad = team.get("squad");
					squad.forEach(player ->
							System.out.println("Player: name: " + player.get("name") +
									", position: " + player.get("position") +
									", dateOfBirth: " + player.get("dateOfBirth") +
									", nationality: " + player.get("nationality")));
				});

			} else {
				System.out.println("File does not exist.");
			}

		} catch (Exception e){
			System.out.println("An error occurred: " + e.getMessage());
		}

		SpringApplication.run(PremierLeagueStatesApplication.class, args);
	}

	private static final Logger log =
			LoggerFactory.getLogger(PremierLeagueStatesApplication.class);

	@Bean
	public CommandLineRunner demo(CoachRepository repository){
		return args -> {

			repository.findAll().doOnNext( coach -> {
				System.out.println("Coach Name " + coach.name);
			});

			log.info("");
		};
	}

}
