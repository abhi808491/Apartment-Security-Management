package com.cg.aps.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.DeliveryEntity;
@Repository
public interface DeliveryDAOInt extends JpaRepository<DeliveryEntity,Long>{
	
	 public DeliveryEntity findByOwnerName(String name);
	
}
