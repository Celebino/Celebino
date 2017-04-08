package org.celebino.persistence.model;

import java.sql.Date;

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
	
	@Column(name = "artificialLight_date")
	private Date date;
	//hour
	
	public ArtificialLight(){}
	
	public ArtificialLight(Long id, Garden garden, Date date) {
		super();
		this.id = id;
		this.garden = garden;
		this.date = date;
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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Watering [id=" + id + ", id_garden=" + garden.getId() + ", date=" + date + "]";
	}

}
