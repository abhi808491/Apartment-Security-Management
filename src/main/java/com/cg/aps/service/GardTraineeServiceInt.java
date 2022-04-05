package com.cg.aps.service;

import java.util.List;

import com.cg.aps.dto.GardTraineeDto;
import com.cg.aps.entity.DeliveryEntity;
import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.entity.GardTraineeEntity;
import com.cg.aps.entity.SecurityEntity;
import com.cg.aps.entity.VehicleEntity;
import com.cg.aps.entity.VisitorEntity;

public interface GardTraineeServiceInt {

	public void update(GardTraineeEntity gardTrainee);

	public void delete(GardTraineeEntity gardTrainee);

	public GardTraineeEntity getByName(String name);

	public GardTraineeEntity findByPk(long id);

	public List<GardTraineeEntity> search(long pageNo, int pageSize);

	public List<GardTraineeEntity> search(GardTraineeEntity gardTrainee);

	public List<GardTraineeEntity> getAllGardTraineeByShiftId(long id);

	public GardTraineeEntity getGardBySalaryId(long id);

	public long addGard(GardTraineeEntity gardTrainee);

	public GardTraineeEntity mapShift(long gardPk, long shiftPk);

	public GardTraineeEntity mapSalary(long gardPk, long salaryPk);

	

}
