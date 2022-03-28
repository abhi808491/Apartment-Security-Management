package com.cg.aps.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GardTraineeEntity extends BaseEntity {

	@Positive(message = "Id can not be less than or equal to zero")
	private long userId;
	@NotBlank(message = "Gard name should not be emplty")
	private String name;
	@Size(min = 10, max = 10, message = "enter a valid mobileNo number")
	private String mobileNo;
	@NotBlank(message = "Status need to be updated")
	private String status;
	private String timeing;
	private Date date;

	// relationship between gardtraining and gardshift
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="shift_id")
	private GardShiftEntity gardShift;
	
	
	// relationship between gardtraining and gardsalary
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="salary_id")
	private GardSalaryEntity gardSalary;
	
	//relationship between gardtrainee and delivery
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "guard",cascade = CascadeType.MERGE)
	private List<DeliveryEntity> deliveryList;
	
	//relationship between gardtrainee and domesticHelp
	@JsonIgnore
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "guard",cascade = CascadeType.MERGE)
	private List<DomesticHelpEntity> domesticHelpList;
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
