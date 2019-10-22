package de.revilo.uebungen.database.run;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.revilo.uebungen.database.repository.impl.GameServiceAble;
import de.revilo.uebungen.database.repository.model.Game;
import de.revilo.uebungen.database.repository.service.GameServiceImpl;

public class AplicationStarter {

	private static final String PERSTISTENCE_UNIT = "database";

	public static void main(String[] args) {
		System.out.println("startet");

		new AplicationStarter().databaseConfig();
	}

	public void databaseConfig() {
		System.out.println("beginn der db auslessung");

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PERSTISTENCE_UNIT);
		EntityManager emanager = emfactory.createEntityManager();
		emanager.getTransaction().begin();
		GameServiceAble gameService = new GameServiceImpl();

		List<Game> gameList = gameService.findByPlatform(emanager, "Nintendo");
		//Game gameList = gameService.findById(emanager, 2);
		
		
		//System.out.println("ausgabe was drin steht:" +gameList.toString());
		
		gameList.forEach(game -> {
			System.out.println("ausgabe -> " + game.toString());
		});

		emanager.close();

	}
	
	

}
