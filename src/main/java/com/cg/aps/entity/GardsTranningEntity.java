package com.cg.aps.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GardsTranningEntity extends BaseEntity {

	@Positive(message = "Id can not be less than or equal to zero")
	private long userId;
	@NotBlank(message = "Gard name should not be emplty")
	private String name;
	@Size(min = 10, max = 10, message = "enter a valid mobileNo number")
	private String mobileNo;
	@NotBlank(message = "Status need to be updated")
	private String status;
	private String timeing;
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
