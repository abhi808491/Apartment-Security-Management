package com.cg.aps.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GardTraineeEntity extends BaseEntity {

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
	
//Relationship between user and gardTrainee
	@OneToOne(mappedBy="gard",cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonIgnore
	private UserEntity user;
	
	
	// relationship between gardtraining and gardshift
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="shift_id")
	@JsonIgnore
	private GardShiftEntity gardShift;
	
	
	// relationship between gardtraining and gardsalary
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="salary_id")
	@JsonIgnore
	private GardSalaryEntity gardSalary;
	

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
