package com.cg.aps.entity;


import java.util.Date;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GardsTranningEntity extends BaseEntity {

	private long userId;
	private String name;
	private String mobileNo;
	private String status;
	private String timeing;
	private Date date;

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
