package com.devskiller.tasks.blog.rest;

import com.devskiller.tasks.blog.model.CarParkUnit;
import com.devskiller.tasks.blog.model.ChargePoint;
import com.devskiller.tasks.blog.model.dto.ChargePointDto;
import com.devskiller.tasks.blog.repository.CarParkRepository;
import com.devskiller.tasks.blog.repository.ChargePointRepository;
import com.devskiller.tasks.blog.service.CarParkUBIService;
import com.devskiller.tasks.blog.service.ChargePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chargeapi")
public class CarChargePointController {
	ChargePointService chargePointService;
	CarParkUBIService carParkUBIService;


	@Autowired
	public CarChargePointController(ChargePointService chargePointService, CarParkUBIService carParkUBIService) {
		this.chargePointService = chargePointService;
		this.carParkUBIService = carParkUBIService;
	}

	@GetMapping("/allchargepoints/{id}")
	public ResponseEntity<ChargePointDto> fetchChargePoints(@PathVariable("id") Long parkId)
	{
		ChargePointDto chargePointDto=chargePointService.fetchAllChargesByCarParkUnit(parkId);
		return new ResponseEntity<ChargePointDto>(chargePointDto, HttpStatus.OK);
	}
	@PostMapping("/{id}/installCar")
	public ResponseEntity<Long> insertNewCar(@PathVariable("id")Long id,@RequestBody ChargePoint chargePoint)
	{
		CarParkUnit carParkUnit =carParkUBIService.fetchCarParkByID(id);
		chargePoint.setCarParkUnit(carParkUnit);
		chargePointService.insert(chargePoint,id);
		return new ResponseEntity<Long>(HttpStatus.CREATED);
	}


}
