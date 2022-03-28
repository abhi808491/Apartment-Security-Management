package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.GardTraineeEntity;

@Repository
public interface GardTraineeDAOInt extends JpaRepository<GardTraineeEntity, Long> {
	@Query("select n from GardTraineeEntity n where n.name=:nname")
	GardTraineeEntity findByName(@Param("nname") String name);

	@Query(value= " select * from gard_trainee_entity join gard_shift_entity on gard_trainee_entity.shift_id=gard_shift_entity.id where gard_shift_entity.id=:sId", nativeQuery = true)
	List<GardTraineeEntity> getAllGardTraineeByShiftId(@Param("sId") long id);
	
	
	@Query(value= " select * from gard_trainee_entity join gard_salary_entity on gard_trainee_entity.salary_id=gard_salary_entity.id where gard_salary_entity.id=:sId", nativeQuery = true)
	GardTraineeEntity getGardBySalaryId(@Param("sId") long id);
}
