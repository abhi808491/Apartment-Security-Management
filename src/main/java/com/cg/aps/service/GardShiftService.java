package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.GardShiftDAOInt;

@Service
public class GardShiftService implements GardShiftServiceInt {
	@Autowired
	GardShiftDAOInt gardShiftRepo;

	@Override
	public long add(GardShiftEntity bean) {
		Optional<GardShiftEntity> gard=gardShiftRepo.findById(bean.getId());
		if(gard.isPresent())
		{
			throw new DuplicateRecordException("Record is already exist there no duplicate allowed");
		}
		gardShiftRepo.save(bean);
		return bean.getId();
	}

	@Override
	public void update(GardShiftEntity bean) {
		Optional<GardShiftEntity> gard=gardShiftRepo.findById(bean.getId());
		if(!gard.isPresent())
		{
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		gardShiftRepo.save(bean);

	}

	@Override
	public void delete(GardShiftEntity bean) {
		Optional<GardShiftEntity> gard=gardShiftRepo.findById(bean.getId());
		if(!gard.isPresent())
		{
			throw new RecordNotFoundException("Record not found with given entity details");
		}
			gardShiftRepo.delete(bean);

	}

	@Override
	public GardShiftEntity getByName(String name) {
		GardShiftEntity gard=gardShiftRepo.getByName(name);
		if(gard==null)
		{
			throw new RecordNotFoundException("Record not found with given name found in the database = " +name);
		}
		return gardShiftRepo.getByName(name);
	}

	@Override
	public GardShiftEntity findByPk(long id) {
		Optional<GardShiftEntity> gard=gardShiftRepo.findById(id);
		if(!gard.isPresent())
		{
			throw new RecordNotFoundException("Record not found with given Id =" +id);
		}
		return gardShiftRepo.getById(id);
	}

	@Override
	public List<GardShiftEntity> search(GardShiftEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GardShiftEntity search(GardShiftEntity bean) {
		Optional<GardShiftEntity> gard=gardShiftRepo.findById(bean.getId());
		if(!gard.isPresent())
		{
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		return gardShiftRepo.getById(bean.getId());
	}

}
