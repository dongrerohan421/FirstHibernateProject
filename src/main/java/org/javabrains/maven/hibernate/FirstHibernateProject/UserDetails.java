package org.javabrains.maven.hibernate.FirstHibernateProject;

//import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Details")
public class UserDetails {
	@Embedded	// tells this object is embedded.
	@AttributeOverrides({ 
		@AttributeOverride(column = @Column(name = "HOME_STREET_NAME"), name = "street"),
		@AttributeOverride(column = @Column(name = "HOME_CITY_NAME"), name = "city"),
		@AttributeOverride(column = @Column(name = "HOME_STATE_NAME"), name = "state"),
		@AttributeOverride(column = @Column(name = "HOME_PIN_CODE"), name = "pincode")
	})
	private Address homeAddress;
	@Embedded
	@AttributeOverrides({ 
		@AttributeOverride(column = @Column(name = "OFFICE_STREET_NAME"), name = "street"),
		@AttributeOverride(column = @Column(name = "OFFICE_CITY_NAME"), name = "city"),
		@AttributeOverride(column = @Column(name = "OFFICE_STATE_NAME"), name = "state"),
		@AttributeOverride(column = @Column(name = "OFFICE_PIN_CODE"), name = "pincode")
	})
	private Address officeAddress;
	// @Lob // for large object.
	//private String description;
	// @Temporal(TemporalType.DATE) // To insert only date note timestamp
	//private Date joinedDate;

	@Id	// creates primary key for this field
	@GeneratedValue	// generates automatic next sequence for userId
	// @Column(name = "user_id")
	private int userId;

	// @Column(name = "user_name")
	// @Transient // to skip this field.
	private String userName;

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
