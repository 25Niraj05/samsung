package com.pwc.nic.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DecryptResponseMapper {
	private long ewbNo;
	private String ewayBillDate;
	private String genMode;
	private String userGstin;
	private String supplyType;
	private String subSupplyType;
	private String docType;
	private String docNo;
	private String docDate;
	private String fromGstin;
	private String fromTrdName;
	private String fromAddr1;
	private String fromAddr2;
	private String fromPlace;
	private String fromPincode;
	private String fromStateCode;
	private String toGstin;
	private String toTrdName;
	private String toAddr1;
	private String toAddr2;
	private String toPlace;
	private String toPincode;
	private String toStateCode;
	private BigDecimal totalValue;
	private BigDecimal totInvValue;
	private BigDecimal cgstValue;
	private BigDecimal sgstValue;
	private BigDecimal igstValue;
	private BigDecimal cessValue;
	private String transporterId;
	private String transporterName;
	private String transDocNo;
	private String transMode;
	private String transDocDate;
	private String status;
	private Integer actualDist;
	private Integer noValidDays;
	private String validUpto;
	private Integer extendedTimes;
	private String rejectStatus;
	private String vehicleType;
	private String actFromStateCode;
	private String actToStateCode;
	private Object itemList;
	private Object VehiclListDetails;
	
	public long getEwbNo() {
		return ewbNo;
	}
	public void setEwbNo(long ewbNo) {
		this.ewbNo = ewbNo;
	}
	public String getEwayBillDate() {
		return ewayBillDate;
	}
	public void setEwayBillDate(String ewayBillDate) {
		this.ewayBillDate = ewayBillDate;
	}
	public String getGenMode() {
		return genMode;
	}
	public void setGenMode(String genMode) {
		this.genMode = genMode;
	}
	public String getUserGstin() {
		return userGstin;
	}
	public void setUserGstin(String userGstin) {
		this.userGstin = userGstin;
	}
	public String getSupplyType() {
		return supplyType;
	}
	public void setSupplyType(String supplyType) {
		this.supplyType = supplyType;
	}
	public String getSubSupplyType() {
		return subSupplyType;
	}
	public void setSubSupplyType(String subSupplyType) {
		this.subSupplyType = subSupplyType;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getDocDate() {
		return docDate;
	}
	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}
	public String getFromGstin() {
		return fromGstin;
	}
	public void setFromGstin(String fromGstin) {
		this.fromGstin = fromGstin;
	}
	public String getFromTrdName() {
		return fromTrdName;
	}
	public void setFromTrdName(String fromTrdName) {
		this.fromTrdName = fromTrdName;
	}
	public String getFromAddr1() {
		return fromAddr1;
	}
	public void setFromAddr1(String fromAddr1) {
		this.fromAddr1 = fromAddr1;
	}
	public String getFromAddr2() {
		return fromAddr2;
	}
	public void setFromAddr2(String fromAddr2) {
		this.fromAddr2 = fromAddr2;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getFromPincode() {
		return fromPincode;
	}
	public void setFromPincode(String fromPincode) {
		this.fromPincode = fromPincode;
	}
	public String getFromStateCode() {
		return fromStateCode;
	}
	public void setFromStateCode(String fromStateCode) {
		this.fromStateCode = fromStateCode;
	}
	public String getToGstin() {
		return toGstin;
	}
	public void setToGstin(String toGstin) {
		this.toGstin = toGstin;
	}
	public String getToTrdName() {
		return toTrdName;
	}
	public void setToTrdName(String toTrdName) {
		this.toTrdName = toTrdName;
	}
	public String getToAddr1() {
		return toAddr1;
	}
	public void setToAddr1(String toAddr1) {
		this.toAddr1 = toAddr1;
	}
	public String getToAddr2() {
		return toAddr2;
	}
	public void setToAddr2(String toAddr2) {
		this.toAddr2 = toAddr2;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public String getToPincode() {
		return toPincode;
	}
	public void setToPincode(String toPincode) {
		this.toPincode = toPincode;
	}
	public String getToStateCode() {
		return toStateCode;
	}
	public void setToStateCode(String toStateCode) {
		this.toStateCode = toStateCode;
	}
	public BigDecimal getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}
	public BigDecimal getCgstValue() {
		return cgstValue;
	}
	public void setCgstValue(BigDecimal cgstValue) {
		this.cgstValue = cgstValue;
	}
	public BigDecimal getSgstValue() {
		return sgstValue;
	}
	public void setSgstValue(BigDecimal sgstValue) {
		this.sgstValue = sgstValue;
	}
	public BigDecimal getIgstValue() {
		return igstValue;
	}
	public void setIgstValue(BigDecimal igstValue) {
		this.igstValue = igstValue;
	}
	public BigDecimal getCessValue() {
		return cessValue;
	}
	public void setCessValue(BigDecimal cessValue) {
		this.cessValue = cessValue;
	}
	public String getTransporterId() {
		return transporterId;
	}
	public void setTransporterId(String transporterId) {
		this.transporterId = transporterId;
	}
	public String getTransporterName() {
		return transporterName;
	}
	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}
	public String getTransDocNo() {
		return transDocNo;
	}
	public void setTransDocNo(String transDocNo) {
		this.transDocNo = transDocNo;
	}
	public String getTransMode() {
		return transMode;
	}
	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}
	public String getTransDocDate() {
		return transDocDate;
	}
	public void setTransDocDate(String transDocDate) {
		this.transDocDate = transDocDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getActualDist() {
		return actualDist;
	}
	public void setActualDist(Integer actualDist) {
		this.actualDist = actualDist;
	}
	public Integer getNoValidDays() {
		return noValidDays;
	}
	public void setNoValidDays(Integer noValidDays) {
		this.noValidDays = noValidDays;
	}
	public String getValidUpto() {
		return validUpto;
	}
	public void setValidUpto(String validUpto) {
		this.validUpto = validUpto;
	}
	public Integer getExtendedTimes() {
		return extendedTimes;
	}
	public void setExtendedTimes(Integer extendedTimes) {
		this.extendedTimes = extendedTimes;
	}
	public String getRejectStatus() {
		return rejectStatus;
	}
	public void setRejectStatus(String rejectStatus) {
		this.rejectStatus = rejectStatus;
	}
	public Object getItemList() {
		return itemList;
	}
	public void setItemList(Object itemList) {
		this.itemList = itemList;
	}
	public Object getVehiclListDetails() {
		return VehiclListDetails;
	}
	@JsonProperty("VehiclListDetails")
	public void setVehiclListDetails(Object vehiclListDetails) {
		VehiclListDetails = vehiclListDetails;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getActFromStateCode() {
		return actFromStateCode;
	}
	public void setActFromStateCode(String actFromStateCode) {
		this.actFromStateCode = actFromStateCode;
	}
	public String getActToStateCode() {
		return actToStateCode;
	}
	public void setActToStateCode(String actToStateCode) {
		this.actToStateCode = actToStateCode;
	}
	public BigDecimal getTotInvValue() {
		return totInvValue;
	}
	public void setTotInvValue(BigDecimal totInvValue) {
		this.totInvValue = totInvValue;
	}
}
