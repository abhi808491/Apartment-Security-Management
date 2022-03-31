package com.cg.aps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cg.aps.entity.FlatEntity;
import com.cg.aps.entity.GardTraineeEntity;
import com.cg.aps.entity.VisitorEntity;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.FlatDAOInt;
import com.cg.aps.repository.GardTraineeDAOInt;
import com.cg.aps.repository.VisitorDAOInt;

@Service
public class VisitorService implements VisitorServiceInt{
	
	@Autowired
	VisitorDAOInt visRepo;
	
	@Autowired 
	FlatDAOInt flatRepo;

	@Autowired 
	GardTraineeDAOInt gardRepo;

	@Override
	public long addVisitor(VisitorEntity visitor) {
		Optional<VisitorEntity> optional = visRepo.findById(visitor.getId());
		if(optional.isPresent()) {
			throw new DuplicateRecordException("Record is present");
		}
		visRepo.save(visitor);	
		return visitor.getId();
	}
	

	@Override
	public void updateVisitor(VisitorEntity visitor) {
		Optional<VisitorEntity> optional = visRepo.findById(visitor.getId());
		if(!optional.isPresent()) {
			throw new RecordNotFoundException("Record Not Present");
		}
		visRepo.save(visitor);
	}

	@Override
	public void deleteVisitor(VisitorEntity visitor) {
		Optional<VisitorEntity> optional = visRepo.findById(visitor.getId());
		if(!optional.isPresent()) {
			throw new RecordNotFoundException("Record Not Present");
		}
		visRepo.delete(visitor);
	}
	
	
	@Override
	public VisitorEntity findByPk(long id) {
		Optional<VisitorEntity> optional = visRepo.findById(id);
		if(!optional.isPresent()) {
			throw new RecordNotFoundException("Record Not Present");
		}
			return optional.get();
	}
	
	@Override
	public List<VisitorEntity> findByVisitorName(String name) {
		return visRepo.findByVisitorName(name);
	}

	

	@Override
	public List<VisitorEntity> search(Integer pageNo, Integer pageSize) {
		PageRequest paging = PageRequest.of(pageNo, pageSize);
		Page<VisitorEntity> pagedResult = visRepo.findAll(paging);
		if(pagedResult.hasContent()) {
			return pagedResult.getContent();
		}else {
			throw new RecordNotFoundException("No records Found");
		}
	}

	@Override
	public List<VisitorEntity> search(VisitorEntity visitor) {
		Optional<VisitorEntity> optional = visRepo.findById(visitor.getId());
		if(!optional.isPresent()) {
			throw new RecordNotFoundException("Record Not Present");
		}
		List<VisitorEntity> lis = new ArrayList<>();
		lis.add(this.findByPk(visitor.getId()));
		return lis;
	}


	@Override
	public List<VisitorEntity> getVisitorByFlatId(long id) {
		return visRepo.getVisitorByFlat(id);
	}

	@Override
	public VisitorEntity addFlatRelationship(long visitorPk, long flatPk) {
		VisitorEntity vis = visRepo.getById(visitorPk);
		FlatEntity fl = flatRepo.getById(flatPk);
		vis.setVisitor_flat(fl);
		visRepo.save(vis);
		return vis;
	}
	
	@Override
	public VisitorEntity addRelationship(long visitorPk, long gardPk, long flatPk) {
		VisitorEntity vis = visRepo.getById(visitorPk);
		GardTraineeEntity gar = gardRepo.getById(gardPk);
		FlatEntity fla = flatRepo.getById(flatPk);
		vis.setVisitor_flat(fla);
		vis.setGard_flat(gar);
		visRepo.save(vis);
		return vis;
	}


	@Override
	public List<VisitorEntity> getVisitorByGardId(long id) {
		return visRepo.getVisitorByGard(id);
	}
}
