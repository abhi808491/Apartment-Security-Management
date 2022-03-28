package com.cg.aps.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryEntity extends BaseEntity {
	@NotBlank(message = "name should not be emplty")
	private String ownerName;
	private String time;
	private Date date;
	private String status;
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "flat_id", referencedColumnName = "id")
	private FlatEntity flat;
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="guard_id",referencedColumnName="id")
	private GardTraineeEntity guard;
	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
