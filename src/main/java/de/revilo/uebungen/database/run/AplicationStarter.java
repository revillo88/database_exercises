package de.revilo.uebungen.database.run;

import java.util.List;

import de.revilo.uebungen.database.repository.impl.GameServiceAble;
import de.revilo.uebungen.database.repository.model.Game;
import de.revilo.uebungen.database.repository.service.GameServiceImpl;

public class AplicationStarter {

	public static void main(String[] args) {
		System.out.println("startet");

		new AplicationStarter().databaseConfig();
	}

	public void databaseConfig() {
		System.out.println("beginn der db auslessung");

		GameServiceAble gameService = new GameServiceImpl();

		// List<Game> gameList = gameService.findByPlatform(emanager, "Nintendo");
		// genre
		// List<Game> gameList = gameService.findAll();

		// Game game = gameService.findById(1);
		// List<Game> gameListByPlatform = gameService.findByPlatform("Nintendo");
		// List<Game> gameListByName = gameService.findByName("Jumpi");
		List<Game> gameListByGenre = gameService.findByGenre("Wirtschaftssimulation");
		// emanager.close();

	}

}
