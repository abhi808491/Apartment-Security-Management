package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.FlatRentEntity;
public interface FlatRentServiceInt 
{
	public long add(FlatRentEntity bean);
	
	public void update(FlatRentEntity bean);
	
	public void delete(FlatRentEntity bean);
	
	public FlatRentEntity findByOwnerName(String name);
	
	public FlatRentEntity findByPk(long id);
	
	public List<FlatRentEntity> search(FlatRentEntity bean, long pageNo, int pageSize);
	
	public List<FlatRentEntity> search(FlatRentEntity bean);
	

}
