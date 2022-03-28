package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.DeliveryEntity;

@Repository
public interface DeliveryDAOInt extends JpaRepository<DeliveryEntity, Long> {
	
	public List<DeliveryEntity> findByOwnerName(String name);
	@Query(value = "select * from delivery_entity inner join flat_entity on delivery_Entity.flat_id=flat_entity.id where flat_entity.id=:flatId", nativeQuery = true)
	public List<DeliveryEntity> getDeliveriesOfFlat(@Param("flatId") Long flat_id);
}
