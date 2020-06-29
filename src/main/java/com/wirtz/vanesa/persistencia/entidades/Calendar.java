package com.wirtz.vanesa.persistencia.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Calendar {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "start_date", columnDefinition="DATETIME")
	private Date start_date;
	
	@Column(name = "end_date", columnDefinition="DATETIME")
	private Date end_date;
	private String text;
}
