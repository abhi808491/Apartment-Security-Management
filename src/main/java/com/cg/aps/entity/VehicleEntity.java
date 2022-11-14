package com.cg.aps.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleEntity extends BaseEntity {

	private String vehicle_name; 
	private String parkingNo;
	private String arrivalTime;
	private String departureTime;
	private Date date;
	private String vehicleNo;
	private String vehicleType;

	@ManyToOne(cascade= CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name="flat_id",referencedColumnName="id")
	@JsonIgnore
	private FlatEntity flat;
	
	@ManyToOne(cascade= CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name="gard_id",referencedColumnName="id")
	@JsonIgnore
	private GardTraineeEntity trainee;

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