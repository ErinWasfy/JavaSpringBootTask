package com.devskiller.tasks.blog.rest;

import com.devskiller.tasks.blog.model.CarParkUnit;
import com.devskiller.tasks.blog.model.ChargePoint;
import com.devskiller.tasks.blog.model.dto.ChargePointDto;
import com.devskiller.tasks.blog.utilities.ChargePointStatus;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CarParkUBIRestControllerTest extends AbstractControllerTest {

	@Test
//	@WithMockUser(roles = "ADMIN")
	void insertNewCarParkUBI() throws Exception {
//		CarParkUnit carParkUnit=new CarParkUnit(100);
//		ChargePoint chargePoint=new ChargePoint(10, ChargePointStatus.OCCUPIED,null);
//	    String chargePointContent="{\"chargePointCapacity\":\"10\",\"chargePointCapacityStatus\":\"OCCUPIED\"}";
//		when(chargePointService.insert(any(ChargePoint.class),any())).thenReturn(1L);
//		mockMvc.perform(post("/chargeapi/1/installCar").contentType(APPLICATION_JSON).content(chargePointContent).with(csrf()).accept(MediaType.APPLICATION_JSON))
//			.andExpect(status().isCreated());


	}

	@Test
	//@WithMockUser(roles = "ADMIN")
	void fetchCarParkById() throws Exception {
//		ChargePointDto chargePointDto=new ChargePointDto("cp1",ChargePointStatus.OCCUPIED,10);
//		when(chargePointService.fetchAllChargesByCarParkUnit(any())).thenReturn(chargePointDto);
//		mockMvc.perform(get("/chargeapi/allchargepoints/1").with(csrf()).accept(APPLICATION_JSON))
//			.andExpect(status().isOk()).andExpect(jsonPath("$.chargePointName").value("cp1"))
//			.andExpect(jsonPath("$.status").value("OCCUPIED"))
//			.andExpect(jsonPath("$.capty").value(10))
//			.andExpect(res-> Assert.notNull(res.getResponse(),"true"));
	}
}
