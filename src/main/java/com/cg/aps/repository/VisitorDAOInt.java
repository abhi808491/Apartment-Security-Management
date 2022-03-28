package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.aps.entity.DeliveryEntity;
import com.cg.aps.entity.VisitorEntity;

public interface VisitorDAOInt extends JpaRepository<VisitorEntity, Long>{
	@Query("select v from VisitorEntity v where v.visitorName = :name")
	public List<VisitorEntity> findByVisitorName(String name);
	
	
	
@Query(value = "select * from visitor_entity inner join flat_entity on visitor_Entity.flatid=flat_entity.id where flat_entity.id=:flatId", nativeQuery = true)
public List<VisitorEntity> getVisitorByFlat(@Param("flatId") Long flat_id);
}