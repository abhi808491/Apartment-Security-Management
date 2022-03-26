package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.DomesticHelpEntity;
@Repository
public interface DomesticHelpDAOInt extends JpaRepository<DomesticHelpEntity, Long>{
	public DomesticHelpEntity findByOwnerName(String name);
	
}
