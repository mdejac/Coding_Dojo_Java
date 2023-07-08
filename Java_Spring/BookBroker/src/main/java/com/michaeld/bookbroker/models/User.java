package com.michaeld.bookbroker.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotBlank(message="First name can not be blank.")
	private String firstName;
	
	@NotBlank(message="Last name can not be blank.")
	private String lastName;
	
	@NotNull(message="Birthday is required.")
	@Past(message="Birthday must be in the past.")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;

	@NotEmpty(message="Email is required.")
	@Email(message="Please enter a valid email address.")
	private String email;
	
	@NotBlank(message="User name can not be blank.")
	@Size(min=3, max=15, message="User name must be at least three characters and no more then fifteen.")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "User name can only contain letters.")
	private String userName;

	@NotBlank(message="Password can not be blank.")
	@Size(min=8, message="Password must be at least eight characters.")
	private String password;
	
	@Transient
	@NotBlank(message="Confirm password can not be blank.")
	@Size(min=8, message="Confirm password must be ne at least eight characters.")
	private String confirmPassword;
	
	@OneToMany(mappedBy="postedBy", fetch=FetchType.LAZY)
	private List<Book> postedBooks;
	
	@OneToMany(mappedBy="borrowedBy", fetch=FetchType.LAZY)
	private List<Book> borrowedBooks;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public User() {}
	
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<Book> getPostedBooks() {
		return postedBooks;
	}

	public void setPostedBooks(List<Book> postedBooks) {
		this.postedBooks = postedBooks;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}	
}
