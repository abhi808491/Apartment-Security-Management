package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.aps.entity.SecurityEntity;
import com.cg.aps.entity.VisitorEntity;

public interface SecurityDAOInt extends JpaRepository <SecurityEntity, Long>{
	
	
@Query(value = "select * from security_entity inner join gard_trainee_entity on security_Entity.gardid=gard_trainee_entity.id where gard_trainee_entity.id=:gardId", nativeQuery = true)
public List<SecurityEntity> getSecurityByGard(@Param("gardId") Long id);
}


