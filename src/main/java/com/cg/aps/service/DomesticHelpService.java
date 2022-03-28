package com.cg.aps.service;

import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.DomesticHelpDAOInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class DomesticHelpService implements DomesticHelpServiceInt{
	@Autowired
	DomesticHelpDAOInt domesticHelpDAOInt;
	
	@Override
	public long add(DomesticHelpEntity bean) {
		Optional<DomesticHelpEntity> a= domesticHelpDAOInt.findById(bean.getId());
		if(a.isPresent())
		{
			throw new DuplicateRecordException("Record is already present with id "+bean.getId());
		}
		return  domesticHelpDAOInt.save(bean).getId();
	}

	@Override
	public void update(DomesticHelpEntity bean) {
		Optional<DomesticHelpEntity> domesticHelpEntity =  domesticHelpDAOInt.findById(bean.getId());
		if(!domesticHelpEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Found with id "+bean.getId());
		}
		 domesticHelpDAOInt.save(bean);
		
	}

	@Override
	public void delete(DomesticHelpEntity bean) {
		Optional<DomesticHelpEntity> domesticHelpEntity=  domesticHelpDAOInt.findById(bean.getId());
		if(!domesticHelpEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Found with id "+bean.getId());
		}
		 domesticHelpDAOInt.delete(domesticHelpEntity.get());
	}

	@Override
	public List<DomesticHelpEntity> findByName(String name) {
		List<DomesticHelpEntity> domesticHelpEntity=domesticHelpDAOInt.findByOwnerName(name);
		if(domesticHelpEntity==null)
		{
			throw new RecordNotFoundException("Record Not Found with Name "+name);
		}
		return   domesticHelpEntity;
	}

	@Override
	public DomesticHelpEntity findByPk(long id) {
		Optional<DomesticHelpEntity> domestichelpEntity= domesticHelpDAOInt.findById(id);
		if(! domestichelpEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Found with id "+id);
		}
		return  domestichelpEntity.get();
	}

	@Override
	public List<DomesticHelpEntity> search(long pageNo, int pageSize) {
		PageRequest paging=PageRequest.of((int) pageNo, pageSize);
		Page<DomesticHelpEntity> res= domesticHelpDAOInt.findAll(paging);
		if(res.hasContent())
		{
			return res.getContent();
		}
		else
		{
			throw new RecordNotFoundException("No records Found");
		}	
		
	}

	@Override
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean) {
		Optional<DomesticHelpEntity> domesticHelpEntity =  domesticHelpDAOInt.findById(bean.getId());
		if(!domesticHelpEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Found with id "+bean.getId());
		}
		List<DomesticHelpEntity> d = new ArrayList<>();
		d.add(this.findByPk(bean.getId()));
		return d;
	}

	@Override
	public List<DomesticHelpEntity> getDomesticHelpListByFlat(long id) {
		// TODO Auto-generated method stub
		return domesticHelpDAOInt.getDomesticHelpListByFlat(id);
	}

	@Override
	public List<DomesticHelpEntity> getDomesticHelpListByGuard(long id) {
		// TODO Auto-generated method stub
		return domesticHelpDAOInt.getDomesticHelpsByGuardId(id);
	}

	

}
