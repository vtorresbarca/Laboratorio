package com.wirtz.vanesa.vista.dto.cita;

import java.util.Date;

public class CitaDto {

	private int id;
	private Date start_date;
	private Date end_date;
	private String text;
	
	public CitaDto() {
		
	}

	public CitaDto(int id, Date start_date, Date end_date, String text) {
		super();
		this.id = id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
