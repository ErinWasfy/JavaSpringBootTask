package com.devskiller.tasks.blog.model;

import jakarta.persistence.*;

public class Car {
	@Id
	@GeneratedValue(strategy= GenerationType.TABLE)
	private Long Id;
	@Column(name = "CarName")
	private String carName;
	@Column(name = "CarLocation")
	private String carLocation;

	@JoinTable(name = "ChargePoint")
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "chargePointID")
	private ChargePoint chargePoint;

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarLocation() {
		return carLocation;
	}

	public void setCarLocation(String carLocation) {
		this.carLocation = carLocation;
	}

	public ChargePoint getChargePoint() {
		return chargePoint;
	}

	public void setChargePoint(ChargePoint chargePoint) {
		this.chargePoint = chargePoint;
	}

	public Long getId() {
		return Id;
	}
}
