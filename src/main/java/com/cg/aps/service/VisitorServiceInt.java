package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.DeliveryEntity;
import com.cg.aps.entity.VisitorEntity;

public interface VisitorServiceInt {

	public long addVisitor(VisitorEntity visitor);
	public void updateVisitor(VisitorEntity visitor);
	public void deleteVisitor(VisitorEntity visitor);
	public List<VisitorEntity> findByVisitorName(String name);
	public VisitorEntity findByPk(long id);
	public List<VisitorEntity> search(Integer pageNo, Integer pageSize);
	public List<VisitorEntity> search(VisitorEntity visitor) ;
	public List<VisitorEntity> getVisitorByFlatId(long id);
	public VisitorEntity addFlatRelationship(long visitorPk, long flatPk);
}
