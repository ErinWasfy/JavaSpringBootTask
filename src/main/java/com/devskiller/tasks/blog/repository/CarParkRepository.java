package com.devskiller.tasks.blog.repository;

import com.devskiller.tasks.blog.model.CarParkUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CarParkRepository extends JpaRepository<CarParkUnit,Long> {
	@Query(value="select cp.car_park_capacity from car_park cp where cp.ID=?1",nativeQuery = true)
	Optional<Integer> carParkCapacity(Long carParkID);
}
