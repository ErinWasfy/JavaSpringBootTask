package com.devskiller.tasks.blog.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;

@Entity
@Table(name = "car_park")
public class CarParkUnit {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "car_park_name")
	private String carParkName;
	@Column(name = "car_park_location")
	private String carParkLocation;
	@Column(name = "car_park_capacity")
	private int capacity;

	public CarParkUnit()
	{}
	@JsonCreator
	public CarParkUnit(@JsonProperty("car_park_name") String carParkName,@JsonProperty("car_location") String carParkLocation,@JsonProperty("capacity") int capacity) {
		this.carParkName = carParkName;
		this.carParkLocation = carParkLocation;
		this.capacity = capacity;
	}

	public String getCarParkName() {
		return carParkName;
	}

	public void setCarParkName(String carParkName) {
		this.carParkName = carParkName;
	}

	public String getCarParkLocation() {
		return carParkLocation;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCarParkLocation(String carParkLocation) {
		this.carParkLocation = carParkLocation;
	}

	public Long getId() {
		return Id;
	}
}
