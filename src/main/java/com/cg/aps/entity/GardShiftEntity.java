package com.cg.aps.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class GardShiftEntity extends BaseEntity {

	private long userId;
	@NotBlank(message = "Name should not be empty")
	private String name;
	@NotBlank(message = "Time should not be empty")
	private String time;
	private Date date;

	// relationship between gardShift and gard training
	@OneToMany(mappedBy = "gardShift", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<GardTraineeEntity> gardList;

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
