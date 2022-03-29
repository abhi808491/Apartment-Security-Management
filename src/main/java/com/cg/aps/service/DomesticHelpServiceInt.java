package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.entity.FlatEntity;

public interface DomesticHelpServiceInt {

	public long add(DomesticHelpEntity bean);
	
	public void update(DomesticHelpEntity bean);
	
	public void delete(DomesticHelpEntity bean);
	
	public List<DomesticHelpEntity> findByName(String name);
	
	public DomesticHelpEntity findByPk(long id);
	
	public List<DomesticHelpEntity> search(long pageNo, int pageSize);
	
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean);



	
}
