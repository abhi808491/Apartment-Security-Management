package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.entity.FlatEntity;


@Repository
public interface FlatDAOInt extends JpaRepository<FlatEntity, Long>
{
	
	FlatEntity findByOwnerName(String name);
	@Query(value = "select * from flat_entity inner join flat_rent_entity on flat_entity.rent_id=flat_rent_entity.flatrent where flat_rent_entity.flatrent=:flatRentId", nativeQuery = true)
	public FlatEntity getFlatByRent(@Param("flatRentId") Long rent_id);
	@Query(value = "select * from flat_entity inner join user_entity on flat_entity.user_flatid= user_entity.user where user_entity.user=:UserId", nativeQuery = true)
	public FlatEntity getFlatByUser(@Param("UserId") Long user_flatid);
	
	@Query(value = "select * from domestic_help_entity inner join flat_entity on domestic_help_Entity.flat_id=flat_entity.id where domestic_help_entity.id=:domestic_help_id", nativeQuery = true)
	public List<FlatEntity> getFlatListByDomesticHelp(@Param("domestic_help_id") Long domestic_help_id);
	
}
