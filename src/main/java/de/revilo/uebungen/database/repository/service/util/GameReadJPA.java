package de.revilo.uebungen.database.repository.service.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.revilo.uebungen.database.repository.model.Game;

public class GameReadJPA {

	/**
	 * 
	 * @param emManager
	 * @return list with all game entries
	 */
	public static List<Game> findAllWithJPA(EntityManager emManager) {
		String querySelect = "SELECT games FROM Game games";
		TypedQuery<Game> games = emManager.createQuery(querySelect, Game.class);

		List<Game> resultList = games.getResultList();
		return resultList;
	}

	/**
	 * 
	 * @param emManage
	 * @param id
	 * @return
	 */
	public static Game findByIdJPA(EntityManager emManage, int id) {
		String querySelect = "SELECT games FROM Game AS games WHERE games.id = :id";

		TypedQuery<Game> games = emManage.createQuery(querySelect, Game.class);
		games.setParameter("id", id);

		Game resultList = games.getSingleResult();
		return resultList;
	}

	/**
	 * 
	 * @param emManager
	 * @param name
	 * @return
	 */
	public static List<Game> findByNameJPA(EntityManager emManager, String name) {
		String querySelect = "SELECT games FROM Game AS games WHERE games.name = :name";

		TypedQuery<Game> games = emManager.createQuery(querySelect, Game.class);
		games.setParameter("name", name);

		List<Game> resultList = games.getResultList();
		return resultList;
	}

	/**
	 * 
	 * @param emManager
	 * @param name
	 * @return
	 */
	public static List<Game> findByGenreJPA(EntityManager emManager, String name) {
		String querySelect = "SELECT games FROM Game AS games WHERE games.genre = :genre";

		TypedQuery<Game> games = emManager.createQuery(querySelect, Game.class);
		games.setParameter("genre", name);

		List<Game> resultList = games.getResultList();
		return resultList;
	}

	/**
	 * 
	 * @param emManage
	 * @param platform
	 * @return
	 */
	public static List<Game> findByPlatformJPA(EntityManager emManage, String platform) {
		String querySelect = "SELECT games FROM Game AS games WHERE games.platform = :platform ORDER BY games.name ASC";

		TypedQuery<Game> games = emManage.createQuery(querySelect, Game.class);
		games.setParameter("platform", platform);

		List<Game> resultList = games.getResultList();
		return resultList;
	}

}
