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

import com.sun.xml.txw2.annotation.XmlElement;

@Entity
@Table(name = "tb_gardenStatus")
@NamedQuery(name = "GardenStatus.getAll", query = "from GardenStatus")
public class GardenStatus {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "gardenStatus_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_garden_id")
	private Garden garden;

	@Column(name = "gardenStatu_sunLight")
	private int sunLight;
	
	@Column(name = "gardenStatus_soilHumidity")
	private int soilHumidity;
	
	@Column(name = "gardenStatus_airHumidity")
	private int airHumidity;
	
	@Column(name = "gardenStatus_airTemperature")
	private int airTemperature;
	
	@Column(name = "gardenStatus_time")
	private Timestamp time;
	
	public GardenStatus(){}
	
	
	public GardenStatus(Long id, Garden garden, int sunLight, int soilHumidity, int airHumidity, int airTemperature,
			Timestamp time) {
		super();
		this.id = id;
		this.garden = garden;
		this.sunLight = sunLight;
		this.soilHumidity = soilHumidity;
		this.airHumidity = airHumidity;
		this.airTemperature = airTemperature;
		this.time = time;
	}
	@XmlElement
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@XmlElement
	public Garden getGarden() {
		return garden;
	}
	public void setGarden(Garden garden) {
		this.garden = garden;
	}
	
	
	@XmlElement
	public int getSunLight() {
		return sunLight;
	}
	public void setSunLight(int sunLight) {
		this.sunLight = sunLight;
	}
	
	@XmlElement
	public int getSoilHumidity() {
		return soilHumidity;
	}
	public void setSoilHumidity(int soilHumidity) {
		this.soilHumidity = soilHumidity;
	}
	
	@XmlElement
	public int getAirHumidity() {
		return airHumidity;
	}
	public void setAirHumidity(int airHumidity) {
		this.airHumidity = airHumidity;
	}
	
	@XmlElement
	public int getAirTemperature() {
		return airTemperature;
	}
	public void setAirTemperature(int airTemperature) {
		this.airTemperature = airTemperature;
	}

	@XmlElement
	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "GardenStatus [id=" + id + ", garden=" + garden + ", sunLight=" + sunLight + ", soilHumidity="
				+ soilHumidity + ", airHumidity=" + airHumidity + ", airTemperature=" + airTemperature + ", time="
				+ time + "]";
	}

	
	
}
