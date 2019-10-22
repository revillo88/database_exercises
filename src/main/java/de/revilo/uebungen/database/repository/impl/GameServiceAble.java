package de.revilo.uebungen.database.repository.impl;

import java.util.List;

import de.revilo.uebungen.database.repository.model.Game;

public interface GameServiceAble {

	public List<Game> findAll();

	public Game findById(int id);

	public List<Game> findByName(String name);

	public List<Game> findByGenre(String genre);

	public List<Game> findByPlatform(String platform);

}
