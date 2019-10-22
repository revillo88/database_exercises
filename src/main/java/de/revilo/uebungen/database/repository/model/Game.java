package de.revilo.uebungen.database.repository.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "game")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date erscheinungsdatum;

	private String genre;

	private String name;

	private String platform;

	public Game() {

	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getErscheinungsdatum() {
		return this.erscheinungsdatum;
	}

	public void setErscheinungsdatum(Date erscheinungsdatum) {
		this.erscheinungsdatum = erscheinungsdatum;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Override
	public String toString() {
		return String.format("Game [id=%s, erscheinungsdatum=%s, genre=%s, name=%s, platform=%s]", id,
				erscheinungsdatum, genre, name, platform);
	}

	@Override
	public int hashCode() {
		return Objects.hash(erscheinungsdatum, genre, id, name, platform);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Game))
			return false;
		Game other = (Game) obj;
		return Objects.equals(erscheinungsdatum, other.erscheinungsdatum) && Objects.equals(genre, other.genre)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(platform, other.platform);
	}

}