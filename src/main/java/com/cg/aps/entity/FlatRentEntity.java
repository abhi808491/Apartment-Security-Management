package com.cg.aps.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	FlatEntity flat;

	
	//relationship between flatRent and User
	@OneToOne(mappedBy="flatrent",cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private UserEntity user;
	
	@Override
	public String getKey() {
		
		return "Key";
	}

	@Override
	public String getValue() {
		
		return "Value";
	}
}
