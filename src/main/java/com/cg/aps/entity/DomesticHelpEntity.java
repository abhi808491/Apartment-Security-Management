
package com.cg.aps.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DomesticHelpEntity extends BaseEntity {

	@NotBlank(message = "name should not be empty")
	private String name;
	private String helpType;
	private String arrivalTime;
	private String departureTime;
	private Date date;

	// Relationship between domesticHelp and flat
	@JsonIgnore
	@OneToMany(mappedBy = "domesticHelpList", cascade = CascadeType.MERGE)
	private List<FlatEntity> flatDomesticHelp;

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
