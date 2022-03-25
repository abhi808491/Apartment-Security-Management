package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.GardShiftEntity;

@Repository
public interface GardShiftDAOInt  extends JpaRepository<GardShiftEntity,Long>{
	@Query("select n from GardShiftEntity n where n.name=:nname")
	public GardShiftEntity getByName(@Param("nname") String name);
	
}
