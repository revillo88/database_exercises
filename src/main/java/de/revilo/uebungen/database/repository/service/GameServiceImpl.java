package de.revilo.uebungen.database.repository.service;

import java.util.List;

import de.revilo.uebungen.database.repository.impl.GameServiceAble;
import de.revilo.uebungen.database.repository.model.Game;
import de.revilo.uebungen.database.repository.service.util.GameReadCriteria;

public class GameServiceImpl implements GameServiceAble {

	@Override
	public List<Game> findAll() {
		List<Game> gameList = GameReadCriteria.findAllWithCriteria();
		return gameList;
	}

	@Override
	public Game findById(int id) {
		Game gameList = GameReadCriteria.findByIdWithCriteria(id);
		return gameList;
	}

	@Override
	public List<Game> findByPlatform(String platform) {
		List<Game> gameList = GameReadCriteria.findByPlatformWithCriteria(platform);
		return gameList;
	}

	@Override
	public List<Game> findByName(String name) {
		List<Game> gameList = GameReadCriteria.findByNameWithCriteria(name);
		return gameList;
	}

	@Override
	public List<Game> findByGenre(String genre) {

		List<Game> gameList = GameReadCriteria.findByFenreWithCriteria(genre);
		return gameList;
	}

}
