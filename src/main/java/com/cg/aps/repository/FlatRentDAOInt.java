package com.cg.aps.repository;
import com.cg.aps.entity.FlatRentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRentDAOInt extends JpaRepository<FlatRentEntity, Long> 
{
	FlatRentEntity findByOwnerName(String name);

}
