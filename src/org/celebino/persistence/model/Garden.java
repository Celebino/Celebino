package org.celebino.persistence.model;

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
@Table(name = "tb_garden")
@NamedQuery(name = "Garden.getAll", query = "from Garden")
public class Garden {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "garden_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_user_id")
	private User user;
	 
	@Column(name = "garden_soilHumidity")	
	private int soilHumidity;
	
	@Column(name = "garden_sunLight")	
	private int sunLight;
	
	@Column(name = "garden_airHumidity")	
	private int airHumidity;
	
	@Column(name = "garden_airTemperature")	
	private int airTemperature;
	
	
	public Garden(){}
	
	public Garden(Long id, User user, int soilHumidity, int sunLight, int airHumidity, int airTemperature) {
		super();
		this.id = id;
		this.user = user;
		this.soilHumidity = soilHumidity;
		this.sunLight = sunLight;
		this.airHumidity = airHumidity;
		this.airTemperature = airTemperature;
	}
	@XmlElement
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@XmlElement
	public int getSoilHumidity() {
		return soilHumidity;
	}

	public void setSoilHumidity(int soilHumidity) {
		this.soilHumidity = soilHumidity;
	}

	@XmlElement
	public int getSunLight() {
		return sunLight;
	}

	public void setSunLight(int sunLight) {
		this.sunLight = sunLight;
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

	
	@Override
	public String toString() {
		return "Garden [id=" + id + ", User Id=" + user.getId() + ", soilHumidity=" + soilHumidity + ", sunLight=" + sunLight
				+ ", airHumidity=" + airHumidity + ", airTemperature=" + airTemperature + "]";
	}
}
