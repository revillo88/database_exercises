package de.revilo.uebungen.database.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import de.revilo.uebungen.database.repository.model.Game;

public interface GameServiceAble {

	public List<Game> findAll(EntityManager emManager);

	public Game findById(EntityManager emManage, int id);

	public List<Game> findByName(EntityManager emManage, String name);

	public List<Game> findByGenre(EntityManager emManage, String genre);

	public List<Game> findByPlatform(EntityManager emManage, String platform);

}
