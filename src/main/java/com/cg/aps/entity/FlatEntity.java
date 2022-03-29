package com.cg.aps.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class FlatEntity extends BaseEntity
{
	private String name;
	private String flatNo;
	private String floorNo;
	private String flatType;
	
	@OneToOne(mappedBy="flat",cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonIgnore
	private UserEntity user;
	
	@Override
	public String getKey() {
		
		return null;
	}

	@Override
	public String getValue() {
		
		return null;
	}
}
