package com.cg.aps.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
@Entity
public class GardSalaryEntity extends BaseEntity {

	@NotBlank(message = "Name should not be empty")
	private String name;
	@Positive(message = "Id can not be less than or equal to zero")
	private String userId;
	@Positive(message = "Salary can not be less than or equal to zero")
	private long amount;
	@NotBlank(message = "Status should not be empty")
	private String status;
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
