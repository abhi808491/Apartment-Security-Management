package com.cg.aps.entity;

import javax.persistence.Entity;

import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlatRentEntity extends BaseEntity 
{
	private String ownerName;
	private String flatNo;
	private String amount;
	private String type;

	@OneToOne(mappedBy="flatrent")
	FlatEntity flatEntity;
	
	@Override
	public String getKey() {
		
		return "Key";
	}

	@Override
	public String getValue() {
		
		return "Value";
	}
}
