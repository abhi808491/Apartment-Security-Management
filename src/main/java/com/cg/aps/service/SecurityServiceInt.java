package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.SecurityEntity;



public interface SecurityServiceInt {

public long add(SecurityEntity bean);
	
	public void update(SecurityEntity bean);
	
	public void delete(SecurityEntity bean);
	
	public SecurityEntity findByPk(long id);
	
	public List<SecurityEntity> search(SecurityEntity bean, long pageNo, int pageSize);
	
	public List<SecurityEntity> search(SecurityEntity bean);
}
