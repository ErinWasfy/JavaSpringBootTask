package com.devskiller.tasks.blog.rest;

import com.devskiller.tasks.blog.model.CarParkUnit;
import com.devskiller.tasks.blog.repository.CarParkRepository;
import com.devskiller.tasks.blog.service.CarParkUBIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarParkUBIRestController {
	CarParkUBIService carParkUBIService;

	@Autowired
	public CarParkUBIRestController(CarParkUBIService carParkUBIService) {
		this.carParkUBIService = carParkUBIService;
	}
	@PostMapping("/newcarparkUBI")
	public ResponseEntity<Long> insertNewCarParkUBI(@RequestBody CarParkUnit carParkUnit)
	{
		Long carParkUnitId=carParkUBIService.insertCarPark(carParkUnit);
		return new ResponseEntity<Long>(carParkUnitId, HttpStatus.CREATED);
	}
	@GetMapping("/carparkubi/{id}")
	public ResponseEntity<CarParkUnit> fetchCarParkById(@PathVariable("id") Long id)
	{
		return new ResponseEntity<CarParkUnit>(carParkUBIService.fetchCarParkByID(id),HttpStatus.OK);
	}
}
