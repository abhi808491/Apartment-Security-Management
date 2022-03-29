package com.cg.aps.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.UserEntity;
import com.cg.aps.entity.VehicleEntity;
@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long>{
	@Query(value="select vehicle_entity.* from vehicle_entity where vehicle_entity.vehicle_name=:name", nativeQuery=true)
	VehicleEntity findByAttName(@Param("name") String name);
	@Query(value = "select vehicle_entity.* from vehicle_entity inner join user_entity on vehicle_entity.user_id=user_entity.id where user_entity.id=:userId",nativeQuery=true)
    public VehicleEntity getVehicleOfUser(@Param("userId") Long user_id);
}
