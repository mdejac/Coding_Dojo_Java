package com.michaeld.bookbroker.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@NotBlank
    @Size(min = 5, max = 200, message="Title must be at least 5 characters and less than 200.")
    private String title;
    
    @NotBlank
    @Size(min = 3, max = 40, message="Author name must be at least 3 characters and less than 40.")
    private String author;
    
    @NotBlank
    @Size(min = 5, message="Description must be at least five characters.")
    @Column(columnDefinition="TEXT")
    private String description;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
    private User postedBy;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="borrower_id")
    private User borrowedBy;
	
    @Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Book() {}
	
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
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

	public User getBorrowedBy() {
		return borrowedBy;
	}

	public void setBorrowedBy(User borrowedBy) {
		this.borrowedBy = borrowedBy;
	}	
}
