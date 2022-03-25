package com.cg.aps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.entity.GardsTranningEntity;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.GardsTranningDAOInt;

@Service
public class GardsTranningService implements GardsTranningServiceInt {

	@Autowired
	GardsTranningDAOInt gardsTranningRepo;
	@Override
	public long add(GardsTranningEntity bean) {
		Optional<GardsTranningEntity> gard=gardsTranningRepo.findById(bean.getId());
		if(gard.isPresent())
		{
			throw new DuplicateRecordException("Record is already exist there no duplicate allowed");
		}
		gardsTranningRepo.save(bean);
		//System.out.println(gard);
		//System.out.println(bean);
		return bean.getId();
		}

	@Override
	public void update(GardsTranningEntity bean) 
	{
		Optional<GardsTranningEntity> gard=gardsTranningRepo.findById(bean.getId());
		if(!gard.isPresent())
		{
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		gardsTranningRepo.save(bean);
	}

	@Override
	public void delete(GardsTranningEntity bean) {
		Optional<GardsTranningEntity> gard=gardsTranningRepo.findById(bean.getId());
		if(!gard.isPresent())
		{
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		gardsTranningRepo.delete(bean);
		
	}

	

	@Override
	public GardsTranningEntity findByPk(long id) {
		Optional<GardsTranningEntity> gard=gardsTranningRepo.findById(id);
		if(!gard.isPresent())
		{
			throw new RecordNotFoundException("Record with the given ID is not found ="+ id);
		}
		return gardsTranningRepo.getById(id);
		
	}
	@Override
	public GardsTranningEntity search(GardsTranningEntity bean) {
		Optional<GardsTranningEntity> gard=gardsTranningRepo.findById(bean.getId());
		if(!gard.isPresent())
		{
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		return gardsTranningRepo.getById(bean.getId());
	}

	@Override
	public GardsTranningEntity getByName(String name) {
		GardsTranningEntity gard=gardsTranningRepo.getByName(name);
		if(gard==null)
		{
			throw new RecordNotFoundException("Record not found with given name found in the database = " +name);
		}
		return gardsTranningRepo.getByName(name);
	}


	@Override
	public List<GardsTranningEntity> search(GardsTranningEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
