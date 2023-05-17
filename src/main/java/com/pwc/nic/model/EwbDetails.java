package com.pwc.nic.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
//@Table(name = "ewb_cusdb.demo.ewb_details")
@Table(name = "demo.ewb_details") //SwitchSamsungDB
public class EwbDetails {

    @Id
//    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "ewb_cusdb.demo.ewb_details_id_seq",
//        name = "ewb_cusdb.demo.ewb_details_id_seq")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "demo.ewb_details_id_seq",
        name = "demo.ewb_details_id_seq") //SwitchSamsungDB
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "nic_extended_times")
    private int nicExtendedTimes;

    @Column(name = "location_id")
    private int locationId;

    @Column(name = "nic_no_valid_days")
    private int nicValidDays;

    @Column(name = "total_value")
    private float totalValue;

    @Column(name = "cgst_value")
    private float cgstValue;

    @Column(name = "sgst_value")
    private float sgstValue;

    @Column(name = "igst_value")
    private float igstValue;

    @Column(name = "cess_value")
    private float cessValue;

    @Column(name = "taxable_amount")
    private float taxableAmount;

    @Column(name = "taxable_value")
    private float taxableValue;

    @Column(name = "eway_bill_no")
    private long ewayBillNo;

    @Column(name = "nic_eway_bill_date_ampm")
    private String ewbDateAmpm;

    @Column(name = "nic_eway_bill_date")
    private Timestamp ewayBillDate;

    @Column(name = "nic_valid_upto")
    private Timestamp ewayBillValidUpto;

    @Column(name = "nic_valid_upto_ampm")
    private String ewbValidUptoAmpm;

    @Column(name = "bu")
    private String bu;

    @Column(name = "sbu")
    private String sbu;

    @Column(name = "location")
    private String location;

    @Column(name = "bu_id")
    private int buId;

    @Column(name = "sbu_id")
    private int sbuId;

    @Column(name = "mis_action")
    private String misAction;

    @Column(name = "gstin_id")
    private int gstinId;

    @Column(name = "user_gstin")
    private String userGstin;

    @Column(name = "udid")
    private String udid;

    @Column(name = "load_id")
    private Integer loadId;

    @Column(name = "document_no")
    private String docNo;

    @Column(name = "document_date")
    private Date docDate;

    @Column(name = "cf3")
    private String cf3;

    @Column(name = "ewb_generation_status")
    private String ewbGenerationStatus;

    @Column(name = "nic_document_status")
    private String documentStatus;

    @Column(name = "nic_status")
    private String nicStatus;

    @Column(name = "transportation_distance")
    private Integer transportationDistance;

    @Column(name = "nic_request_payload")
    private String nicRequestPayload;

    @Column(name = "nic_get_response_json")
    private String nicGetResponseJson;

    @Column(name = "nic_gen_mode")
    private String nicGenMode;

    @Column(name = "vehicle_list_details")
    private String vehicleListDetails;

    @Column(name = "nic_actual_distance")
    private Integer nicActualDistance;

    @Column(name = "nic_reject_status")
    private String nicRejectStatus;

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Column(name = "document_details_id")
    private int documentDetailsId;

    @Column(name = "item_list")
    private String itemList;

    @Column(name = "mis_1")
    private String mis1;

    @Column(name = "mis_2")
    private String mis2;

    @Column(name = "mis_3")
    private String mis3;

    @Column(name = "mis_4")
    private String mis4;

    @Column(name = "mis_5")
    private String mis5;

    @Column(name = "mis_6")
    private String mis6;

    @Column(name = "mis_7")
    private String mis7;

    @Column(name = "mis_8")
    private String mis8;

    @Column(name = "mis_9")
    private String mis9;

    @Column(name = "mis_10")
    private String mis10;

    @Column(name = "fu_1")
    private String fu1;

    @Column(name = "fu_2")
    private String fu2;

    @Column(name = "fu_3")
    private String fu3;

    @Column(name = "fu_4")
    private String fu4;

    @Column(name = "fu_5")
    private String fu5;

    @Column(name="movement_status")
    private String movementStatus;

    @Column(name="original_document_no")
    private String originalDocumentNo;

    @Column(name="po_no")
    private String poNo;

    @Column(name="so_no")
    private String soNo;

    @Column(name="source")
    private String source;

    @Column(name="user_name")
    private String userName;

    @Column(name="validation_status")
    private String validationStatus;

    @Column(name="active")
    private String ewbActive;

    @Column(name="is_countery_party_rejected")
    private String isEwbCouneryPartyRejected;

    @Column(name="is_expired")
    private String isEwbExpired;

    @Column(name="is_cancel")
    private String isEwbCancel;

    @Column(name="ewb_details_batch_id")
    private int ewbDddetailsBatchID;

    public int getEwbDddetailsBatchID() {
        return ewbDddetailsBatchID;
    }

    public void setEwbDddetailsBatchID(int ewbDddetailsBatchID) {
        this.ewbDddetailsBatchID = ewbDddetailsBatchID;
    }

    public String getIsEwbCouneryPartyRejected() {
        return isEwbCouneryPartyRejected;
    }

    public void setIsEwbCouneryPartyRejected(String isEwbCouneryPartyRejected) {
        this.isEwbCouneryPartyRejected = isEwbCouneryPartyRejected;
    }

    public String getIsEwbExpired() {
        return isEwbExpired;
    }

    public void setIsEwbExpired(String isEwbExpired) {
        this.isEwbExpired = isEwbExpired;
    }

    public String getIsEwbCancel() {
        return isEwbCancel;
    }

    public void setIsEwbCancel(String isEwbCancel) {
        this.isEwbCancel = isEwbCancel;
    }

    public String getEwbActive() {
        return ewbActive;
    }

    public void setEwbActive(String ewbActive) {
        this.ewbActive = ewbActive;
    }

    public String getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(String validationStatus) {
        this.validationStatus = validationStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSoNo() {
        return soNo;
    }

    public void setSoNo(String soNo) {
        this.soNo = soNo;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getOriginalDocumentNo() {
        return originalDocumentNo;
    }

    public void setOriginalDocumentNo(String originalDocumentNo) {
        this.originalDocumentNo = originalDocumentNo;
    }

    public String getMovementStatus() {
        return movementStatus;
    }

    public void setMovementStatus(String movementStatus) {
        this.movementStatus = movementStatus;
    }

    public int getDocumentDetailsId() {
        return documentDetailsId;
    }

    public void setDocumentDetailsId(int documentDetailsId) {
        this.documentDetailsId = documentDetailsId;
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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getNicActualDistance() {
        return nicActualDistance;
    }

    public void setNicActualDistance(Integer nicActualDistance) {
        this.nicActualDistance = nicActualDistance;
    }

    public String getNicRejectStatus() {
        return nicRejectStatus;
    }

    public void setNicRejectStatus(String nicRejectStatus) {
        this.nicRejectStatus = nicRejectStatus;
    }

    public String getVehicleListDetails() {
        return vehicleListDetails;
    }

    public void setVehicleListDetails(String vehicleListDetails) {
        this.vehicleListDetails = vehicleListDetails;
    }

    public String getNicGenMode() {
        return nicGenMode;
    }

    public void setNicGenMode(String nicGenMode) {
        this.nicGenMode = nicGenMode;
    }

    public String getNicGetResponseJson() {
        return nicGetResponseJson;
    }

    public void setNicGetResponseJson(String nicGetResponseJson) {
        this.nicGetResponseJson = nicGetResponseJson;
    }

    public Integer getTransportationDistance() {
        return transportationDistance;
    }

    public void setTransportationDistance(Integer transportationDistance) {
        this.transportationDistance = transportationDistance;
    }

    public String getNicRequestPayload() {
        return nicRequestPayload;
    }

    public void setNicRequestPayload(String nicRequestPayload) {
        this.nicRequestPayload = nicRequestPayload;
    }

    public String getCf3() {
        return cf3;
    }

    public void setCf3(String cf3) {
        this.cf3 = cf3;
    }

    public String getEwbGenerationStatus() {
        return ewbGenerationStatus;
    }

    public void setEwbGenerationStatus(String ewbGenerationStatus) {
        this.ewbGenerationStatus = ewbGenerationStatus;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public String getNicStatus() {
        return nicStatus;
    }

    public void setNicStatus(String nicStatus) {
        this.nicStatus = nicStatus;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getFu2() {
        return fu2;
    }

    public void setFu2(String fu2) {
        this.fu2 = fu2;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public Integer getLoadId() {
        return loadId;
    }

    public void setLoadId(Integer loadId) {
        this.loadId = loadId;
    }

    public int getGstinId() {
        return gstinId;
    }

    public void setGstinId(int gstinId) {
        this.gstinId = gstinId;
    }

    public String getUserGstin() {
        return userGstin;
    }

    public void setUserGstin(String userGstin) {
        this.userGstin = userGstin;
    }

    public int getBuId() {
        return buId;
    }

    public void setBuId(int buId) {
        this.buId = buId;
    }

    public int getSbuId() {
        return sbuId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSbuId(int sbuId) {
        this.sbuId = sbuId;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getSbu() {
        return sbu;
    }

    public void setSbu(String sbu) {
        this.sbu = sbu;
    }

    public String getMisAction() {
        return misAction;
    }

    public void setMisAction(String misAction) {
        this.misAction = misAction;
    }

    public int getNicExtendedTimes() {
        return nicExtendedTimes;
    }

    public void setNicExtendedTimes(int nicExtendedTimes) {
        this.nicExtendedTimes = nicExtendedTimes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getNicValidDays() {
        return nicValidDays;
    }

    public void setNicValidDays(int nicValidDays) {
        this.nicValidDays = nicValidDays;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    public float getCgstValue() {
        return cgstValue;
    }

    public void setCgstValue(float cgstValue) {
        this.cgstValue = cgstValue;
    }

    public float getSgstValue() {
        return sgstValue;
    }

    public void setSgstValue(float sgstValue) {
        this.sgstValue = sgstValue;
    }

    public float getIgstValue() {
        return igstValue;
    }

    public void setIgstValue(float igstValue) {
        this.igstValue = igstValue;
    }

    public float getCessValue() {
        return cessValue;
    }

    public void setCessValue(float cessValue) {
        this.cessValue = cessValue;
    }

    public float getTaxableAmount() {
        return taxableAmount;
    }

    public void setTaxableAmount(float taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    public float getTaxableValue() {
        return taxableValue;
    }

    public void setTaxableValue(float taxableValue) {
        this.taxableValue = taxableValue;
    }

    public long getEwayBillNo() {
        return ewayBillNo;
    }

    public void setEwayBillNo(long ewayBillNo) {
        this.ewayBillNo = ewayBillNo;
    }

    public Timestamp getEwayBillDate() {
        return ewayBillDate;
    }

    public void setEwayBillDate(Timestamp ewayBillDate) {
        this.ewayBillDate = ewayBillDate;
    }

    public String getEwbDateAmpm() {
        return ewbDateAmpm;
    }

    public void setEwbDateAmpm(String ewbDateAmpm) {
        this.ewbDateAmpm = ewbDateAmpm;
    }

    public String getEwbValidUptoAmpm() {
        return ewbValidUptoAmpm;
    }

    public void setEwbValidUptoAmpm(String ewbValidUptoAmpm) {
        this.ewbValidUptoAmpm = ewbValidUptoAmpm;
    }

    public Timestamp getEwayBillValidUpto() {
        return ewayBillValidUpto;
    }

    public void setEwayBillValidUpto(Timestamp ewayBillValidUpto) {
        this.ewayBillValidUpto = ewayBillValidUpto;
    }

    public String getMis1() {
        return mis1;
    }

    public void setMis1(String mis1) {
        this.mis1 = mis1;
    }

    public String getMis2() {
        return mis2;
    }

    public void setMis2(String mis2) {
        this.mis2 = mis2;
    }

    public String getMis3() {
        return mis3;
    }

    public void setMis3(String mis3) {
        this.mis3 = mis3;
    }

    public String getMis4() {
        return mis4;
    }

    public void setMis4(String mis4) {
        this.mis4 = mis4;
    }

    public String getMis5() {
        return mis5;
    }

    public void setMis5(String mis5) {
        this.mis5 = mis5;
    }

    public String getMis6() {
        return mis6;
    }

    public void setMis6(String mis6) {
        this.mis6 = mis6;
    }

    public String getMis7() {
        return mis7;
    }

    public void setMis7(String mis7) {
        this.mis7 = mis7;
    }

    public String getMis8() {
        return mis8;
    }

    public void setMis8(String mis8) {
        this.mis8 = mis8;
    }

    public String getMis9() {
        return mis9;
    }

    public void setMis9(String mis9) {
        this.mis9 = mis9;
    }

    public String getMis10() {
        return mis10;
    }

    public void setMis10(String mis10) {
        this.mis10 = mis10;
    }

    public String getFu1() {
        return fu1;
    }

    public void setFu1(String fu1) {
        this.fu1 = fu1;
    }

    public String getFu3() {
        return fu3;
    }

    public void setFu3(String fu3) {
        this.fu3 = fu3;
    }

    public String getFu4() {
        return fu4;
    }

    public void setFu4(String fu4) {
        this.fu4 = fu4;
    }

    public String getFu5() {
        return fu5;
    }

    public void setFu5(String fu5) {
        this.fu5 = fu5;
    }

    public String getItemList() {
        return itemList;
    }

    public void setItemList(String itemList) {
        this.itemList = itemList;
    }
}
