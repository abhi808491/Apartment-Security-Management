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
	public List<DeliveryEntity> getDeliveriesOfFlat(@Param("flatId") Long flat_id);
	@Query(value="select d.* from delivery_entity d inner join flat_entity f on d.flat_id=f.id inner join user_entity u on f.id=u.flat_id inner join gard_trainee_entity g on u.gard_id=g.id where g.id=:guardId",nativeQuery=true)
	public List<DeliveryEntity> getDeliveryListOfGuard(@Param("guardId")long guard_id);
}
