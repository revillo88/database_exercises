package de.revilo.uebungen.database.repository.service.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.revilo.uebungen.database.repository.model.Game;

public class GameReadCriteria {
	/**
	 * 
	 * @param emManager
	 * @return
	 */
	public static List<Game> findAllWithCriteria(EntityManager emManager) {
		List<Game> resultList = null;

		if (emManager.isOpen() == true) {

			try {

				// generate a new Criteria Builder
				CriteriaBuilder criteriaBuilder = emManager.getCriteriaBuilder();

				System.out.println("generate null -");
				CriteriaQuery<Game> criteriaQuery = criteriaBuilder.createQuery(Game.class);
				System.out.println("generate null 0");

				Root<Game> rootGame = criteriaQuery.from(Game.class);
				System.out.println("generate null 1");

				CriteriaQuery<Game> selectQuery = criteriaQuery.select(rootGame);

				System.out.println("generate null 2");

				TypedQuery<Game> games = emManager.createQuery(selectQuery);
				resultList = games.getResultList();

			} catch (NullPointerException e) {
				System.out.println("ausgabe des Fehlers " + e.getLocalizedMessage());
			}
		}

		return resultList;
	}

}
