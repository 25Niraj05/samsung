package com.pwc.nic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
//@Table(schema = "ewb_cusdb.demo", name = "ewb_vehicle_details")
@Table(schema = "demo", name = "ewb_vehicle_details") //SwitchSamsungDB
public class EWBVehicleDetailsEntity {

	@Id
//	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="ewb_cusdb.demo.ewb_vehicle_details_id_seq",
//		name="ewb_cusdb.demo.ewb_vehicle_details_id_seq")
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="demo.ewb_vehicle_details_id_seq",
	name="demo.ewb_vehicle_details_id_seq") //SwitchSamsungDB
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private Integer id;
	
	@Column(name = "ewb_no")
	private String ewbNo;
	@Column(name = "update_mode")
	private String updMode;
	@Column(name = "vehicle_no")
	private String vehicleNo;
	@Column(name = "from_place")
	private String fromPlace;
	@Column(name = "from_state")
	private String fromState;
	/*@Column(name = "trip_sht_no")
	private Integer tripshtNo;*/
	@Column(name = "user_gstin_transin")
	private String userGSTINTransin;
	@Column(name = "trans_doc_no")									
	private String transDocNo;
	@Column(name = "trans_doc_date")						
	private String transDocDate;
	@Column(name = "entered_date")
	private String enteredDate;
	@Column(name = "created_date")
	private Timestamp createdDate;
	@Column(name = "updated_date")
	private Timestamp updatedDate;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "updated_by")							
	private String updatedBy;
	@Column(name ="load_id")
	private String loadId;
	@Column(name = "udid")						
	private String udid;
	@Column(name = "trans_mode")						
	private String transMode;
	@Column(name = "vehicle_type")						
	private String vehicleType;
	@Column(name="group_no")
	private String groupNo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EWBVehicleDetailsEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getEwbNo() {
		return ewbNo;
	}

	public void setEwbNo(String ewbNo) {
		this.ewbNo = ewbNo;
	}

	public String getUpdMode() {
		return updMode;
	}

	public void setUpdMode(String updMode) {
		this.updMode = updMode;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getFromState() {
		return fromState;
	}

	public void setFromState(String fromState) {
		this.fromState = fromState;
	}

	/*public Integer getTripshtNo() {
		return tripshtNo;
	}

	public void setTripshtNo(Integer tripshtNo) {
		this.tripshtNo = tripshtNo;
	}*/

	
	
	public String getUserGSTINTransin() {
		return userGSTINTransin;
	}

	public void setUserGSTINTransin(String userGSTINTransin) {
		this.userGSTINTransin = userGSTINTransin;
	}

	public String getTransDocNo() {
		return transDocNo;
	}

	public void setTransDocNo(String transDocNo) {
		this.transDocNo = transDocNo;
	}

	public String getTransDocDate() {
		return transDocDate;
	}

	public void setTransDocDate(String transDocDate) {
		this.transDocDate = transDocDate;
	}

	public String getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(String enteredDate) {
		this.enteredDate = enteredDate;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getLoadId() {
		return loadId;
	}

	public void setLoadId(String loadId) {
		this.loadId = loadId;
	}

	public String getUdid() {
		return udid;
	}

	public void setUdid(String udid) {
		this.udid = udid;
	}

	public String getTransMode() {
		return transMode;
	}

	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	
}
