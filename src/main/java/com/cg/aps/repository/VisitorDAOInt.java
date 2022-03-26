package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.aps.entity.VisitorEntity;

public interface VisitorDAOInt extends JpaRepository<VisitorEntity, Long>{
	@Query("select v from VisitorEntity v where v.visitorName = :name")
	public List<VisitorEntity> findByVisitorName(String name);
}
