package com.cg.aps.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityEntity extends BaseEntity{
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "gardid", referencedColumnName = "id")
	private GardTraineeEntity security_gard;
	
	private String message;
	private String alert;

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
