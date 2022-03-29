package com.cg.aps.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlatEntity extends BaseEntity {

	private String ownerName;
	private String flatNo;
	private String floorNo;
	private String flatType;
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "flat",cascade = CascadeType.MERGE)
	private List<DeliveryEntity> deliveries;
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "flat",cascade = CascadeType.MERGE)
	private List<DomesticHelpEntity> domesticHelp;

	@OneToMany(mappedBy = "visitor_flat",cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<VisitorEntity> visitorEntity;
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
