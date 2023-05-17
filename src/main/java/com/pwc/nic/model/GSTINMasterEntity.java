package com.pwc.nic.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "ewb_cusdb.demo.gstin_master")
@Table(name = "demo.gstin_master") //SwitchSamsungDB
public class GSTINMasterEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "gstin_id")
	private Integer gstinId;
	@Column(name = "company_id")
	private Integer companyId;
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "state")
	private String state;
	@Column(name = "gstin")
	private String gstin;
	@Column(name = "is_sez_unit")
	private String isSezUnit;
	@Column(name = "irn_user_name")
	private String IrnUserName;
	@Column(name = "irn_password")
	private String IrnPassword;
	@Column(name = "authorised_signatory_name")
	private String authorisedSignatoryName;
	@Column(name = "phone_no")
	private String phoneNo;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "created_date")
	private Timestamp createdDate;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "updated_date")
	private Timestamp updatedDate;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "active")
	private String active;
	@Column(name = "source")
	private String source;
	@Column(name = "comments")
	private String comments;

	public GSTINMasterEntity() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGstinId() {
		return gstinId;
	}

	public void setGstinId(Integer gstinId) {
		this.gstinId = gstinId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getIsSezUnit() {
		return isSezUnit;
	}

	public void setIsSezUnit(String isSezUnit) {
		this.isSezUnit = isSezUnit;
	}

	public String getAuthorisedSignatoryName() {
		return authorisedSignatoryName;
	}

	public void setAuthorisedSignatoryName(String authorisedSignatoryName) {
		this.authorisedSignatoryName = authorisedSignatoryName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getIrnUserName() {
		return IrnUserName;
	}

	public void setIrnUserName(String irnUserName) {
		IrnUserName = irnUserName;
	}

	public String getIrnPassword() {
		return IrnPassword;
	}

	public void setIrnPassword(String irnPassword) {
		IrnPassword = irnPassword;
	}
}
