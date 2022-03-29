package com.cg.aps.service;
import java.util.List;

import com.cg.aps.entity.DeliveryEntity;
public interface DeliveryServiceInt {
public long add(DeliveryEntity bean);
	
	public void update(DeliveryEntity bean);
	
	public void delete(DeliveryEntity bean);
	
	public List<DeliveryEntity> findByName(String name);
	
	public DeliveryEntity findByPk(long id);
	
	public List<DeliveryEntity> search(long pageNo, int pageSize);
	
	public List<DeliveryEntity> search(DeliveryEntity bean);

	List<DeliveryEntity> getDeliveryListByFlatId(long id);
	
	List<DeliveryEntity> getDeliveryListByGuardId(long id);
	
	DeliveryEntity addFlat(long deliveryPk,long flatPk);

}
