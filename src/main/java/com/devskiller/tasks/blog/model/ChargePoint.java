package com.devskiller.tasks.blog.model;

import com.devskiller.tasks.blog.utilities.ChargePointStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "charge_point")
public class ChargePoint {
	@Id
	@GeneratedValue(strategy= GenerationType.TABLE)
	private Long Id;
    @Column(name = "charge_point_name")
	private String chargePointName;
	@Column(name = "charge_point_capacity")
	private int chargePointCapacity;
	@Column(name = "charge_point_status")
	private ChargePointStatus chargePointCapacityStatus;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "car_park_id")
	private CarParkUnit carParkUnit;

	public int getChargePointCapacity() {
		return chargePointCapacity;
	}

	public void setChargePointCapacity(int chargePointCapacity) {
		this.chargePointCapacity = chargePointCapacity;
	}

	public ChargePointStatus getChargePointCapacityStatus() {
		return chargePointCapacityStatus;
	}

	public void setChargePointCapacityStatus(ChargePointStatus chargePointCapacityStatus) {
		this.chargePointCapacityStatus = chargePointCapacityStatus;
	}

	public CarParkUnit getCarParkUnit() {
		return carParkUnit;
	}

	public void setCarParkUnit(CarParkUnit carParkUnit) {
		this.carParkUnit = carParkUnit;
	}

	@JsonCreator
	public ChargePoint(@JsonProperty("chargePointCapacity") int chargePointCapacity, @JsonProperty("chargePointCapacityStatus")ChargePointStatus chargePointCapacityStatus) {
		this.chargePointCapacity = chargePointCapacity;
		this.chargePointCapacityStatus = chargePointCapacityStatus;
	}
    public ChargePoint(){}
	public Long getId() {
		return Id;
	}

	public String getChargePointName() {
		return chargePointName;
	}

	public void setChargePointName(String chargePointName) {
		this.chargePointName = chargePointName;
	}
}
