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
import com.cg.aps.repository.GardShiftDAOInt;

@Service
public class GardShiftService implements GardShiftServiceInt {
	@Autowired
	GardShiftDAOInt gardShiftDAOInt;

	@Override
	public long add(GardShiftEntity bean) {
		Optional<GardShiftEntity> gard = gardShiftDAOInt.findById(bean.getId());
		if (gard.isPresent()) {
			throw new DuplicateRecordException("Record is already exist there no duplicate allowed");
		}
		gardShiftDAOInt.save(bean);
		return bean.getId();
	}

	@Override
	public void update(GardShiftEntity bean) {
		Optional<GardShiftEntity> gard = gardShiftDAOInt.findById(bean.getId());
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		gardShiftDAOInt.save(bean);

	}

	@Override
	public void delete(GardShiftEntity bean) {
		Optional<GardShiftEntity> gard = gardShiftDAOInt.findById(bean.getId());
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		gardShiftDAOInt.delete(bean);

	}

	@Override
	public GardShiftEntity getByName(String name) {
		GardShiftEntity gard = gardShiftDAOInt.findByName(name);
		if (gard == null) {
			throw new RecordNotFoundException("Record not found with given name found in the database = " + name);
		}
		return gardShiftDAOInt.findByName(name);
	}

	@Override
	public GardShiftEntity findByPk(long id) {
		Optional<GardShiftEntity> gard = gardShiftDAOInt.findById(id);
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record not found with given Id =" + id);
		}
		return gardShiftDAOInt.getById(id);
	}

	@Override
	public List<GardShiftEntity> search( long pageNo, int pageSize) {
		PageRequest paging = PageRequest.of((int) pageNo, pageSize);
		Page<GardShiftEntity> pagedResult =gardShiftDAOInt.findAll(paging);
		if(pagedResult.hasContent())
		{
			return pagedResult.getContent();
		}
		else
		{
			throw new DatabaseException("DataBase not found");
		}
	}

	@Override
	public List<GardShiftEntity> search(GardShiftEntity bean) {
		Optional<GardShiftEntity> gard = gardShiftDAOInt.findById(bean.getId());
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		GardShiftEntity newGard = gardShiftDAOInt.getById(bean.getId());
		List<GardShiftEntity> al = new ArrayList();
		al.add(newGard);
		return al;
	}

	}


