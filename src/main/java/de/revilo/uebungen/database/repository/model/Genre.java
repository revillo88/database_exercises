package de.revilo.uebungen.database.repository.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String art;

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

	@Override
	public int hashCode() {
		return Objects.hash(art, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Genre))
			return false;
		Genre other = (Genre) obj;
		return Objects.equals(art, other.art) && Objects.equals(id, other.id);
	}

	
}