package com.cg.aps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.aps.entity.FlatEntity;
import com.cg.aps.entity.FlatRentEntity;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.FlatRentDAOInt;

@Service
public class FlatRentService implements FlatRentServiceInt {
	@Autowired
	private FlatRentDAOInt flatrentDAOint;

	@Override
	public long add(FlatRentEntity bean) {
		Optional<FlatRentEntity> flat =flatrentDAOint.findById(bean.getId());
		if (flat.isPresent()) {
			throw new DuplicateRecordException("Record already exists. No duplicate allowed");
		}
		flatrentDAOint.save(bean);
		return bean.getId();
	}

	@Override
	public void update(FlatRentEntity bean) {
		Optional<FlatRentEntity> flat = flatrentDAOint.findById(bean.getId());
		if (!flat.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		flatrentDAOint.save(bean);
	}

	@Override
	public void delete(FlatRentEntity bean) {
		Optional<FlatRentEntity> flat =flatrentDAOint.findById(bean.getId());
		if (!flat.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		flatrentDAOint.delete(bean);

	}

	@Override
	public FlatRentEntity findByPk(long id) {
		Optional<FlatRentEntity> flat = flatrentDAOint.findById(id);
		if (!flat.isPresent()) {
			throw new RecordNotFoundException("Record with the given ID is not found =" + id);
		}
		return flatrentDAOint.getById(id);

	}

	@Override
	public List<FlatRentEntity> search(FlatRentEntity bean) {
		Optional<FlatRentEntity> flat = flatrentDAOint.findById(bean.getId());
		if (!flat.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		FlatRentEntity newFlat = flatrentDAOint.getById(bean.getId());
		List<FlatRentEntity> al = new ArrayList();
		al.add(newFlat);
		return al;
	}

	@Override
	public FlatRentEntity findByName(String name) {
		FlatRentEntity flat = flatrentDAOint.findByOwnerName(name);
		if (flat == null) {
			throw new RecordNotFoundException("Record not found with given name found in the database = " + name);
		}
		return flatrentDAOint.findByOwnerName(name);
	}

	@Override
	public List<FlatRentEntity> search(FlatRentEntity bean, long pageNo, int pageSize) {
		PageRequest paging = PageRequest.of((int)pageNo,(int) pageSize);
		Page<FlatRentEntity> pagedResult =flatrentDAOint.findAll(paging);
		return pagedResult.getContent();
		
	}

}