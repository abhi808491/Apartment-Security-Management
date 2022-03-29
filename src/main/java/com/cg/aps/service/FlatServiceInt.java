package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.FlatEntity;

public interface FlatServiceInt 
{
	public long add(FlatEntity bean);
	
	public void update(FlatEntity bean);
	
	public void delete(FlatEntity bean);
	
	public FlatEntity findByOwnerName(String name);
	
	public FlatEntity findByPk(long id);
	
	public List<FlatEntity> search(FlatEntity bean, long pageNo, int pageSize);
	
	public List<FlatEntity> search(FlatEntity bean);
	
	public FlatEntity getFlatByRent(Long rentId);
	
	public FlatEntity getFlatByUser(Long user_flatid);
	

}
