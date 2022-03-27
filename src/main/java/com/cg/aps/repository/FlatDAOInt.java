package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.FlatEntity;


@Repository
public interface FlatDAOInt extends JpaRepository<FlatEntity, Long>
{
	
	FlatEntity findByName(String name);
}
