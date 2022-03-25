package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.GardSalaryEntity;
@Repository
public interface GardSalaryDAOInt extends JpaRepository<GardSalaryEntity,Long>{
	@Query("select n from GardSalaryEntity n where n.name=:nname")
	public GardSalaryEntity findByName(@Param("nname") String name);

}
