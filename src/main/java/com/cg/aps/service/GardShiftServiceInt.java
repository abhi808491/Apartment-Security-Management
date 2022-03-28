package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.entity.GardTraineeEntity;

public interface GardShiftServiceInt {

	public long add(GardShiftEntity bean);

	public void update(GardShiftEntity bean);

	public void delete(GardShiftEntity bean);

	public GardShiftEntity getByName(String name);

	public GardShiftEntity findByPk(long id);

	public List<GardShiftEntity> search( long pageNo, int pageSize);

	public List<GardShiftEntity> search(GardShiftEntity bean);

}
