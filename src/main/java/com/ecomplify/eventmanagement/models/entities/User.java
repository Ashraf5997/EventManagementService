package com.ecomplify.eventmanagement.models.entities;

import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "app_user")
@Where(clause="DELETED='N'")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "app_user_id")
	private Long appuserid;	
	@Column(name = "full_name")
	private String fullname;
	@Column(name = "email_id")
	private String emailid;
	@Column(name = "emp_id_number")
	private Long empid;
	@Column(name = "date_of_birth")
	private LocalDateTime dateofbirth;
	@Column(name = "contact_number")
	private Long contactnumber;
	@Column(name = "experience")
	private String experience;
	@Column(name = "gender")
	private String gender;
	@Column(name = "address")
	private String address;
	@Column(name = "created_by")
	private String createdby;
	@Column(name = "created_on")
	private LocalDateTime createdon;
	@Column(name = "last_modify_by")
	private String modifyby;
	@Column(name = "last_modify_on")
	private LocalDateTime modifiedon;
	@Column(name = "deleted")
	private String deleted;
	public Long getAppuserid() {
		return appuserid;
	}
	public void setAppuserid(Long appuserid) {
		this.appuserid = appuserid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public Long getEmpid() {
		return empid;
	}
	public void setEmpid(Long empid) {
		this.empid = empid;
	}
	public LocalDateTime getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(LocalDateTime dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public Long getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(Long contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public LocalDateTime getCreatedon() {
		return createdon;
	}
	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}
	public String getModifyby() {
		return modifyby;
	}
	public void setModifyby(String modifyby) {
		this.modifyby = modifyby;
	}
	public LocalDateTime getModifiedon() {
		return modifiedon;
	}
	public void setModifiedon(LocalDateTime modifiedon) {
		this.modifiedon = modifiedon;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	

}
