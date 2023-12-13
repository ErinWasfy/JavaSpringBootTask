package com.devskiller.tasks.blog.service;

import com.devskiller.tasks.blog.model.CarParkUnit;
import com.devskiller.tasks.blog.model.ChargePoint;
import com.devskiller.tasks.blog.utilities.ChargePointStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class ChargePointServiceTest {

	@Autowired
	ChargePointService chargePointService;
	@Test
	void insert() {
		CarParkUnit carParkUnit=new CarParkUnit("UBS","Loc",100);
		ChargePoint cp=new ChargePoint(10, ChargePointStatus.AVAILABLE);
		cp.setCarParkUnit(carParkUnit);
		Long id=chargePointService.insert(cp,carParkUnit.getId());
		assertThat("charge point couldnt be null",id,notNullValue());
	    assertThat(cp.getChargePointCapacity(),equalTo(10));
	}

	@Test
	void fetchAllChargesByCarParkUnit() {
	}
}
