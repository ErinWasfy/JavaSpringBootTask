package com.devskiller.tasks.blog.service;

import com.devskiller.tasks.blog.model.CarParkUnit;
import com.devskiller.tasks.blog.model.ChargePoint;
import com.devskiller.tasks.blog.model.dto.ChargePointDto;
import com.devskiller.tasks.blog.repository.CarParkRepository;
import com.devskiller.tasks.blog.repository.ChargePointRepository;
import com.devskiller.tasks.blog.utilities.ChargePointStatus;
import com.zaxxer.hikari.util.IsolationLevel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargePointService {
	private ChargePointRepository chargePointRepository;
    private CarParkRepository carParkRepository;
	@Autowired
	public ChargePointService(ChargePointRepository chargePointRepository,CarParkRepository carParkRepository) {
		this.chargePointRepository = chargePointRepository;
		this.carParkRepository=carParkRepository;
	}
    public boolean isInsertChargePointAllowed(Long id)
	{
		int count=0;
		int carparkCap=0;
		if(chargePointRepository.countChargePointsAmber(id).isPresent())
		{
			count=chargePointRepository.countChargePointsAmber(id).get();
		}
		if(carParkRepository.carParkCapacity(id).isPresent())
			carparkCap=carParkRepository.carParkCapacity(id).get();
	if(carparkCap<count)
			return false;
	return true;
	}
	@Transactional
	public Long insert(ChargePoint chargePoint,Long id)
	{
		if(isInsertChargePointAllowed(id))
		return chargePointRepository.save(chargePoint).getId();
		else
		{
		  ChargePoint cp= new ChargePoint(chargePoint.getChargePointCapacity(), ChargePointStatus.AVAILABLE);
          return chargePointRepository.save(cp).getId();
		}
	}
	public ChargePointDto fetchAllChargesByCarParkUnit(Long id)
	{
       if(chargePointRepository.fetchAllChargePointsByID(id).isPresent())
	   {
		return  chargePointRepository.fetchAllChargePointsByID(id).map(cp->
			new ChargePointDto(cp.getChargePointName(),cp.getChargePointCapacityStatus(),cp.getChargePointCapacity())).get();
	   }
	   return null;
	}

}
