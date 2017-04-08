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
@Table(name = "tb_gardenStatus")
@NamedQuery(name = "GardenStatus.getAll", query = "from GardenStatus")
public class GardenStatus {
	@Id @GeneratedValue
	@Column(name = "gardenStatus_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "fk_garden_id", table = "Garden")
	private Garden garden;
	
	@Column(name = "gardenStatus_date")
	private Date date;
	//hour
	
	@Column(name = "gardenStatu_sunLight")
	private int sunLight;
	
	@Column(name = "gardenStatus_soilHumidity")
	private int soilHumidity;
	
	@Column(name = "gardenStatus_airHumidity")
	private int airHumidity;
	
	@Column(name = "gardenStatus_airTemperature")
	private int airTemperature;
	
	
	public GardenStatus(Long id, Garden garden, Date date, int sunLight, int soilHumidity, int airHumidity,
			int airTemperature) {
		super();
		this.id = id;
		this.garden = garden;
		this.date = date;
		this.sunLight = sunLight;
		this.soilHumidity = soilHumidity;
		this.airHumidity = airHumidity;
		this.airTemperature = airTemperature;
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
	public int getSunLight() {
		return sunLight;
	}
	public void setSunLight(int sunLight) {
		this.sunLight = sunLight;
	}
	public int getSoilHumidity() {
		return soilHumidity;
	}
	public void setSoilHumidity(int soilHumidity) {
		this.soilHumidity = soilHumidity;
	}
	public int getAirHumidity() {
		return airHumidity;
	}
	public void setAirHumidity(int airHumidity) {
		this.airHumidity = airHumidity;
	}
	public int getAirTemperature() {
		return airTemperature;
	}
	public void setAirTemperature(int airTemperature) {
		this.airTemperature = airTemperature;
	}



	@Override
	public String toString() {
		return "GardenStatus [id=" + id + ", id_garden=" + garden.getId() + ", date=" + date + ", sunLight=" + sunLight
				+ ", soilHumidity=" + soilHumidity + ", airHumidity=" + airHumidity + ", airTemperature="
				+ airTemperature + "]";
	}
}
