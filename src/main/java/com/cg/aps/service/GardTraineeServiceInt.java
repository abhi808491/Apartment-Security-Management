package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.GardTraineeEntity;

public interface GardTraineeServiceInt {
	public long add(GardTraineeEntity bean);

	public void update(GardTraineeEntity bean);

	public void delete(GardTraineeEntity bean);

	public GardTraineeEntity getByName(String name);

	public GardTraineeEntity findByPk(long id);

	public List<GardTraineeEntity> search( long pageNo, int pageSize);

	public List<GardTraineeEntity> search(GardTraineeEntity bean);

	public List<GardTraineeEntity> getAllGardTraineeByShiftId(long id);

	GardTraineeEntity getGardBySalaryId(long id);

}
