package de.revilo.uebungen.database.repository.service.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import de.revilo.uebungen.database.repository.model.Game;
import de.revilo.uebungen.database.repository.model.Genre;
import de.revilo.uebungen.database.repository.service.util.criteria.CriteriaUtils;

public class GameReadCriteria {
	private static final String PERSTISTENCE_UNIT = "database";

	private static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(PERSTISTENCE_UNIT);
	private static EntityManager emanager = emfactory.createEntityManager();

	public static List<Game> findAllWithCriteria() {
		List<Game> resultList = null;

		CriteriaBuilder criteriaBuilder = emanager.getCriteriaBuilder();

		CriteriaQuery<Game> criteriaQuery = criteriaBuilder.createQuery(Game.class);

		Root<Game> rootGame = criteriaQuery.from(Game.class);
		// sortiert nach id aufsteigend mit asc
		criteriaQuery.orderBy(criteriaBuilder.asc(rootGame.get("id")));
		// sortiert nach id absteigend mit desc
		criteriaQuery.orderBy(criteriaBuilder.desc(rootGame.get("id")));
		CriteriaQuery<Game> selectQuery = criteriaQuery.select(rootGame);

		TypedQuery<Game> games = emanager.createQuery(selectQuery);
		resultList = games.getResultList();

		CriteriaUtils.gameOutput(resultList);

		return resultList;
	}

	public static Game findByIdWithCriteria(int id) {
		List<Game> resultList = null;

		CriteriaBuilder criteriaBuilder = emanager.getCriteriaBuilder();

		CriteriaQuery<Game> criteriaQuery = criteriaBuilder.createQuery(Game.class);

		Root<Game> rootGame = criteriaQuery.from(Game.class);

		criteriaQuery.where(criteriaBuilder.equal(rootGame.get("id"), id));

		// sortiert nach id aufsteigend mit asc
		// criteriaQuery.orderBy(criteriaBuilder.asc(rootGame.get("id")));
		// sortiert nach id absteigend mit desc
		/// criteriaQuery.orderBy(criteriaBuilder.desc(rootGame.get("id")));
		CriteriaQuery<Game> selectQuery = criteriaQuery.select(rootGame);

		TypedQuery<Game> games = emanager.createQuery(selectQuery);
		resultList = games.getResultList();

		CriteriaUtils.gameOutput(resultList);

		return null;

	}

	public static List<Game> findByPlatformWithCriteria(String platform) {
		List<Game> resultList = null;

		CriteriaBuilder criteriaBuilder = emanager.getCriteriaBuilder();

		CriteriaQuery<Game> criteriaQuery = criteriaBuilder.createQuery(Game.class);

		Root<Game> rootGame = criteriaQuery.from(Game.class);

		criteriaQuery.where(criteriaBuilder.equal(rootGame.get("platform"), platform));

		// sortiert nach id aufsteigend mit asc
		// criteriaQuery.orderBy(criteriaBuilder.asc(rootGame.get("id")));
		// sortiert nach id absteigend mit desc beispiel mit mehreren
		criteriaQuery.orderBy(criteriaBuilder.desc(rootGame.get("id")), criteriaBuilder.asc(rootGame.get("name")));
		CriteriaQuery<Game> selectQuery = criteriaQuery.select(rootGame);

		TypedQuery<Game> games = emanager.createQuery(selectQuery);
		resultList = games.getResultList();

		CriteriaUtils.gameOutput(resultList);

		return resultList;
	}

	public static List<Game> findByNameWithCriteria(String name) {
		List<Game> resultList = null;

		CriteriaBuilder criteriaBuilder = emanager.getCriteriaBuilder();

		CriteriaQuery<Game> criteriaQuery = criteriaBuilder.createQuery(Game.class);

		Root<Game> rootGame = criteriaQuery.from(Game.class);

		criteriaQuery.where(criteriaBuilder.equal(rootGame.get("name"), name));

		// sortiert nach id aufsteigend mit asc
		// criteriaQuery.orderBy(criteriaBuilder.asc(rootGame.get("id")));
		// sortiert nach id absteigend mit desc beispiel mit mehreren
		// criteriaQuery.orderBy(criteriaBuilder.desc(rootGame.get("id")),
		// criteriaBuilder.asc(rootGame.get("name")));
		CriteriaQuery<Game> selectQuery = criteriaQuery.select(rootGame);

		TypedQuery<Game> games = emanager.createQuery(selectQuery);
		resultList = games.getResultList();

		CriteriaUtils.gameOutput(resultList);

		return resultList;
	}

	public static List<Game> findByFenreWithCriteria(String genre) {
		List<Game> resultList = null;

		CriteriaBuilder criteriaBuilder = emanager.getCriteriaBuilder();

		CriteriaQuery<Game> criteriaQuery = criteriaBuilder.createQuery(Game.class);

		Root<Game> rootGame = criteriaQuery.from(Game.class);
		// Fetch address = rootGame.fetch("genreBean");
		Join<Game, Genre> gameToGenreJoin = rootGame.join("genreBean");
		criteriaQuery.where(criteriaBuilder.equal(gameToGenreJoin.get("art"), genre));

		// sortiert nach id aufsteigend mit asc
		criteriaQuery.orderBy(criteriaBuilder.asc(rootGame.get("id")));
		// sortiert nach id absteigend mit desc beispiel mit mehreren
		// criteriaQuery.orderBy(criteriaBuilder.desc(rootGame.get("id")),
		// criteriaBuilder.asc(rootGame.get("name")));
		CriteriaQuery<Game> selectQuery = criteriaQuery.select(rootGame);

		TypedQuery<Game> games = emanager.createQuery(selectQuery);
		resultList = games.getResultList();

		CriteriaUtils.gameOutput(resultList);

		return resultList;
	}

}
