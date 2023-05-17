package com.pwc.nic.enums;

public enum SubSupplyTypes {

    SUPPLY(1, "Supply"),
    IMPORT(2, "Import"),
    EXPORT(3, "Export"),
    JOB_WORK(4, "Job Work"),
    FOR_OWN_USE(5, "For Own Use"),
    JOB_WORK_RETURNS(6, "Job work Returns"),
    SALES_RETURN(7, "Sales Return"),
    OTHERS(8, "Others"),
    SKD_CKD(9, "SKD/CKD"),
    LINE_SALES(10,"Line Sales"),
    RECIPIENT_NOT_KNOWN(11, "Recipient Not Known"),
    EXHIBITION_OR_FAIRS(12, "Exhibition or Fairs");

    public final int typeNumber;
    public final String type;

    SubSupplyTypes(int typeNumber, String type) {
        this.type = type;
        this.typeNumber = typeNumber;
    }
}
