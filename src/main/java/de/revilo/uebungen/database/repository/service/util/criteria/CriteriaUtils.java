package de.revilo.uebungen.database.repository.service.util.criteria;

import java.util.List;

import de.revilo.uebungen.database.repository.model.Game;

public class CriteriaUtils {
	public static void gameOutput(List<Game> resultList) {
		resultList.forEach(game -> {

			if (game.getGenreBean().getGames().size() > 0) {
				System.out.println("Id : " + game.getId());
				System.out.println("Name : " + game.getName());
				System.out.println("Platform : " + game.getPlatform());
				System.out.println("Genre : " + game.getGenreBean().getArt());
				
//				game.getGenreBean().getGames().forEach(genre -> {
//					System.out.println("Genre : " + genre.getGenreBean().s);
//					System.out.println("Genre : " + genre.getGenreBean().getArt());
//				});

			}
		});
	}
}
