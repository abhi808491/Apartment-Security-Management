package com.cg.aps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.entity.GardTraineeEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.GardTraineeDAOInt;

@Service
public class GardTraineeService implements GardTraineeServiceInt {

	@Autowired
	GardTraineeDAOInt gardsTraineeDAOInt;

	@Override
	public long add(GardTraineeEntity bean) {
		Optional<GardTraineeEntity> gard = gardsTraineeDAOInt.findById(bean.getId());
		if (gard.isPresent()) {
			throw new DuplicateRecordException("Record is already exist there no duplicate allowed");
		}
		gardsTraineeDAOInt.save(bean);
		return bean.getId();
	}

	@Override
	public void update(GardTraineeEntity bean) {
		Optional<GardTraineeEntity> gard =gardsTraineeDAOInt.findById(bean.getId());
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		gardsTraineeDAOInt.save(bean);
	}

	@Override
	public void delete(GardTraineeEntity bean) {
		Optional<GardTraineeEntity> gard = gardsTraineeDAOInt.findById(bean.getId());
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		gardsTraineeDAOInt.delete(bean);

	}

	@Override
	public GardTraineeEntity findByPk(long id) {
		Optional<GardTraineeEntity> gard = gardsTraineeDAOInt.findById(id);
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record with the given ID is not found =" + id);
		}
		return gardsTraineeDAOInt.getById(id);

	}

	@Override
	public List<GardTraineeEntity> search(GardTraineeEntity bean) {
		Optional<GardTraineeEntity> gard = gardsTraineeDAOInt.findById(bean.getId());
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		GardTraineeEntity newGard = gardsTraineeDAOInt.getById(bean.getId());
		List<GardTraineeEntity> al = new ArrayList();
		al.add(newGard);
		return al;
	}

	@Override
	public GardTraineeEntity getByName(String name) {
		GardTraineeEntity gard = gardsTraineeDAOInt.findByName(name);
		if (gard == null) {
			throw new RecordNotFoundException("Record not found with given name found in the database = " + name);
		}
		return gardsTraineeDAOInt.findByName(name);
	}

	@Override
	public List<GardTraineeEntity> search( long pageNo, int pageSize) {
		PageRequest paging = PageRequest.of((int) pageNo,pageSize);
		Page<GardTraineeEntity> pagedResult = gardsTraineeDAOInt.findAll(paging);
		if(pagedResult.hasContent())
		{
			return pagedResult.getContent();
		}
		else
		{
			throw new DatabaseException("DataBase not found");
		}

	}

	public List<GardTraineeEntity> getAllGardTraineeByShiftId(long id) {
		return gardsTraineeDAOInt.getAllGardTraineeByShiftId(id);

	}

	@Override
	public GardTraineeEntity getGardBySalaryId(long id) {
		return gardsTraineeDAOInt.getGardBySalaryId(id);
	}
}
