package com.cg.aps.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

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
