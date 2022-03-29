package com.cg.aps.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

	private String firstName;
	
	private String lastName;
	
	private String loginId;
	
	private String password;
	
	private String mobileNo;
	
	private String emailId;

	private long roleId;
	
	//Relationship between User and Flat
		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinColumn(name="flat_id")
		@JsonIgnore

		private FlatEntity flat;
		
		
	   //Relationship between User and GardTrainee
		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinColumn(name="gard_id")
		@JsonIgnore
		
		private GardTraineeEntity gard;
		
		//  //Relationship between User and Vehicle
		
		@JsonIgnore
		@OneToOne(cascade= CascadeType.MERGE,fetch=FetchType.LAZY)
		@JoinColumn(name="vehicle_id",referencedColumnName="id")
		private VehicleEntity vehicleEntity;
		
		
	

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName;
	}
	}


