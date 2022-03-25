package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.GardsTranningEntity;
@Repository
public interface GardsTranningDAOInt extends JpaRepository<GardsTranningEntity,Long> {
	@Query("select n from GardsTranningEntity n where n.name=:nname")
	GardsTranningEntity getByName(@Param("nname") String name);

	
}
