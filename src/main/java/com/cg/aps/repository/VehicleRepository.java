package com.cg.aps.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.VehicleEntity;
@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long>{
	@Query(value="select vehicle_entity.* from vehicle_entity where vehicle_entity.vehicle_name=:name", nativeQuery=true)
	VehicleEntity findByAttName(@Param("name") String name);

}

