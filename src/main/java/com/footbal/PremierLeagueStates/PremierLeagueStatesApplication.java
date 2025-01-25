package com.footbal.PremierLeagueStates;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.r2dbc.R2dbcDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.r2dbc.R2dbcRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcTransactionManagerAutoConfiguration;

import java.io.File;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication(exclude = {
		R2dbcAutoConfiguration.class,
		R2dbcDataAutoConfiguration.class,
		R2dbcRepositoriesAutoConfiguration.class,
		R2dbcTransactionManagerAutoConfiguration.class
})
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

				allTeams.forEach(team -> System.out.println(team.get("name").asText()));

//				System.out.println("count: " + node.get("count").asInt());

			} else {
				System.out.println("File does not exist.");
			}

		} catch (Exception e){
			System.out.println("An error occurred: " + e.getMessage());
		}

		SpringApplication.run(PremierLeagueStatesApplication.class, args);
	}

}
