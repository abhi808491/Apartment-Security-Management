package com.cg.aps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.GardSalaryEntity;
import com.cg.aps.entity.GardShiftEntity;
import com.cg.aps.repository.GardSalaryDAOInt;

@Service
public class GardSalaryService implements GardSalaryServiceInt {

	@Autowired
	GardSalaryDAOInt gardSalaryRepo;

	@Override
	public long add(GardSalaryEntity bean) {
		gardSalaryRepo.save(bean);
		return bean.getId();
	}

	@Override
	public void update(GardSalaryEntity bean) {
		GardSalaryEntity gard = gardSalaryRepo.getById(bean.getId());
		if (gard != null) {
			gardSalaryRepo.save(bean);
		}

	}

	@Override
	public void delete(GardSalaryEntity bean) {
		GardSalaryEntity gard = gardSalaryRepo.getById(bean.getId());
		if (gard != null) {
			gardSalaryRepo.delete(gard);
		}

	}

	@Override
	public GardSalaryEntity findByName(String name) {
		return gardSalaryRepo.findByName(name);
	}

	@Override
	public GardSalaryEntity findByPk(long id) {
		return gardSalaryRepo.getById(id);
	}

	@Override
	public List<GardSalaryEntity> search(GardSalaryEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GardSalaryEntity search(GardSalaryEntity bean) {
		return gardSalaryRepo.getById(bean.getId());
	}

}
