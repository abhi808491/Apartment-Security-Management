package com.cg.aps.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lombok.Data;

//@Entity
@Data
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy= InheritanceType.JOINED)
@MappedSuperclass
public abstract class Person implements DropdownList{
	
	@Id
	@GeneratedValue
	private int id;
	private String email;
	private LocalDate dob;

}
