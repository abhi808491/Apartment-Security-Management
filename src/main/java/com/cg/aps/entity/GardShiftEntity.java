package com.cg.aps.entity;





import java.util.Date;

import javax.persistence.Entity;
import lombok.Data;
@Data
@Entity
public class GardShiftEntity extends BaseEntity {

	private long userId;
	private String name;
	private String time;
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
