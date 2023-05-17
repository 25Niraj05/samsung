package com.pwc.nic.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
//@Table(schema = "demo", name = "upload")
@Table(schema = "demo", name = "upload") //SwitchSamsungDB
public class Upload {

    @Id
//    @SequenceGenerator(allocationSize = 1, initialValue = 1, /*sequenceName = "ewb_cusdb.demo.upload_id_seq",*/ name =
//        "upload_id_seq")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "upload_id_seq", name = "upload_id_seq")  //SwitchSamsungDB
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "load_id")
    private Integer loadId;
    @Column(name = "source_system")
    private String sourceSystem;
    @Column(name = "category")
    private String category;
    @Column(name = "company_id")
    private Integer companyId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "state")
    private String state;
    @Column(name = "comments")
    private String comments;
    @Column(name = "failed_quality")
    private Integer failedQuality;
    @Column(name = "original_file_name")
    private String originalFileName;
    @Column(name = "s3_file_name")
    private String s3FileName;

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
    @Column(name = "data_type")
    private String dataType;
    @Column(name = "load_type")
    private String loadType;
    @Column(name = "mapping")
    private String mapping;
    @Column(name = "status")
    private String status;
    @Column(name = "import_from_file")
    private Integer importFromFile;
    @Column(name = "file_name")
    private String fileName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoadId() {
        return loadId;
    }

    public void setLoadId(Integer loadId) {
        this.loadId = loadId;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getFailedQuality() {
        return failedQuality;
    }

    public void setFailedQuality(Integer failedQuality) {
        this.failedQuality = failedQuality;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getS3FileName() {
        return s3FileName;
    }

    public void setS3FileName(String s3FileName) {
        this.s3FileName = s3FileName;
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getImportFromFile() {
        return importFromFile;
    }

    public void setImportFromFile(Integer importFromFile) {
        this.importFromFile = importFromFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
