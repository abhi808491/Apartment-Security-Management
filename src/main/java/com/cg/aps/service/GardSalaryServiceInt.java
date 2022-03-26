package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.GardSalaryEntity;

public interface GardSalaryServiceInt {

	public long add(GardSalaryEntity bean);

	public void update(GardSalaryEntity bean);

	public void delete(GardSalaryEntity bean);

	public GardSalaryEntity findByName(String name);

	public GardSalaryEntity findByPk(long id);

	public List<GardSalaryEntity> search(GardSalaryEntity bean, long pageNo, int pageSize);

	public List<GardSalaryEntity> search(GardSalaryEntity bean);

}
