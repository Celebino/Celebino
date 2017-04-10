package org.celebino.persistence.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_artificialLight")
@NamedQuery(name = "ArtificialLight.getAll", query = "from ArtificialLight")
public class ArtificialLight {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "artificialLight_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_garden_id")
	private Garden garden;
	
	@Column(name = "artificiallight_time")
	private Timestamp time;
	
	public ArtificialLight(){}
	
	
	public ArtificialLight(Long id, Garden garden, Timestamp time) {
		super();
		this.id = id;
		this.garden = garden;
		this.time = time;
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Garden getGarden() {
		return garden;
	}
	
	public void setGarden(Garden garden) {
		this.garden = garden;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ArtificialLight [id=" + id + ", garden=" + garden + ", time=" + time + "]";
	}
	
	
}
