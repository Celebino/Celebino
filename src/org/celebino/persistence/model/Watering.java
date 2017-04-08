package org.celebino.persistence.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_watering")
@NamedQuery(name = "Watering.getAll", query = "from Watering")
public class Watering {
	
	@Id @GeneratedValue
	@Column(name = "watering_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "fk_garden_id", table = "Garden")
	private Garden garden;
	
	@Column(name = "watering_date")
	private Date date;
	//hour
	
	public Watering(Long id, Garden garden, Date date) {
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
