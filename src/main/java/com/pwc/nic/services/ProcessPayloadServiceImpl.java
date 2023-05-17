package com.pwc.nic.services;

import com.pwc.nic.model.EwbDetails;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

import static com.pwc.nic.util.Constants.*;
import static com.pwc.nic.util.Constants.EMPTY_STRING;

@Service
public class ProcessPayloadServiceImpl implements ProcessPayloadService{


    @Override
    public ConcurrentHashMap<String, String> createEWBPayload() {

        return null;
    }

    @Override
    public JSONObject setDocDetailPayload(JSONObject data, JSONObject docDetails) throws JSONException {
        data.put("docType", docDetails.getString(TYP));
        data.put("docNo", docDetails.getString(NO));
        data.put("docDate", docDetails.getString(DT));
        return data;
    }

    @Override
    public JSONObject setSellerDetailPayload(JSONObject data, JSONObject sellerDetails) throws JSONException {
        data.put("fromGstin", sellerDetails.getString(GSTIN_REQ));
        data.put("fromStateCode", sellerDetails.getInt(STCD));
        if (sellerDetails.has(TRD_NM)){
            data.put("fromTrdName", sellerDetails.getString(TRD_NM));
        }
        return data;
    }

    @Override
    public JSONObject setBuyerDetailPayload(JSONObject data, JSONObject buyerDtls) throws JSONException {
        data.put("toGstin", buyerDtls.getString(GSTIN_REQ));
        data.put("toStateCode", buyerDtls.getInt(STCD));
        if (buyerDtls.has(TRD_NM)){
            data.put("toTrdName", buyerDtls.getString(TRD_NM));
        }
        return data;
    }

    @Override
    public JSONObject setValueDetailPayload(JSONObject data, JSONObject valDtls) throws JSONException {
        data.put("totInvValue", valDtls.getInt("TotInvVal"));
        if (valDtls.has(CGST_VAL)){
            data.put("cgstValue", valDtls.getInt(CGST_VAL));
        }
        if (valDtls.has(SGST_VAL)){
            data.put("sgstValue", valDtls.getInt(SGST_VAL));
        }
        if (valDtls.has(IGST_VAL)){
            data.put("igstValue", valDtls.getInt(IGST_VAL));
        }
        if (valDtls.has(CES_VAL)){
            data.put("cessValue", valDtls.getInt(CES_VAL));
        }
        if (valDtls.has(CES_NON_AD_VAL)){
            data.put("cessNonAdvolValue", valDtls.getString(CES_NON_AD_VAL));
        }
        if (valDtls.has(OTH_CHRG)){
            data.put("otherValue", valDtls.getString(OTH_CHRG));
        }
        if (valDtls.has(ASS_VAL)){
            data.put("totalValue", valDtls.getInt(ASS_VAL));
        }
        return data;
    }

    @Override
    public JSONObject setDispDetailPayload(JSONObject data, JSONObject dispDtls) throws JSONException {
        data.put("actFromStateCode", dispDtls.getInt(STCD));
        data.put("fromPincode", dispDtls.getInt(PIN));
        if (dispDtls.has(ADDR1)){
            data.put("fromAddr1", dispDtls.getString(ADDR1));
        }
        if (dispDtls.has(ADDR2)){
            data.put("fromAddr2", dispDtls.getString(ADDR2));
        }
        if (dispDtls.has(LOC)){
            data.put("fromPlace", dispDtls.getString(LOC));
        }
        return data;
    }

    @Override
    public JSONObject setShippingDetails(JSONObject data, JSONObject shipDtls) throws JSONException {
        data.put("actToStateCode", shipDtls.getInt(STCD));
        data.put("toPincode", shipDtls.getInt(PIN));

        if (shipDtls.has(ADDR1)){
            data.put("toAddr1", shipDtls.getString(ADDR1));
        }
        if (shipDtls.has(ADDR2)){
            data.put("toAddr2", shipDtls.getString(ADDR2));
        }
        if (shipDtls.has(LOC)){
            data.put("toPlace", shipDtls.getString(LOC));
        }
        return data;
    }

