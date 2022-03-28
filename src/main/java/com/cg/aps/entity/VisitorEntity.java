package com.cg.aps.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Data

public class VisitorEntity extends BaseEntity {
	private Integer visitorId;
	private String visitorName;
	private Integer flatNo;
	private LocalDate arrivalDate;
	private LocalDate departureDate;
	private String ownerName;
	
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "flatid", referencedColumnName = "id")
	private FlatEntity visitor_flat;
	
	
	@Override
	public String getKey() {
		return null;
	}
	@Override
	public String getValue() {
		return null;
	}
}
