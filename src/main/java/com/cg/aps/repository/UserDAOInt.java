package com.cg.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.UserEntity;
@Repository
public interface UserDAOInt extends JpaRepository<UserEntity,Long>{
	@Query("select n from UserEntity n where n.loginId=:nloginId")
	public UserEntity findByLogin(@Param("nloginId") String login);
	
	@Query(value= " select * from user_entity join flat_entity on user_entity.flat_id=flat_entity.id where flat_entity.id=:sId", nativeQuery = true)
	UserEntity getUserbyFlatId(@Param("sId") long id);
	
	@Query(value= " select * from user_entity join flat_rent_entity on user_entity.flatrent_id=flat_rent_entity.id where flat_rent_entity.id=:sId", nativeQuery = true)
	UserEntity getUserbyFlatRentId(@Param("sId") long id);
	
	@Query(value= " select * from user_entity join gard_trainee_entity on user_entity.gard_id=gard_trainee_entity.id where gard_trainee_entity.id=:sId", nativeQuery = true)
	UserEntity getUserbyGardTraineeId(@Param("sId") long id);
	
}