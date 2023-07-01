package com.michaeld.relationships.models;

import java.util.Date;
import java.util.Random;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//...
@Entity
@Table(name="licenses")
public class License {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String number;
	@NotNull(message="Date cannot be null")
	@Future(message="Date must be in the future")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expirationDate;
	@NotBlank(message="State cannot be blank")
	@Size(min=2, max=2, message="State must be two characters")
	private String state;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="person_id")
	@NotNull(message="Must assign a person")
	private Person person;
	
	public License() {}
	
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
		Random r = new Random( System.currentTimeMillis() );
	    this.number = Integer.toString(10000 + r.nextInt(20000));
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}


