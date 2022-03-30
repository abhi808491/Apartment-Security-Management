package com.cg.aps.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.aps.entity.VehicleEntity;
@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long>{
	@Query(value="select vehicle_entity.* from vehicle_entity where vehicle_entity.vehicle_name=:name", nativeQuery=true)
	VehicleEntity findByAttName(@Param("name") String name);
	@Query(value = "select vehicle_entity.* from vehicle_entity inner join flat_entity on vehicle_entity.flat_id=flat_entity.id where flat_entity.id=:flatId",nativeQuery=true)
    public List<VehicleEntity> getVehicleOfFlat(@Param("flatId") Long flat_id);
}
