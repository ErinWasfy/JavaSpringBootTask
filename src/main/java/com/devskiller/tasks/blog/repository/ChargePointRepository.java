package com.devskiller.tasks.blog.repository;

import com.devskiller.tasks.blog.model.ChargePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChargePointRepository extends JpaRepository<ChargePoint,Long> {

	@Query(value = "select sum(cp.charge_point_capacity) from charge_point cp where cp.car_park_id=?1",nativeQuery = true)
	Optional<Integer> countChargePointsAmber(Long carParkID);
	@Query(value = "select * from charge_point cp where cp.car_park_id=?1",nativeQuery = true)
	Optional<ChargePoint> fetchAllChargePointsByID(Long id);
}
