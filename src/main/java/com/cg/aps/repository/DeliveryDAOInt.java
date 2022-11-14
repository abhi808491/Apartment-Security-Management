package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.DeliveryEntity;

@Repository
public interface DeliveryDAOInt extends JpaRepository<DeliveryEntity, Long> {

	public List<DeliveryEntity> findByOwnerName(String name);

	@Query(value = "select * from delivery_entity inner join flat_entity on delivery_Entity.flat_id=flat_entity.id where flat_entity.id=:flatId", nativeQuery = true)
	public List<DeliveryEntity> getDeliveriesOfFlat(@Param("flatId") Long flatId);

	@Query(value = "select d.* from delivery_entity d inner join flat_entity f on d.flat_id=f.id inner join user_entity u on f.id=u.flat_id  where u.id=:userId", nativeQuery = true)
	public List<DeliveryEntity> getDeliveryListByUserId(@Param("userId") long userId);

	@Query(value = "select * from delivery_entity inner join gard_trainee_entity on delivery_Entity.guard_trainee_id=gard_trainee_entity.id where gard_trainee_entity.id=:guardId", nativeQuery = true)
	public List<DeliveryEntity> getDeliveryListByGuardId(@Param("guardId") Long guardId);

}
