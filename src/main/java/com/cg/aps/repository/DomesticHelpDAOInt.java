package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.aps.entity.DomesticHelpEntity;

@Repository
public interface DomesticHelpDAOInt extends JpaRepository<DomesticHelpEntity, Long> {
	public List<DomesticHelpEntity> findByName(String name);

	@Query(value = "select * from domestic_help_entity inner join gard_trainee_entity on domestic_help_entity.guard_trainee_id=gard_trainee_entity.id where gard_trainee_entity.id=:guardId", nativeQuery = true)
	public List<DomesticHelpEntity> getDomesticHelpListByGuardId(@Param("guardId") Long guardId);

}
