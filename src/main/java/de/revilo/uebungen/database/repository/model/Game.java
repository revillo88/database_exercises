package de.revilo.uebungen.database.repository.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "game")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date erscheinungsdatum;

	@Column(nullable = false, length = 255)
	private String name;

	@Column(length = 255)
	private String platform;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "genre", nullable = false)
	private Genre genreBean;

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

	public Genre getGenreBean() {
		return this.genreBean;
	}

	public void setGenreBean(Genre genreBean) {
		this.genreBean = genreBean;
	}

	@Override
	public String toString() {
		return String.format("Game [id=%s, erscheinungsdatum=%s, name=%s, platform=%s, genreBean=%s]", id,
				erscheinungsdatum, name, platform, genreBean);
	}

	@Override
	public int hashCode() {
		return Objects.hash(erscheinungsdatum, genreBean, id, name, platform);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Game))
			return false;
		Game other = (Game) obj;
		return Objects.equals(erscheinungsdatum, other.erscheinungsdatum) && Objects.equals(genreBean, other.genreBean)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(platform, other.platform);
	}

}