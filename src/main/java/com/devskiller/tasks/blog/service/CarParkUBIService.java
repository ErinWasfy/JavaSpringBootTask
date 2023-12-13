package com.devskiller.tasks.blog.service;

import com.devskiller.tasks.blog.model.CarParkUnit;
import com.devskiller.tasks.blog.repository.CarParkRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarParkUBIService {
	private CarParkRepository carParkRepository;

	@Autowired
	public CarParkUBIService(CarParkRepository carParkRepository) {
		this.carParkRepository = carParkRepository;
	}

	//@Transactional
	public Long insertCarPark(CarParkUnit carParkUnit)
	{
		return carParkRepository.save(carParkUnit).getId();
	}
	public CarParkUnit fetchCarParkByID(Long Id)
	{
		return carParkRepository.findById(Id).get();
	}
}
