package com.cg.aps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.SecurityEntity;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.SecurityDAOInt;

@Service
public class SecurityService implements SecurityServiceInt {
	
	@Autowired
	SecurityDAOInt secRepo;

	@Override
	public long add(SecurityEntity bean) {
		Optional<SecurityEntity> a=secRepo.findById(bean.getId());
		if(a.isPresent())
		{
			throw new DuplicateRecordException("Record is present");
		}
		SecurityEntity de=secRepo.save(bean);
		return de.getId();	
	}
	

	@Override
	public void update(SecurityEntity bean) {
		Optional<SecurityEntity> opt = secRepo.findById(bean.getId());
		if(!opt.isPresent()) {
			throw new RecordNotFoundException("Record Not Present");
		}
		secRepo.save(bean);
	}

	@Override
	public void delete(SecurityEntity bean) {
		Optional<SecurityEntity> opt = secRepo.findById(bean.getId());
		if(!opt.isPresent()) {
			throw new RecordNotFoundException("Record Not Present");
		}
		secRepo.delete(bean);
		
	}

	@Override
	public SecurityEntity findByPk(long id) {
		Optional<SecurityEntity> opt = secRepo.findById(id);
		if(!opt.isPresent()) {
			throw new RecordNotFoundException("Record Not Present");
		}
		return opt.get();
	}

	@Override
	public List<SecurityEntity> search(SecurityEntity bean, long pageNo, int pageSize) {
		PageRequest paging = PageRequest.of((int) pageNo, pageSize);
		Page<SecurityEntity> pagedResult = secRepo.findAll(paging);
		if(pagedResult.hasContent())
		{
			return pagedResult.getContent();
		}
		else
		{
			throw new RecordNotFoundException("No records Found");
		}	
	}
	

	@Override
	public List<SecurityEntity> search(SecurityEntity bean) {
		Optional<SecurityEntity> opt = secRepo.findById(bean.getId());
		if(!opt.isPresent()) {
			throw new RecordNotFoundException("Record Not Present");
		}
		List<SecurityEntity> lis = new ArrayList<>();
		lis.add(this.findByPk(bean.getId()));
		return lis;
	}
	
	
	
}