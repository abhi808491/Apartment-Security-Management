package com.cg.aps.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryEntity extends BaseEntity {
	@NotBlank(message = "name should not be empty")
	private String ownerName;
	private String time;
	private Date date;
	private String status;

	// Relationship between Delivery to Flat
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "flat_id", referencedColumnName = "id")
	private FlatEntity flat;

	// Relationship between Delivery and guard
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "guard_trainee_id", referencedColumnName = "id")
	private GardTraineeEntity guardTrainee;

	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
