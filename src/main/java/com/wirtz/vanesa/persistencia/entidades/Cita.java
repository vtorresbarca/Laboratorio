package com.wirtz.vanesa.persistencia.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cita {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_cita")
	private int id;
	
	@Column(name = "start_date", columnDefinition="DATETIME")
	private Date start_date;

	@Column(name = "end_date", columnDefinition="DATETIME")
	private Date end_date;
	
	private String text;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private MyUser user;
	
	public Cita() {
		
	}

	public Cita(int id, Date start_date, Date end_date, String text) {
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

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
	
	
}
