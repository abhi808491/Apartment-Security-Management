package com.cg.aps.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.cg.aps.entity.BaseEntity;
import com.cg.aps.entity.FlatEntity;
import com.cg.aps.entity.UserEntity;
import com.cg.aps.entity.VehicleEntity;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.FlatDAOInt;
import com.cg.aps.repository.VehicleRepository;
@Service
public class VehicleService implements VehicleServiceInt{
	
	@Autowired
	VehicleRepository vehRepo;
	
	
	@Autowired
	 FlatDAOInt flatDAOint;
	
	@Override
	public long add(VehicleEntity bean) {
	
		Optional<VehicleEntity> a=vehRepo.findById(bean.getId());
		if(a.isPresent())
		{
			throw new DuplicateRecordException("Record is present");
		}
		return vehRepo.save(bean).getId();
	}

	@Override
	public void update(VehicleEntity bean) {
		VehicleEntity veh = vehRepo.save(bean);
		
		veh.setVehicle_name(veh.getVehicle_name());
		veh.setParkingNo(veh.getParkingNo());
		veh.setArrivalTime(veh.getArrivalTime());
		veh.setDate(veh.getDate());
		veh.setDepartureTime(veh.getDepartureTime());
		veh.setVehicleNo(veh.getVehicleNo());
		veh.setVehicleType(veh.getVehicleType());
		vehRepo.save(veh);
	}

	@Override
	public void delete(VehicleEntity bean) {
		Optional<VehicleEntity> VehicleEntity=vehRepo.findById(bean.getId());
		if(!VehicleEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Present");
		}
		vehRepo.delete(VehicleEntity.get());
	}
		

	@Override
	public VehicleEntity findByName(String name) {
		
		return vehRepo.findByAttName(name);
	}

	@Override
	public VehicleEntity findByPk(long id) {
		Optional<VehicleEntity> VehicleEntity = vehRepo.findById(id);
		if(!VehicleEntity.isPresent()) {
			throw new RecordNotFoundException("Record Not Present");
		}
		return VehicleEntity.get();
		
	}


	public List<VehicleEntity> search(long pageNo, int pageSize) {
		PageRequest paging=PageRequest.of((int) pageNo, pageSize);
		Page<VehicleEntity> res=vehRepo.findAll(paging);
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
	public List<VehicleEntity> search(VehicleEntity bean) {
		
		Optional<VehicleEntity> VehicleEntity=vehRepo.findById(bean.getId());
		if(!VehicleEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Found");
		}
		List<VehicleEntity> v =new ArrayList();
		v.add(this.findByPk(bean.getId()));
		return v;
	}

	@Override
	public List<VehicleEntity> search(VehicleEntity bean, long pageNo, int pageSize) {
		
		return null;
	}


	@Override
	public List<VehicleEntity> getVehicleByFlatId(Long flatId) {
		return vehRepo.getVehicleOfFlat(flatId);
		}

	@Override
	public VehicleEntity addVehicle(long vehiclePk, long flatPk) {
		
		VehicleEntity vehicle=vehRepo.getById(vehiclePk);
		FlatEntity flat=flatDAOint.getById(flatPk);
		 vehicle.setFlat(flat);
		 vehRepo.save(vehicle);
		 return vehicle;
	}

}
