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
	
}