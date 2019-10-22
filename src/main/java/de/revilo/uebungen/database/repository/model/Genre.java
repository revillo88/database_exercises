package de.revilo.uebungen.database.repository.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(nullable = false, length = 255)
	private String art;

	@OneToMany(mappedBy = "genreBean")
	private List<Game> games;

	public Genre() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArt() {
		return this.art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Game addGame(Game game) {
		getGames().add(game);
		game.setGenreBean(this);

		return game;
	}

	public Game removeGame(Game game) {
		getGames().remove(game);
		game.setGenreBean(null);

		return game;
	}

	@Override
	public int hashCode() {
		return Objects.hash(art, games, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Genre))
			return false;
		Genre other = (Genre) obj;
		return Objects.equals(art, other.art) && Objects.equals(games, other.games) && Objects.equals(id, other.id);
	}

}