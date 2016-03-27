package org.javabrains.maven.hibernate.FirstHibernateProject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Details")
public class UserDetails {
	private String address;
	// @Lob // for large object.
	private String description;
	// @Temporal(TemporalType.DATE) // To insert only date note timestamp
	private Date joinedDate;

	@Id	// creates primary key for this field
	@GeneratedValue	// generates automatic next sequence for userId
	// @Column(name = "user_id")
	private int userId;

	// @Column(name = "user_name")
	// @Transient // to skip this field.
	private String userName;

	public String getAddress() {
		return address;
	}

	public String getDescription() {
		return description;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
