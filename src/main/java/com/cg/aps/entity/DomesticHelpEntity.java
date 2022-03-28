
package com.cg.aps.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DomesticHelpEntity extends BaseEntity{
	private String flatNo;
	private String ownerName;
	private String name;
	private String helpType;
	private String arrivalTime;
	private String departureTime;
	private Date date;
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "flat_id", referencedColumnName = "id")
	private FlatEntity flat;
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "guard_id", referencedColumnName = "id")
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