    @Override
    public JSONObject setEwbDetails(JSONObject data, JSONObject ewbDtls) throws JSONException {
        data.put("transDistance", ewbDtls.getString("Distance"));

        if (ewbDtls.has(TRANS_MODE)){
            data.put("transMode", ewbDtls.getString(TRANS_MODE));
        }

        if (ewbDtls.has(VEH_NO)){
            data.put("vehicleNo", ewbDtls.getString(VEH_NO));
        }

        if (ewbDtls.has(VEH_TYPE)){
            data.put("vehicleType", ewbDtls.getString(VEH_TYPE));
        }

        if (ewbDtls.has(TRANS_NAME)){
            data.put("transporterName", ewbDtls.getString(TRANS_NAME));
        }
        if (ewbDtls.has(TRANS_ID)){
            data.put("transporterId", ewbDtls.getString(TRANS_ID));
        }
        if (ewbDtls.has(TRANS_DOC_NO)) {
            data.put("transDocNo", ewbDtls.getString(TRANS_DOC_NO));
        }
        if (ewbDtls.has(TRANS_DOC_DT)){
            data.put("transDocDate", ewbDtls.getString(TRANS_DOC_DT));
        }
        return data;
    }

    @Override
    public JSONObject setItemDetails(JSONObject item) throws JSONException {
        JSONObject newItem = new JSONObject();
        newItem.put("hsnCode", item.getString(HSNCD));
        newItem.put("taxableAmount", item.getInt("AssAmt"));
        if (item.has(IGST_RT)){
            newItem.put("igstRate", item.getInt(IGST_RT));
        }
        if (item.has(IGST_AMT)){
            newItem.put("igstAmount", item.getInt(IGST_AMT));
        }
        if (item.has(ITEM_CODE)){
            newItem.put("itemCode", item.getString(ITEM_CODE));
        }
        if (item.has(SL_NO)){
            newItem.put("itemNo", item.getInt(SL_NO));
        }
        if(item.has(PRD_NM)){
            newItem.put("productName", item.getString(PRD_NM));
        }
        if(item.has(PRD_DESC)){
            newItem.put("productDesc", item.getString(PRD_DESC));
        }
        if(item.has(QTY)){
            newItem.put("quantity", item.getInt(QTY));
        }
        if(item.has(UNIT)){
            newItem.put("qtyUnit", item.getString(UNIT));
        }
        if(item.has(CGST_RT)){
            newItem.put("cgstRate", item.getInt(CGST_RT));
        }
        if(item.has(SGST_RT)){
            newItem.put("sgstRate", item.getInt(SGST_RT));
        }
        if(item.has(CES_RT)){
            newItem.put("cessRate", item.getInt(CES_RT));
        }
        if(item.has(CES_NON_AD_VL_AMT)){
            newItem.put("cessNonadvol", item.getInt(CES_NON_AD_VL_AMT));
        }
        if(item.has(CGST_AMT)){
            newItem.put("cgstAmount", item.getInt(CGST_AMT));
        }
        if(item.has(SGST_AMT)){
            newItem.put("sgstAmount", item.getInt(SGST_AMT));
        }
        if(item.has(CES_AMT)){
            newItem.put("cessAmount", item.getInt(CES_AMT));
        }
        return newItem;
    }

    public EwbDetails hardCodeValues(EwbDetails ewbDetails) {
        ewbDetails.setCreatedBy(ENGINE);
        ewbDetails.setUpdatedBy(ENGINE);
        ewbDetails.setDocumentDetailsId(ZERO);
        ewbDetails.setFu1(EMPTY_STRING);
        ewbDetails.setFu3(EMPTY_STRING);
        ewbDetails.setFu4(EMPTY_STRING);
        ewbDetails.setFu5(EMPTY_STRING);
        ewbDetails.setMis1(EMPTY_STRING);
        ewbDetails.setMis2(EMPTY_STRING);
        ewbDetails.setMis3(EMPTY_STRING);
        ewbDetails.setMis4(EMPTY_STRING);
        ewbDetails.setMis5(EMPTY_STRING);
        ewbDetails.setMis6(EMPTY_STRING);
        ewbDetails.setMis7(EMPTY_STRING);
        ewbDetails.setMis8(EMPTY_STRING);
        ewbDetails.setMis9(EMPTY_STRING);
        ewbDetails.setMis10(EMPTY_STRING);
        ewbDetails.setMovementStatus(NULL);
        ewbDetails.setOriginalDocumentNo(EMPTY_STRING);
        ewbDetails.setPoNo(EMPTY_STRING);
        ewbDetails.setSoNo(EMPTY_STRING);
        ewbDetails.setSource(EMPTY_STRING);
        ewbDetails.setUserName(EMPTY_STRING);
        ewbDetails.setValidationStatus(SUCCESS);
        ewbDetails.setEwbActive(Y);
        ewbDetails.setIsEwbCouneryPartyRejected(N);
        ewbDetails.setIsEwbExpired(N);
        ewbDetails.setIsEwbCancel(N);
        ewbDetails.setEwbDddetailsBatchID(ZERO);
        return ewbDetails;
    }

}
