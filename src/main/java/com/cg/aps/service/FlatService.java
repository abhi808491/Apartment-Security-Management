package com.cg.aps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.FlatEntity;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.FlatDAOInt;

@Service
public class FlatService implements FlatServiceInt{
	@Autowired
	private FlatDAOInt flatDAOint;
	

	@Override
	public long add(FlatEntity bean) {
		Optional<FlatEntity> flat =flatDAOint.findById(bean.getId());
		if (flat.isPresent()) {
			throw new DuplicateRecordException("Record already exists. No duplicate allowed");
		}
		flatDAOint.save(bean);
		return bean.getId();
	}

	@Override
	public void update(FlatEntity bean) {
		Optional<FlatEntity> flat = flatDAOint.findById(bean.getId());
		if (!flat.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		flatDAOint.save(bean);
	}

	@Override
	public void delete(FlatEntity bean) {
		Optional<FlatEntity> flat =flatDAOint.findById(bean.getId());
		if (!flat.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		flatDAOint.delete(bean);

	}

	@Override
	public FlatEntity findByPk(long id) {
		Optional<FlatEntity> flat = flatDAOint.findById(id);
		if (!flat.isPresent()) {
			throw new RecordNotFoundException("Record with the given ID is not found =" + id);
		}
		return flatDAOint.getById(id);

	}

	@Override
	public List<FlatEntity> search(FlatEntity bean) {
		Optional<FlatEntity> flat = flatDAOint.findById(bean.getId());
		if (!flat.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		FlatEntity newFlat = flatDAOint.getById(bean.getId());
		List<FlatEntity> al = new ArrayList();
		al.add(newFlat);
		return al;
	}

	@Override
	public FlatEntity findByName(String name) {
		FlatEntity flat = flatDAOint.findByName(name);
		if (flat == null) {
			throw new RecordNotFoundException("Record not found with given name found in the database = " + name);
		}
		return flatDAOint.findByName(name);
	}

	@Override
	public List<FlatEntity> search(FlatEntity bean, long pageNo, int pageSize) {
		PageRequest paging = PageRequest.of((int)pageNo,(int) pageSize);
		Page<FlatEntity> pagedResult =flatDAOint.findAll(paging);
		return pagedResult.getContent();
		
	}

}