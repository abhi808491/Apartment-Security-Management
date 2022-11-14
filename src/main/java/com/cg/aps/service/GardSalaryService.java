package com.cg.aps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.GardSalaryEntity;
import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.exception.DatabaseException;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.GardSalaryDAOInt;

@Service
public class GardSalaryService implements GardSalaryServiceInt {

	@Autowired
	GardSalaryDAOInt gardSalaryDAOInt;

	// method to add salary
	@Override
	public long add(GardSalaryEntity bean) {
		Optional<GardSalaryEntity> gard = gardSalaryDAOInt.findById(bean.getId());
		if (gard.isPresent()) {
			throw new DuplicateRecordException("Record is already exist there no duplicate allowed");
		}
		gardSalaryDAOInt.save(bean);
		return bean.getId();
	}

	// method to update salary
	@Override
	public void update(GardSalaryEntity bean) {
		Optional<GardSalaryEntity> gard = gardSalaryDAOInt.findById(bean.getId());
		if (!gard.isPresent()) {
			throw new DuplicateRecordException("Record is already exist there no duplicate allowed");
		}
		gardSalaryDAOInt.save(bean);

	}

	// method to delete salary
	@Override
	public void delete(GardSalaryEntity bean) {
		Optional<GardSalaryEntity> gard = gardSalaryDAOInt.findById(bean.getId());
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		gardSalaryDAOInt.delete(bean);

	}

	// method to find by name
	@Override
	public GardSalaryEntity findByName(String name) {
		GardSalaryEntity gard = gardSalaryDAOInt.findByName(name);
		if (gard == null) {
			throw new RecordNotFoundException("Record not found with given name found in the database = " + name);
		}
		return gardSalaryDAOInt.findByName(name);
	}

	// method to find by primary key
	@Override
	public GardSalaryEntity findByPk(long id) {
		Optional<GardSalaryEntity> gard = gardSalaryDAOInt.findById(id);
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record not found with given Id =" + id);
		}
		return gardSalaryDAOInt.getById(id);
	}

	// method to get paging
	@Override
	public List<GardSalaryEntity> search(long pageNo, int pageSize) {
		PageRequest paging = PageRequest.of((int) pageNo, pageSize);
		Page<GardSalaryEntity> pagedResult = gardSalaryDAOInt.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			throw new RecordNotFoundException("DataBase not found");
		}
	}

	// method to search salary using object
	@Override
	public List<GardSalaryEntity> search(GardSalaryEntity bean) {
		Optional<GardSalaryEntity> gard = gardSalaryDAOInt.findById(bean.getId());
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		GardSalaryEntity newGard = gardSalaryDAOInt.getById(bean.getId());
		List<GardSalaryEntity> al = new ArrayList();
		al.add(newGard);
		return al;
	}

}
