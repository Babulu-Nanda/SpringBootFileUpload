package com.example.demo;

import java.util.Date;

import jakarta.persistence. * ;



@Entity(name = "matmuseronboard")
public class MATMUserOnboard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "username", nullable=false, unique = true)
	private String username;

	@Column(name = "mobilenumber")
	private String mobilenumber;

	@Column(name = "merchantname")
	private String merchantname;

	@Column(name = "pannumber")
	private String pannumber;

	@Column(name = "district")
	private String district;
	
	@Column(name = "postalcode")
	private String postalcode;

	@Column(name = "state")
	private String state;

	@Column(name = "merchantid", unique = true)
	private String merchantid;

	@Column(name = "uniqueid")
	private String uniqueid;

	@Column(name = "companycode")
	private String companyCode;

	@Column(name = "referencenumber")
	private String referencenumber;

	@Column(name = "createddate")
	private Date createdDate;

	@Column(name = "updateddate")
	private Date updatedDate;

	@Column(name = "aadharfronturl")
	private String aadharFrontUrl;

	@Column(name = "aadharbackurl")
	private String aadharBackUrl;

	@Column(name = "panurl")
	private String panUrl;
	@Column(name = "onboardingstatus")
	private String onboardingStatus;
	@Column(name = "remarks")
	private String remarks;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getMerchantname() {
		return merchantname;
	}

	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	public String getPannumber() {
		return pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMerchantid() {
		return merchantid;
	}

	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}

	public String getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}

	public String getReferencenumber() {
		return referencenumber;
	}

	public void setReferencenumber(String referencenumber) {
		this.referencenumber = referencenumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getAadharFrontUrl() {
		return aadharFrontUrl;
	}

	public void setAadharFrontUrl(String aadharFrontUrl) {
		this.aadharFrontUrl = aadharFrontUrl;
	}

	public String getAadharBackUrl() {
		return aadharBackUrl;
	}

	public void setAadharBackUrl(String aadharBackUrl) {
		this.aadharBackUrl = aadharBackUrl;
	}

	public String getPanUrl() {
		return panUrl;
	}

	public void setPanUrl(String panUrl) {
		this.panUrl = panUrl;
	}

	public String getOnboardingStatus() {
		return onboardingStatus;
	}

	public void setOnboardingStatus(String onboardingStatus) {
		this.onboardingStatus = onboardingStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	@Override
	public String toString() {
		return "MATMUserOnboard [id=" + id + ", username=" + username + ", mobilenumber=" + mobilenumber
				+ ", merchantname=" + merchantname + ", pannumber=" + pannumber + ", district=" + district
				+ ", postalcode=" + postalcode + ", state=" + state + ", merchantid=" + merchantid + ", uniqueid="
				+ uniqueid + ", companyCode=" + companyCode + ", referencenumber=" + referencenumber + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", aadharFrontUrl=" + aadharFrontUrl
				+ ", aadharBackUrl=" + aadharBackUrl + ", panUrl=" + panUrl + ", onboardingStatus=" + onboardingStatus
				+ ", remarks=" + remarks + "]";
	}

}