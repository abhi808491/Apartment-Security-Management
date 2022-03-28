package com.cg.aps.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlatEntity extends BaseEntity
{
	private String ownerName;
	private String flatNo;
	private String floorNo;
	private String flatType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rent_id")
	FlatRentEntity flatrent;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_flatid")
	UserEntity user;
	
	@Override
	public String getKey() {
		
		return null;
	}

	@Override
	public String getValue() {
		
		return null;
	}
}
