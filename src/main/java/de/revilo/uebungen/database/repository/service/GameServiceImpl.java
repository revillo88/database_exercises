package de.revilo.uebungen.database.repository.service;

import java.util.List;

import javax.persistence.EntityManager;

import de.revilo.uebungen.database.repository.impl.GameServiceAble;
import de.revilo.uebungen.database.repository.model.Game;
import de.revilo.uebungen.database.repository.service.util.GameReadCriteria;
import de.revilo.uebungen.database.repository.service.util.GameReadJPA;

public class GameServiceImpl implements GameServiceAble {

	@Override
	public List<Game> findAll(EntityManager emManager) {
		List<Game> gameList = GameReadCriteria.findAllWithCriteria(emManager);
		return gameList;
	}

	@Override
	public List<Game> findByGenre(EntityManager emManage, String genre) {
		List<Game> gameList = GameReadJPA.findByGenreJPA(emManage, genre);
		return gameList;
	}

	@Override
	public Game findById(EntityManager emManage, int id) {
		Game gameList = GameReadJPA.findByIdJPA(emManage, id);
		return gameList;
	}

	@Override
	public List<Game> findByPlatform(EntityManager emManage, String platform) {
		List<Game> gameList = GameReadJPA.findByPlatformJPA(emManage, platform);
		return gameList;
	}

	@Override
	public List<Game> findByName(EntityManager emManage, String name) {
		List<Game> gameList = GameReadJPA.findByNameJPA(emManage, name);
		return gameList;
	}

}
