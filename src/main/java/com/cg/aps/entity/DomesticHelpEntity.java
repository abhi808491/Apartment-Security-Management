/**
 * 
 */
package com.cg.aps.entity;
import java.util.Date;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author grishith
 *
 */
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
	@Override
	public String getKey() {
		return null;
	}
	@Override
	public String getValue() {
		return null;
	}
	
}
