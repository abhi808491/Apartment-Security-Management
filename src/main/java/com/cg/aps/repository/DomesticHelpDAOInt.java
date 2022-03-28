package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.aps.entity.DomesticHelpEntity;
@Repository
public interface DomesticHelpDAOInt extends JpaRepository<DomesticHelpEntity, Long>{
	public List<DomesticHelpEntity> findByOwnerName(String name);

	@Query(value = "select * from domestic_help_entity inner join flat_entity on domestic_help_Entity.flat_id=flat_entity.id where flat_entity.id=:flatId", nativeQuery = true)
	public List<DomesticHelpEntity> getDomesticHelpListByFlat(@Param("flatId") Long flat_id);
	
}
