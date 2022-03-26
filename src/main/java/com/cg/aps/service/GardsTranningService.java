package com.cg.aps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.entity.GardsTranningEntity;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.GardsTranningDAOInt;

@Service
public class GardsTranningService implements GardsTranningServiceInt {

	@Autowired
	GardsTranningDAOInt gardsTranningDAOInt;

	@Override
	public long add(GardsTranningEntity bean) {
		Optional<GardsTranningEntity> gard =gardsTranningDAOInt.findById(bean.getId());
		if (gard.isPresent()) {
			throw new DuplicateRecordException("Record is already exist there no duplicate allowed");
		}
		gardsTranningDAOInt.save(bean);
		// System.out.println(gard);
		// System.out.println(bean);
		return bean.getId();
	}

	@Override
	public void update(GardsTranningEntity bean) {
		Optional<GardsTranningEntity> gard = gardsTranningDAOInt.findById(bean.getId());
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		gardsTranningDAOInt.save(bean);
	}

	@Override
	public void delete(GardsTranningEntity bean) {
		Optional<GardsTranningEntity> gard =gardsTranningDAOInt.findById(bean.getId());
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		gardsTranningDAOInt.delete(bean);

	}

	@Override
	public GardsTranningEntity findByPk(long id) {
		Optional<GardsTranningEntity> gard = gardsTranningDAOInt.findById(id);
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record with the given ID is not found =" + id);
		}
		return gardsTranningDAOInt.getById(id);

	}

	@Override
	public List<GardsTranningEntity> search(GardsTranningEntity bean) {
		Optional<GardsTranningEntity> gard = gardsTranningDAOInt.findById(bean.getId());
		if (!gard.isPresent()) {
			throw new RecordNotFoundException("Record not found with given entity details");
		}
		GardsTranningEntity newGard = gardsTranningDAOInt.getById(bean.getId());
		List<GardsTranningEntity> al = new ArrayList();
		al.add(newGard);
		return al;
	}

	@Override
	public GardsTranningEntity getByName(String name) {
		GardsTranningEntity gard = gardsTranningDAOInt.findByName(name);
		if (gard == null) {
			throw new RecordNotFoundException("Record not found with given name found in the database = " + name);
		}
		return gardsTranningDAOInt.findByName(name);
	}

	@Override
	public List<GardsTranningEntity> search(GardsTranningEntity bean, long pageNo, int pageSize) {
		PageRequest paging = PageRequest.of((int)pageNo,(int) pageSize);
		Page<GardsTranningEntity> pagedResult =gardsTranningDAOInt.findAll(paging);
		return pagedResult.getContent();
		
	}

}
