package com.cg.aps.dto;

import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

@Data
public class GardTraineeDto {
	
	private  long id;
	private String createdBy;
	private String modifiedBy;
	private Timestamp createdDateTime;
	private Timestamp modifiedDateTime;
	private long userId;
	private String name;
	private String mobileNo;
	private String status;
	private String timeing;
	private Date date;
	
	

}
