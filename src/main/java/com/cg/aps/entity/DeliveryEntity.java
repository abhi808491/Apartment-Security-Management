package com.cg.aps.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryEntity extends BaseEntity{
	
	
	private String ownerName;
	private String time;
	private Date date;
	private String status;
	@Override
	public String getKey() {
		return null;
	}
	@Override
	public String getValue() {
		return null;
	}
	
	
	
	
	

}
