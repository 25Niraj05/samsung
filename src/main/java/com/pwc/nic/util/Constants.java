package com.pwc.nic.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Constants {


	private Constants() {
	}
	public static final DateFormat nicDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	public static final String SEK = "Sek";
	public static final String TKEY = "tkey";
	public static final String AUTHKEY = "authkey";
	public static final String USER_NAME = "userName";
	public static final String AUTHTOKEN = "AuthToken";
	public static final String AUTH_RESPONSE_PLAINTEXT_JSON = "auth_response_plaintext_json";
	public static final String APP_CONSTANT = "mS8qaWIEdQ4zOr7IGKea40u6LCr2BBOU";
	public static final String STATUS = "Status";
	public static final String RESPONSE_STATUS = "status";
	public static final String ERROR = "ErrorDetails";
	public static final String SIGNED_INVOICE = "SignedInvoice";
	public static final String SIGNED_QRCODE = "SignedQRCode";
	public static final String DATA = "Data";
	public static final String ERROR_CODES = "errorCodes";
	public static final String accessToken = "ACCESSTOKEN";
	public static final String AUTH_URL_VERSION = "04";
	public static final long expiryTime = 600000;
	public static final String INVALID_AUTH = "Invalid Token";

	public static final String EWB_ALREADY_GENERATED_CODE = "604";
	public static final String EWB_ALREADY_GENERATED_FOR_IRN_CODE = "4002";
	public static final String NIC_REQUEST_PAYLOAD = "nic_request_payload";
	public static final String NIC_DOCUMENT_STATUS_CREATED_DATE = "nic_document_status_created_date";
	public static final String NIC_STATUS = "nic_status";
	public static final String NIC_GEN_MODE = "nic_gen_mode";
	public static final String NIC_RESPONSE_STATUS = "nic_response_status";
//	public static final String NIC_RESPONSE_ENCODED = "nic_response_encoded";//RESPONSE YOU RECEIVED
	public static final String NIC_RESPONSE_DATA = "nic_response_data";//AFTER DECRYPTION BEFORE JWS
	public static final String NIC_RESPONSE_PLAINTEXT_JSON = "nic_response_plaintext_json";//AFTER DECRYPTION AND AFTER JWS
	public static final String NIC_RESPONSE_CREATED_DATE = "nic_response_created_date";
	public static final String ERROR_DETAILS = "error_details";
	public static final String INFODTLS ="InfoDtls" ;
	public static final String NIC_REQUEST_HEADER = "nic_request_header";
    public static final String CONFIG_MISSING ="702" ;
    public static final String IRN_NOT_REQ ="715" ;
	public static final String GENERATED_CODE ="700" ;
	public static final String PwC_AUTH_FAILED ="701" ;
	public static final String IRN_SCH_FAILED ="707" ;
	public static final String GEN_FAILED ="711" ;
	public static final String NIC_AUTH_FAILED ="714" ;
	public static final String EWB_BY_IRN_SCH_FAILED ="715" ;
	public static final String EWB_BY_IRN_GENERATED ="716" ;
	public static final String EWB_BY_IRN_GEN_FAILED ="717" ;
	public static final String EXCEPTION ="799" ;
	public static final String QRCODE_IMAGE_ENCODED = "qr_image_b64_encoded";
	public static final String MIS_COLUMNS = "MisColumns";
	public static final String FAIL = "Fail";
	public static final String FAILED = "Failed";
	public static final String GEN_RESPONSE_PLAINTEXT = "gen_response_plaintext";
	public static final String INFO = "info";
	public static final String GENERATED = "Generated";
	public static final String RESPNOSE_ENCRYPT = "respnose_encrypt";
	public static final String RESPONSE_DECRYPT = "response_decrypt";
	public static final String RESULT_STATUS = "status";
	public static final String ERR = "error";
	public static final String ENGINE = "ENGINE";
	public static final int ZERO = 0;
	public static final String ZERO_STRING = "0";
	public static final String ONE_STRING = "1";
	public static final String EMPTY_STRING = "";
	public static final String NULL = null;
	public static final String NULL_STRING = "null";
	public static final String SUCCESS = "Success";
	public static final String Y = "Y";
	public static final String N = "N";
	public static final String OUTWARD = "OUTWARD";
	public static final String SUPPLY = "SUPPLY";
	public static final String API = "API";
	public static final String REMARKS = "Remarks";
	public static final String ALERT = "alert";
	public static final String ENABLE_ONLY_EWB_GENERATION = "ENABLE_ONLY_EWB_GENERATION";
	public static final Set<String> supplyTypesForIrn = new HashSet<>(Arrays.asList("B2B", "SEZWP", "SEZWOP", "EXPWP"
		, "EXPWOP", "DEXP"));
	public static final Set<String> documentTypesForIrn = new HashSet<>(Arrays.asList("INV", "CRN", "DBN"));
	public static final String SCHEMA_SKIPPED_MESSAGE = "Schema skipped. IRN and EWB not applicable";
	public static final String INVOICE_NUMBER = "invoice_number";
	public static final String GSTIN = "gstin";
	public static final String DOCUMENT_DATE = "document_date";
	public static final String DOCUMENT_TYPE = "document_type";
	public static final String VALIDATION_STATUS = "validation_status";
	public static final String VALIDATION_REMARKS = "validation_remarks";
	public static final String NO = "No";
	public static final String DT = "Dt";
	public static final String TYP = "Typ";
	public static final String EWAY_BILL_NO = "ewayBillNo";
	public static final String ACT = "ACT";
	public static final String EWB_NO = "EwbNo";
	public static final String EWAY_BILL_DATE = "ewayBillDate";
	public static final String EWB_VALID_TILL = "EwbValidTill";
	public static final String EWB_DT = "EwbDt";
	public static final String VALID_UPTO = "validUpto";
	public static final String IRN = "Irn";
	public static final String ACK_NO = "AckNo";
	public static final String ACK_DT = "AckDt";
	public static final String DISP_DTLS = "DispDtls";
	public static final String DOC_DTLS = "DocDtls";
	public static final String COLON = ":";
	public static final String SUB_TYPE = "SubType";
	public static final String SUP_TYPE = "SupTyp";
	public static final String GSTIN_ID = "gstin_id";
	public static final String GEN_EWAY_BILL_ACTION = "GENEWAYBILL";
	public static final String ACTION = "action";
	public static final String PAYLOAD_DATA = "data";
	public static final String ITEM_LIST = "itemList";
	public static final String ITEM_LIST_REQ = "ItemList";
	public static final String SUPPLY_TYPE = "supplyType";
	public static final String SUB_SUPPLY_TYPE = "subSupplyType";
	public static final String SUB_TYPE_DESCRIPTION = "SubTypeDescription";
	public static final String SUB_SUPPLY_DESC = "subSupplyDesc";
	public static final String TRANSACTION_TYPE = "transactionType";
	public static final String EWB_GEN_MESSAGE = "EWB Schema Validation Passed, Response Successfully Received, EWB " +
	"Generated";
	public static final String ERR_CODE = "ErrorCode";
	public static final String ERROR_MESSAGE = "ErrorMessage";
	public static final String INFO_DTLS = "InfoDtls";
	public static final String TRAN_DTLS = "TranDtls";
	public static final String SELLER_DTLS = "SellerDtls";
	public static final String BUYER_DTLS = "BuyerDtls";
	public static final String VAL_DTLS = "ValDtls";
	public static final String EWB_DTLS = "EwbDtls";
	public static final String SHIP_DTLS = "ShipDtls";
	public static final String OUTWARD_INWARD = "OutwardInward";
	public static final String USER_GSTIN = "User_GSTIN";
	public static final String BU = "Bu";
	public static final String SBU = "Sbu";
	public static final String LOCATION = "Location";
	public static final String NIC_AUTH_FAILED_MESSAGE ="NIC Authentication Failed" ;
	public static final String SAVE_ED = "save_ed";
	public static final String MESSAGE = "message";
	public static final String HSNCD = "HsnCd";
	public static final String LOCATION_ID = "location_id";
	public static final String SBU_ID = "sbu_id";
	public static final String BU_ID = "bu_id";
	public static final String STCD = "Stcd";
	public static final String PIN = "Pin";
	public static final String ADDR1 = "Addr1";
	public static final String ADDR2 = "Addr2";
	public static final String LOC = "Loc";
	public static final String TRANS_MODE = "TransMode";
	public static final String VEH_NO = "VehNo";
	public static final String VEH_TYPE = "VehType";
	public static final String TRANS_NAME = "TransName";
	public static final String TRANS_ID = "TransId";
	public static final String TRANS_DOC_NO = "TransDocNo";
	public static final String TRANS_DOC_DT = "TransDocDt";
	public static final String TRD_NM = "TrdNm";
	public static final String GSTIN_REQ = "Gstin";
	public static final String CGST_VAL = "CgstVal";
	public static final String SGST_VAL = "SgstVal";
	public static final String IGST_VAL = "IgstVal";
	public static final String CES_VAL = "CesVal";
	public static final String CES_NON_AD_VAL = "CesNonAdVal";
	public static final String OTH_CHRG = "OthChrg";
	public static final String ASS_VAL = "AssVal";
	public static final String ITEM_CODE = "ItemCode";
	public static final String IGST_RT = "IgstRt";
	public static final String IGST_AMT = "IgstAmt";
	public static final String SL_NO = "SlNo";
	public static final String PRD_NM = "PrdNm";
	public static final String PRD_DESC = "PrdDesc";
	public static final String QTY = "Qty";
	public static final String UNIT = "Unit";
	public static final String CGST_RT = "CgstRt";
	public static final String SGST_RT = "SgstRt";
	public static final String CES_RT = "CesRt";
	public static final String CES_NON_AD_VL_AMT = "CesNonAdvlAmt";
	public static final String CGST_AMT = "CgstAmt";
	public static final String SGST_AMT = "SgstAmt";
	public static final String CES_AMT = "CesAmt";
	public static final String REMARK = "remark";
	public static final String FIELD_NAME = "field_name";
	public static final String PWC_AUTH_FAILED = "PwC Authentication Failed";
	public static final String CAUSING_EX = "causingExceptions";
	public static final String POINTER_TO_VOILATION = "pointerToViolation";
	public static final String MISSING_UNAME_OR_PWD = "UserName or Password is missing in headers";
	public static final String AUTH_END_MESSAGE = "EInvoice-Authentication process end for gstin : {}, response : {}";
	public static final String JSON_EX_MESSAGE = "Exception during JSON processing: ";
	public static final String ERROR_CODE = "error_code";
	public static final String ERR_LITERAL = "Error";
	public static final String ERR_10000 = "10000";
	public static final String NIC_ERROR = "NIC-Error as: ";
	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
	public static final String PADDING = "AES/ECB/PKCS5PADDING";
	public static final String AES = "AES";
	public static final String RSA = "RSA";

	public static final String IS_IRN = "IS_IRN";

	public static final String IS_EWB = "IS_EWB";

	public static final String EWB_FETCH = "EWBFETCH";

	public static void main(String[] args) {
		System.out.println(GEN_INV_PAYLOAD);
	}
	public static final String GEN_INV_PAYLOAD = "{\r\n" +
    		"    \"$schema\": \"http://json-schema.org/draft-07/schema#\",\r\n" +
    		"    \"properties\": {\r\n" +
    		"        \"User_GSTIN\": {\r\n" +
    		"            \"type\": \"string\",\r\n" +
    		"            \"pattern\": \"^([0-9]{2}[0-9A-Z]{13})$\"\r\n" +
    		"        },\r\n" +
    		"        \"Version\": {\r\n" +
    		"           \"maxLength\": 6,\r\n" +
    		"           \"minLength\": 1 \r\n" +
    		"        },\r\n" +
    		"        \"Irn\": {\r\n" +
    		"            \"type\": \"string\",\r\n" +
    		"            \"maxLength\": 64,\r\n" +
    		"            \"minLength\": 64,\r\n" +
    		"            \"description\": \"Invoice Reference No.\"\r\n" +
    		"        },\r\n" +
    		"        \"TranDtls\": {\r\n" +
    		"            \"type\": \"object\",\r\n" +
    		"            \"properties\": {\r\n" +
    		"                \"TaxSch\": {\r\n" +
    		"                    \"enum\": [\"GST\"],\r\n" +
    		"                    \"description\": \"GST- Goods and Services Tax Scheme\"\r\n" +
    		"                },\r\n" +
    		"                \"SupTyp\": {\r\n" +
    		"                    \"enum\": [\"B2B\", \"SEZWP\", \"SEZWOP\", \"EXPWP\", \"EXPWOP\", \"DEXP\", \"B2C\"],\r\n" +
    		"                    \"description\": \"Type of Supply: B2B-Business to Business, SEZWP - SEZ with payment, SEZWOP - SEZ without payment, EXPWP - Export with Payment, EXPWOP - Export without payment,DEXP - Deemed Export\"\r\n" +
    		"                },\r\n" +
    		"                \"RegRev\": {\r\n" +
    		"                    \"enum\": [\"Y\", \"N\"],\r\n" +
    		"                    \"description\": \"Y- whether the tax liability is payable under reverse charge\"\r\n" +
    		"                },\r\n" +
    		"                \"EcmGstin\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"pattern\": \"^([0-9]{2}[0-9A-Z]{13})$\",\r\n" +
    		"                    \"description\": \"GSTIN of e-Commerce operator\"\r\n" +
    		"                },\r\n" +
    		"                \"IgstOnIntra\": {\r\n" +
    		"                  \"type\": \"string\",\r\n" +
    		"                  \"enum\": [\"Y\", \"N\"],\r\n" +
    		"                  \"description\": \"Y- indicates the supply is intra state but chargeable to IGST\"\r\n" +
    		"                }\r\n" +
    		"            },\r\n" +
    		"            \"required\": [\"TaxSch\", \"SupTyp\"]\r\n" +
    		"        },\r\n" +
    		"        \"DocDtls\": {\r\n" +
    		"            \"type\": \"object\",\r\n" +
    		"            \"properties\": {\r\n" +
    		"                \"Typ\": {\r\n" +
    		"                    \"enum\": [\"INV\", \"CRN\", \"DBN\", \"BIL\", \"BOE\", \"CHL\", \"OTH\", \"RCV\", \"RFV\", \"PMV\"],\r\n" +
    		"                    \"description\": \"Document Type: INV-INVOICE, CRN-CREDIT NOTE, DBN-DEBIT NOTE\"\r\n" +
    		"                },\r\n" +
    		"                \"No\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"pattern\": \"^[1-9A-Z]{1}[0-9A-Z/-]{0,15}$\",\r\n" +
    		"                    \"description\": \"Document Number\"\r\n" +
    		"                },\r\n" +
    		"                \"Dt\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\r\n" +
    		"                    \"description\": \"Document Date\"\r\n" +
    		"                }\r\n" +
    		"            },\r\n" +
    		"            \"required\": [\"Typ\", \"No\", \"Dt\"]\r\n" +
    		"        },\r\n" +
    		"        \"SellerDtls\": {\r\n" +
    		"            \"type\": \"object\",\r\n" +
    		"            \"properties\": {\r\n" +
    		"                \"Gstin\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"pattern\": \"^([0-9]{2}[0-9A-Z]{13})$\",\r\n" +
    		"                    \"description\": \"GSTIN\"\r\n" +
    		"                },\r\n" +
    		"                \"LglNm\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Legal Name\"\r\n" +
    		"                },\r\n" +
    		"                \"TrdNm\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Tradename\"\r\n" +
    		"                },\r\n" +
    		"                \"Addr1\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Building/Flat no, Road/Street\"\r\n" +
    		"                },\r\n" +
    		"                \"Addr2\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Address 2 of the supplier (Floor no., Name of the premises/building)\"\r\n" +
    		"                },\r\n" +
    		"                \"Loc\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 50,\r\n" +
    		"                    \"description\": \"Location\"\r\n" +
    		"                },\r\n" +
    		"                \"Pin\": {\r\n" +
    		"                  \"type\": \"number\",\r\n" +
    		"                  \"minimum\": 100000,\r\n" +
    		"                  \"maximum\": 999999,\r\n" +
    		"                  \"description\": \"Pincode\"\r\n" +
    		"                },\r\n" +
    		"                \"Stcd\": {\r\n" +
    		"                  \"enum\": [\"01\", \"02\", \"03\", \"04\", \"05\", \"06\", \"07\", \"08\", \"09\", \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\", \"10\", \"11\", \"12\", \"13\", \"14\", \"15\", \"16\", \"17\", \"18\", \"19\", \"20\", \"21\", \"22\", \"23\", \"24\", \"25\", \"26\", \"27\", \"28\", \"29\", \"30\", \"31\", \"32\", \"33\", \"34\", \"35\", \"36\", \"37\", \"96\", \"97\", \"38\", \"99\"],\r\n" +
    		"                  \"description\": \"State Code of the supplier. Refer the master\"\r\n" +
    		"                },\r\n" +
    		"                \"Ph\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 6,\r\n" +
    		"                    \"maxLength\": 12,\r\n" +
    		"                    \"description\": \"Phone or Mobile No.\"\r\n" +
    		"                },\r\n" +
    		"                \"Em\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 6,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Email-Id\"\r\n" +
    		"                }\r\n" +
    		"            },\r\n" +
    		"            \"required\": [\"Gstin\", \"LglNm\", \"Addr1\", \"Loc\", \"Pin\", \"Stcd\"]\r\n" +
    		"        },\r\n" +
    		"        \"BuyerDtls\": {\r\n" +
    		"            \"type\": \"object\",\r\n" +
    		"            \"properties\": {\r\n" +
    		"                \"Gstin\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"pattern\": \"^([0-9]{2}[0-9A-Z]{13}|URP)$\",\r\n" +
    		"                    \"description\": \"GSTIN of buyer , URP if exporting\"\r\n" +
    		"                },\r\n" +
    		"                \"LglNm\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Legal Name\"\r\n" +
    		"                },\r\n" +
    		"                \"TrdNm\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Tradename\"\r\n" +
    		"                },\r\n" +
    		"                \"Pos\": {\r\n" +
    		"                    \"enum\": [\"01\", \"02\", \"03\", \"04\", \"05\", \"06\", \"07\", \"08\", \"09\", \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\", \"10\", \"11\", \"12\", \"13\", \"14\", \"15\", \"16\", \"17\", \"18\", \"19\", \"20\", \"21\", \"22\", \"23\", \"24\", \"25\", \"26\", \"27\", \"28\", \"29\", \"30\", \"31\", \"32\", \"33\", \"34\", \"35\", \"36\", \"37\", \"96\", \"97\", \"38\", \"99\"],\r\n" +
    		"                    \"description\": \"State code of Place of supply. If POS lies outside the country, a the code shall be 96.\"\r\n" +
    		"                },\r\n" +
    		"                \"Addr1\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Building/Flat no, Road/Street\"\r\n" +
    		"                },\r\n" +
    		"                \"Addr2\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Address 2 of the supplier (Floor no., Name of the premises/building)\"\r\n" +
    		"                },\r\n" +
    		"                \"Loc\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Location\"\r\n" +
    		"                },\r\n" +
    		"                \"Pin\": {\r\n" +
    		"                  \"type\": \"number\",\r\n" +
    		"                  \"minimum\": 100000,\r\n" +
    		"                  \"maximum\": 999999,\r\n" +
    		"                  \"description\": \"Pincode\"\r\n" +
    		"                },\r\n" +
    		"                \"Stcd\": {\r\n" +
    		"                  \"enum\": [\"01\", \"02\", \"03\", \"04\", \"05\", \"06\", \"07\", \"08\", \"09\", \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\", \"10\", \"11\", \"12\", \"13\", \"14\", \"15\", \"16\", \"17\", \"18\", \"19\", \"20\", \"21\", \"22\", \"23\", \"24\", \"25\", \"26\", \"27\", \"28\", \"29\", \"30\", \"31\", \"32\", \"33\", \"34\", \"35\", \"36\", \"37\", \"96\", \"97\", \"38\", \"99\"],\r\n" +
    		"                  \"description\": \"State Name\"\r\n" +
    		"                },\r\n" +
    		"                \"Ph\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 6,\r\n" +
    		"                    \"maxLength\": 12,\r\n" +
    		"                    \"description\": \"Phone or Mobile No.\"\r\n" +
    		"                },\r\n" +
    		"                \"Em\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 6,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Email-Id\"\r\n" +
    		"                }\r\n" +
    		"            },\r\n" +
    		"            \"required\": [\"Gstin\", \"LglNm\", \"Pos\", \"Addr1\", \"Loc\", \"Stcd\"]\r\n" +
    		"        },\r\n" +
    		"        \"DispDtls\": {\r\n" +
    		"            \"type\": \"object\",\r\n" +
    		"            \"properties\": {\r\n" +
    		"                \"Nm\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Name of the company from which the goods are dispatched\"\r\n" +
    		"                },\r\n" +
    		"                \"Addr1\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Building/Flat no, Road/Street\"\r\n" +
    		"                },\r\n" +
    		"                \"Addr2\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Address 2 of the supplier (Floor no., Name of the premises/building)\"\r\n" +
    		"                },\r\n" +
    		"                \"Loc\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Location\"\r\n" +
    		"                },\r\n" +
    		"                \"Pin\": {\r\n" +
    		"                  \"type\": \"number\",\r\n" +
    		"                  \"minimum\": 100000,\r\n" +
    		"                  \"maximum\": 999999,\r\n" +
    		"                  \"description\": \"Pincode\"\r\n" +
    		"                },\r\n" +
    		"                \"Stcd\": {\r\n" +
    		"                    \"enum\": [\"01\", \"02\", \"03\", \"04\", \"05\", \"06\", \"07\", \"08\", \"09\", \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\", \"10\", \"11\", \"12\", \"13\", \"14\", \"15\", \"16\", \"17\", \"18\", \"19\", \"20\", \"21\", \"22\", \"23\", \"24\", \"25\", \"26\", \"27\", \"28\", \"29\", \"30\", \"31\", \"32\", \"33\", \"34\", \"35\", \"36\", \"37\", \"96\", \"97\", \"38\", \"99\"],\r\n" +
    		"                    \"description\": \"State Code\"\r\n" +
    		"                }\r\n" +
    		"            },\r\n" +
    		"            \"required\": [\"Nm\", \"Addr1\", \"Loc\", \"Pin\", \"Stcd\"]\r\n" +
    		"        },\r\n" +
    		"        \"ShipDtls\": {\r\n" +
    		"            \"type\": \"object\",\r\n" +
    		"            \"properties\": {\r\n" +
    		"                \"Gstin\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"pattern\": \"^([0-9]{2}[0-9A-Z]{13}|URP)$\",\r\n" +
    		"                    \"description\": \"GSTIN of entity to whom goods are shipped\"\r\n" +
    		"                },\r\n" +
    		"                \"LglNm\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Legal Name\"\r\n" +
    		"                },\r\n" +
    		"                \"TrdNm\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Tradename\"\r\n" +
    		"                },\r\n" +
    		"                \"Addr1\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Address1 of the entity to whom the supplies are shipped to. (Building/Flat no., Road/Street etc.)\"\r\n" +
    		"                },\r\n" +
    		"                \"Addr2\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Address 2 of the entity to whom the supplies are shipped to. (Floor no., Name of the premises/building).\"\r\n" +
    		"                },\r\n" +
    		"                \"Loc\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Place (City,Town,Village) entity to whom the supplies are shipped to.\"\r\n" +
    		"                },\r\n" +
    		"                \"Pin\": {\r\n" +
    		"                  \"type\": \"number\",\r\n" +
    		"                  \"minimum\": 100000,\r\n" +
    		"                  \"maximum\": 999999,\r\n" +
    		"                  \"description\": \"Pincode\"\r\n" +
    		"                },\r\n" +
    		"                \"Stcd\": {\r\n" +
    		"                    \"enum\": [\"01\", \"02\", \"03\", \"04\", \"05\", \"06\", \"07\", \"08\", \"09\", \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\", \"10\", \"11\", \"12\", \"13\", \"14\", \"15\", \"16\", \"17\", \"18\", \"19\", \"20\", \"21\", \"22\", \"23\", \"24\", \"25\", \"26\", \"27\", \"28\", \"29\", \"30\", \"31\", \"32\", \"33\", \"34\", \"35\", \"36\", \"37\", \"96\", \"97\", \"38\", \"99\"],\r\n" +
    		"                    \"description\": \"State Code to which supplies are shipped to.\"\r\n" +
    		"                }\r\n" +
    		"            },\r\n" +
    		"            \"required\": [\"LglNm\", \"Addr1\", \"Loc\", \"Pin\", \"Stcd\"]\r\n" +
    		"        },\r\n" +
    		"        \"ItemList\": {\r\n" +
    		"            \"items\": {\r\n" +
    		"                \"properties\": {\r\n" +
    		"                    \"SlNo\": {\r\n" +
    		"                        \"type\": \"string\",\r\n" +
    		"                        \"pattern\": \"^[0-9]{1,6}$\",\r\n" +
    		"                        \"description\": \"Serial No. of Item\"\r\n" +
    		"                    },\r\n" +
    		"                    \"PrdDesc\": {\r\n" +
    		"                        \"type\": \"string\",\r\n" +
    		"                        \"minLength\": 3,\r\n" +
    		"                        \"maxLength\": 300,\r\n" +
    		"                        \"description\": \"Product Description\"\r\n" +
    		"                    },\r\n" +
    		"                    \"IsServc\": {\r\n" +
    		"                        \"enum\": [\"Y\", \"N\"],\r\n" +
    		"                        \"description\": \"Specify whether the supply is service or not. Specify Y-for Service\"\r\n" +
    		"                    },\r\n" +
    		"                    \"HsnCd\": {\r\n" +
    		"                        \"type\": \"string\",\r\n" +
    		"                        \"pattern\": \"^[0-9]{4,8}$\",\r\n" +
    		"                        \"description\": \"HSN Code\"\r\n" +
    		"                    },\r\n" +
    		"                    \"BchDtls\": {\r\n" +
    		"                        \"type\": \"object\",\r\n" +
    		"                        \"properties\": {\r\n" +
    		"                            \"Nm\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"minLength\": 3,\r\n" +
    		"                                \"maxLength\": 20,\r\n" +
    		"                                \"description\": \"Batch name\"\r\n" +
    		"                            },\r\n" +
    		"                            \"ExpDt\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\r\n" +
    		"                                \"description\": \"Batch Expiry Date\"\r\n" +
    		"                            },\r\n" +
    		"                            \"WrDt\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\r\n" +
    		"                                \"description\": \"Warranty Date\"\r\n" +
    		"                            }\r\n" +
    		"                        },\r\n" +
    		"                        \"required\": [\"Nm\"]\r\n" +
    		"                    },\r\n" +
    		"                    \"Barcde\": {\r\n" +
    		"                        \"type\": \"string\",\r\n" +
    		"                        \"minLength\": 3,\r\n" +
    		"                        \"maxLength\": 30,\r\n" +
    		"                        \"description\": \"Bar Code\"\r\n" +
    		"                    },\r\n" +
    		"                    \"Qty\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 9999999999.999,\r\n" +
    		"                        \"description\": \"Quantity\"\r\n" +
    		"                    },\r\n" +
    		"                    \"FreeQty\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 9999999999.999,\r\n" +
    		"                        \"description\": \"Free Quantity\"\r\n" +
    		"                    },\r\n" +
    		"                    \"Unit\": {\r\n" +
    		"                        \"enum\": [\"BAG\", \"BAL\", \"BDL\", \"BGS\", \"BKL\", \"BND\", \"BOU\", \"BOX\", \"BTL\", \"BUN\", \"CAN\", \"CBM\", \"CCM\", \"CMS\", \"CMT\", \"CTN\", \"DOZ\", \"DRM\", \"DZN\", \"GGK\", \"GMS\", \"GRS\", \"GYD\", \"KGS\", \"KLR\", \"KME\", \"KMS\", \"LTR\", \"MLS\", \"MLT\", \"MTR\", \"MTS\", \"NOS\", \"OTH\", \"PAC\", \"PAR\", \"PCS\", \"PRS\", \"QTL\", \"QTS\", \"ROL\", \"SET\", \"SFT\", \"SMT\", \"SNO\", \"SQF\", \"SQM\", \"SQY\", \"TBS\", \"TGM\", \"THD\", \"TON\", \"TUB\", \"UGS\", \"UNT\", \"YDS\"],\r\n" +
    		"                        \"description\": \"Unit\"\r\n" +
    		"                    },\r\n" +
    		"                    \"UnitPrice\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.999,\r\n" +
    		"                        \"description\": \"Unit Price - Rate\"\r\n" +
    		"                    },\r\n" +
    		"                    \"TotAmt\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.99,\r\n" +
    		"                        \"description\": \"Gross Amount (Unit Price * Quantity)\"\r\n" +
    		"                    },\r\n" +
    		"                    \"Discount\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.99,\r\n" +
    		"                        \"description\": \"Discount\"\r\n" +
    		"                    },\r\n" +
    		"                    \"PreTaxVal\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.99,\r\n" +
    		"                        \"description\": \"Pre tax value\"\r\n" +
    		"                    },\r\n" +
    		"                    \"AssAmt\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.99,\r\n" +
    		"                        \"description\": \"Taxable Value (Total Amount -Discount)\"\r\n" +
    		"                    },\r\n" +
    		"                    \"GstRt\": {\r\n" +
    		"                        \"enum\": [0, 0.1, 0.25, 1, 1.5, 3, 5, 7.5, 12, 18, 28],\r\n" +
    		"                        \"description\": \"The GST rate, represented as percentage that applies to the invoiced item. It will IGST rate only.\"\r\n" +
    		"                    },\r\n" +
    		"                    \"IgstAmt\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.99,\r\n" +
    		"                        \"description\": \" Amount of IGST payable.\"\r\n" +
    		"                    },\r\n" +
    		"                    \"CgstAmt\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.99,\r\n" +
    		"                        \"description\": \" Amount of CGST payable.\"\r\n" +
    		"                    },\r\n" +
    		"                    \"SgstAmt\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.99,\r\n" +
    		"                        \"description\": \" Amount of SGST payable.\"\r\n" +
    		"                    },\r\n" +
    		"                    \"CesRt\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999.999,\r\n" +
    		"                        \"description\": \"Cess Rate\"\r\n" +
    		"                    },\r\n" +
    		"                    \"CesAmt\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.99,\r\n" +
    		"                        \"description\": \"Cess Amount(Advalorem) on basis of rate and quantity of item\"\r\n" +
    		"                    },\r\n" +
    		"                    \"CesNonAdvlAmt\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.99,\r\n" +
    		"                        \"description\": \"Cess Non-Advol Amount\"\r\n" +
    		"                    },\r\n" +
    		"                    \"StateCesRt\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999.999,\r\n" +
    		"                        \"description\": \"State CESS Rate\"\r\n" +
    		"                    },\r\n" +
    		"                    \"StateCesAmt\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.99,\r\n" +
    		"                        \"description\": \"State CESS Amount\"\r\n" +
    		"                    },\r\n" +
    		"                    \"StateCesNonAdvlAmt\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.99,\r\n" +
    		"                        \"description\": \"State CESS Non Adval Amount\"\r\n" +
    		"                    },\r\n" +
    		"                    \"OthChrg\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.99,\r\n" +
    		"                        \"description\": \"Other Charges\"\r\n" +
    		"                    },\r\n" +
    		"                    \"TotItemVal\": {\r\n" +
    		"                        \"type\": \"number\",\r\n" +
    		"                        \"minimum\": 0,\r\n" +
    		"                        \"maximum\": 999999999999.99,\r\n" +
    		"                        \"description\": \"Total Item Value = Assessable Amount + CGST Amt + SGST Amt + Cess Amt + CesNonAdvlAmt + StateCesAmt + StateCesNonAdvlAmt+Otherchrg\"\r\n" +
    		"                    },\r\n" +
    		"                    \"OrdLineRef\": {\r\n" +
    		"                        \"type\": \"string\",\r\n" +
    		"                        \"minLength\": 1,\r\n" +
    		"                        \"maxLength\": 50,\r\n" +
    		"                        \"description\": \"Order line referencee\"\r\n" +
    		"                    },\r\n" +
    		"                    \"OrgCntry\": {\r\n" +
    		"                        \"enum\": [\"AD\", \"AE\", \"AF\", \"AG\", \"AI\", \"AL\", \"AM\", \"AO\", \"AQ\", \"AR\", \"AS\", \"AT\", \"AU\", \"AW\", \"AX\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BL\", \"BM\", \"BN\", \"BO\", \"BQ\", \"BR\", \"BS\", \"BT\", \"BV\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CC\", \"CD\", \"CF\", \"CG\", \"CH\", \"CI\", \"CK\", \"CL\", \"CM\", \"CN\", \"CO\", \"CR\", \"CU\", \"CV\", \"CW\", \"CX\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"EH\", \"ER\", \"ES\", \"ET\", \"FI\", \"FJ\", \"FK\", \"FM\", \"FO\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GF\", \"GG\", \"GH\", \"GI\", \"GL\", \"GM\", \"GN\", \"GP\", \"GQ\", \"GR\", \"GS\", \"GT\", \"GU\", \"GW\", \"GY\", \"HK\", \"HM\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IM\", \"IN\", \"IO\", \"IQ\", \"IR\", \"IS\", \"IT\", \"JE\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KP\", \"KR\", \"KW\", \"KY\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MF\", \"MG\", \"MH\", \"MK\", \"ML\", \"MM\", \"MN\", \"MO\", \"MP\", \"MQ\", \"MR\", \"MS\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NC\", \"NE\", \"NF\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NU\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PF\", \"PG\", \"PH\", \"PK\", \"PL\", \"PM\", \"PN\", \"PR\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RE\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SD\", \"SE\", \"SG\", \"SH\", \"SI\", \"SJ\", \"SK\", \"SL\", \"SM\", \"SN\", \"SO\", \"SR\", \"SS\", \"ST\", \"SV\", \"SX\", \"SY\", \"SZ\", \"TC\", \"TD\", \"TF\", \"TG\", \"TH\", \"TJ\", \"TK\", \"TL\", \"TM\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"UM\", \"US\", \"UY\", \"UZ\", \"VA\", \"VC\", \"VE\", \"VG\", \"VI\", \"VN\", \"VU\", \"WF\", \"WS\", \"YE\", \"YT\", \"ZA\", \"ZM\", \"ZW\"],\r\n" +
    		"                        \"description\": \"Orgin Country\"\r\n" +
    		"                    },\r\n" +
    		"                    \"PrdSlNo\": {\r\n" +
    		"                        \"type\": \"string\",\r\n" +
    		"                        \"minLength\": 1,\r\n" +
    		"                        \"maxLength\": 20,\r\n" +
    		"                        \"description\": \"Serial number in case of each item having a unique number.\"\r\n" +
    		"                    },\r\n" +
    		"                    \"AttribDtls\": {\r\n" +
    		"                        \"type\": \"array\",\r\n" +
    		"                        \"items\": {\r\n" +
    		"                            \"type\": \"object\",\r\n" +
    		"                            \"properties\": {\r\n" +
    		"                                \"Nm\": {\r\n" +
    		"                                    \"type\": \"string\",\r\n" +
    		"                                    \"minLength\": 1,\r\n" +
    		"                                    \"maxLength\": 100,\r\n" +
    		"                                    \"description\": \"Attribute details of the item\"\r\n" +
    		"                                },\r\n" +
    		"                                \"Val\": {\r\n" +
    		"                                    \"type\": \"string\",\r\n" +
    		"                                    \"minLength\": 1,\r\n" +
    		"                                    \"maxLength\": 100,\r\n" +
    		"                                    \"description\": \"Attribute value of the item\"\r\n" +
    		"                                }\r\n" +
    		"                            }\r\n" +
    		"                        }\r\n" +
    		"                    }\r\n" +
    		"                },\r\n" +
    		"                \"required\": [\"SlNo\", \"IsServc\", \"HsnCd\", \"UnitPrice\", \"TotAmt\", \"AssAmt\", \"GstRt\", \"TotItemVal\"],\r\n" +
    		"                \"type\": \"object\"\r\n" +
    		"            },\r\n" +
    		"            \"contains\": {\r\n" +
    		"                \"type\": \"object\"\r\n" +
    		"            },\r\n" +
    		"            \"type\": \"array\"\r\n" +
    		"        },\r\n" +
    		"        \"ValDtls\": {\r\n" +
    		"            \"type\": \"object\",\r\n" +
    		"            \"properties\": {\r\n" +
    		"                \"AssVal\": {\r\n" +
    		"                    \"type\": \"number\",\r\n" +
    		"                    \"minimum\": 0,\r\n" +
    		"                    \"maximum\": 99999999999999.99,\r\n" +
    		"                    \"description\": \"Total Assessable value of all items\"\r\n" +
    		"                },\r\n" +
    		"                \"CgstVal\": {\r\n" +
    		"                    \"type\": \"number\",\r\n" +
    		"                    \"maximum\": 99999999999999.99,\r\n" +
    		"                    \"minimum\": 0,\r\n" +
    		"                    \"description\": \"Total CGST value of all items\"\r\n" +
    		"                },\r\n" +
    		"                \"SgstVal\": {\r\n" +
    		"                    \"type\": \"number\",\r\n" +
    		"                    \"minimum\": 0,\r\n" +
    		"                    \"maximum\": 99999999999999.99,\r\n" +
    		"                    \"description\": \"Total SGST value of all items\"\r\n" +
    		"                },\r\n" +
    		"                \"IgstVal\": {\r\n" +
    		"                    \"type\": \"number\",\r\n" +
    		"                    \"minimum\": 0,\r\n" +
    		"                    \"maximum\": 99999999999999.99,\r\n" +
    		"                    \"description\": \"Total IGST value of all items\"\r\n" +
    		"                },\r\n" +
    		"                \"CesVal\": {\r\n" +
    		"                    \"type\": \"number\",\r\n" +
    		"                    \"minimum\": 0,\r\n" +
    		"                    \"maximum\": 99999999999999.99,\r\n" +
    		"                    \"description\": \"Total CESS value of all items\"\r\n" +
    		"                },\r\n" +
    		"                \"StCesVal\": {\r\n" +
    		"                    \"type\": \"number\",\r\n" +
    		"                    \"minimum\": 0,\r\n" +
    		"                    \"maximum\": 99999999999999.99,\r\n" +
    		"                    \"description\": \"Total State CESS value of all items\"\r\n" +
    		"                },\r\n" +
    		"                \"Discount\": {\r\n" +
    		"                  \"type\": \"number\",\r\n" +
    		"                  \"minimum\": 0,\r\n" +
    		"                  \"maximum\": 99999999999999.99,\r\n" +
    		"                  \"description\": \"Discount\"\r\n" +
    		"                },\r\n" +
    		"                \"OthChrg\": {\r\n" +
    		"                  \"type\": \"number\",\r\n" +
    		"                  \"minimum\": 0,\r\n" +
    		"                  \"maximum\": 99999999999999.99,\r\n" +
    		"                  \"description\": \"Other Charges\"\r\n" +
    		"                },\r\n" +
    		"                \"RndOffAmt\": {\r\n" +
    		"                    \"type\": \"number\",\r\n" +
    		"                    \"minimum\": 0,\r\n" +
    		"                    \"maximum\": 99.99,\r\n" +
    		"                    \"description\": \"Rounded off amount\"\r\n" +
    		"                },\r\n" +
    		"                \"TotInvVal\": {\r\n" +
    		"                    \"type\": \"number\",\r\n" +
    		"                    \"minimum\": 0,\r\n" +
    		"                    \"maximum\": 99999999999999.99,\r\n" +
    		"                    \"description\": \"Final Invoice value \"\r\n" +
    		"                },\r\n" +
    		"                \"TotInvValFc\": {\r\n" +
    		"                    \"type\": \"number\",\r\n" +
    		"                    \"minimum\": 0,\r\n" +
    		"                    \"maximum\": 99999999999999.99,\r\n" +
    		"                    \"description\": \"Final Invoice value in Additional Currency\"\r\n" +
    		"                }\r\n" +
    		"            },\r\n" +
    		"            \"required\": [\"AssVal\", \"TotInvVal\"]\r\n" +
    		"        },\r\n" +
    		"        \"PayDtls\": {\r\n" +
    		"            \"type\": \"object\",\r\n" +
    		"            \"properties\": {\r\n" +
    		"                \"Nm\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 1,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Payee Name\"\r\n" +
    		"                },\r\n" +
    		"                \"AccDet\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 1,\r\n" +
    		"                    \"maxLength\": 18,\r\n" +
    		"                    \"description\": \"Bank account number of payee\"\r\n" +
    		"                },\r\n" +
    		"                \"Mode\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 1,\r\n" +
    		"                    \"maxLength\": 18,\r\n" +
    		"                    \"description\": \"Mode of Payment: Cash, Credit, Direct Transfer\"\r\n" +
    		"                },\r\n" +
    		"                \"FinInsBr\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 1,\r\n" +
    		"                    \"maxLength\": 11,\r\n" +
    		"                    \"description\": \"Branch or IFSC code\"\r\n" +
    		"                },\r\n" +
    		"                \"PayTerm\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 1,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Terms of Payment\"\r\n" +
    		"                },\r\n" +
    		"                \"PayInstr\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 1,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Payment Instruction\"\r\n" +
    		"                },\r\n" +
    		"                \"CrTrn\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 1,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Credit Transfer\"\r\n" +
    		"                },\r\n" +
    		"                \"DirDr\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 1,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Direct Debit\"\r\n" +
    		"                },\r\n" +
    		"                \"CrDay\": {\r\n" +
    		"                    \"type\": \"number\",\r\n" +
    		"                    \"minimum\": 0,\r\n" +
    		"                    \"maximum\": 9999,\r\n" +
    		"                    \"description\": \"Credit Days\"\r\n" +
    		"                },\r\n" +
    		"                \"PaidAmt\": {\r\n" +
    		"                    \"type\": \"number\",\r\n" +
    		"                    \"minimum\": 0,\r\n" +
    		"                    \"maximum\": 99999999999999.99,\r\n" +
    		"                    \"description\": \"The sum of amount which have been paid in advance.\"\r\n" +
    		"                },\r\n" +
    		"                \"PaymtDue\": {\r\n" +
    		"                    \"type\": \"number\",\r\n" +
    		"                    \"minimum\": 0,\r\n" +
    		"                    \"maximum\": 99999999999999.99,\r\n" +
    		"                    \"description\": \"Outstanding amount that is required to be paid.\"\r\n" +
    		"                }\r\n" +
    		"            }\r\n" +
    		"        },\r\n" +
    		"        \"RefDtls\": {\r\n" +
    		"            \"type\": \"object\",\r\n" +
    		"            \"properties\": {\r\n" +
    		"                \"InvRm\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"pattern\": \"^[0-9A-Za-z/-]{3,100}$\",\r\n" +
    		"                    \"description\": \"Remarks/Note\"\r\n" +
    		"                },\r\n" +
    		"                \"DocPerdDtls\": {\r\n" +
    		"                  \"type\": \"object\",\r\n" +
    		"                  \"properties\": {\r\n" +
    		"                    \"InvStDt\": {\r\n" +
    		"                      \"type\": \"string\",\r\n" +
    		"                      \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\r\n" +
    		"                      \"description\": \"Invoice Period Start Date\"\r\n" +
    		"                    },\r\n" +
    		"                    \"InvEndDt\": {\r\n" +
    		"                      \"type\": \"string\",\r\n" +
    		"                      \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\r\n" +
    		"                      \"description\": \"Invoice Period End Date\"\r\n" +
    		"                    }\r\n" +
    		"                  },\r\n" +
    		"                  \"required\": [\"InvStDt\", \"InvEndDt\"]\r\n" +
    		"                },\r\n" +
    		"                \"PrecDocDtls\": {\r\n" +
    		"                    \"type\": \"array\",\r\n" +
    		"                    \"items\": {\r\n" +
    		"                        \"type\": \"object\",\r\n" +
    		"                        \"properties\": {\r\n" +
    		"                            \"InvNo\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"pattern\": \"^[1-9A-Z]{1}[0-9A-Z/-]{3,15}$\",\r\n" +
    		"                                \"description\": \"Reference of original invoice, if any.\"\r\n" +
    		"                            },\r\n" +
    		"                            \"InvDt\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\r\n" +
    		"                                \"description\": \"Date of preceding invoice\"\r\n" +
    		"                            },\r\n" +
    		"                            \"OthRefNo\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"minLength\": 1,\r\n" +
    		"                                \"maxLength\": 20,\r\n" +
    		"                                \"description\": \"Other Reference\"\r\n" +
    		"                            }\r\n" +
    		"                        },\r\n" +
    		"                        \"required\": [\"InvNo\", \"InvDt\"]\r\n" +
    		"                    }\r\n" +
    		"                },\r\n" +
    		"                \"ContrDtls\": {\r\n" +
    		"                    \"type\": \"array\",\r\n" +
    		"                    \"items\": {\r\n" +
    		"                        \"type\": \"object\",\r\n" +
    		"                        \"properties\": {\r\n" +
    		"                            \"RecAdvRefr\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"pattern\": \"^([0-9A-Za-z/-]){1,20}$\",\r\n" +
    		"                                \"description\": \"Receipt Advice No.\"\r\n" +
    		"                            },\r\n" +
    		"                            \"RecAdvDt\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\r\n" +
    		"                                \"description\": \"Date of receipt advice\"\r\n" +
    		"                            },\r\n" +
    		"                            \"TendRefr\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"pattern\": \"^([0-9A-Za-z/-]){1,20}$\",\r\n" +
    		"                                \"description\": \"Lot/Batch Reference No.\"\r\n" +
    		"                            },\r\n" +
    		"                            \"ContrRefr\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"pattern\": \"^([0-9A-Za-z/-]){1,20}$\",\r\n" +
    		"                                \"description\": \"Contract Reference Number\"\r\n" +
    		"                            },\r\n" +
    		"                            \"ExtRefr\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"pattern\": \"^([0-9A-Za-z/-]){1,20}$\",\r\n" +
    		"                                \"description\": \"Any other reference\"\r\n" +
    		"                            },\r\n" +
    		"                            \"ProjRefr\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"pattern\": \"^([0-9A-Za-z/-]){1,20}$\",\r\n" +
    		"                                \"description\": \"Project Reference Number\"\r\n" +
    		"                            },\r\n" +
    		"                            \"PORefr\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"pattern\": \"^([0-9A-Za-z/-]){1,16}$\",\r\n" +
    		"                                \"description\": \"Vendor PO Reference Number\"\r\n" +
    		"                            },\r\n" +
    		"                            \"PORefDt\": {\r\n" +
    		"                                \"type\": \"string\",\r\n" +
    		"                                \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\r\n" +
    		"                                \"description\": \"Vendor PO Reference date\"\r\n" +
    		"                            }\r\n" +
    		"                        }\r\n" +
    		"                    }\r\n" +
    		"                }\r\n" +
    		"            }\r\n" +
    		"        },\r\n" +
    		"        \"AddlDocDtls\": {\r\n" +
    		"            \"type\": \"array\",\r\n" +
    		"            \"items\": {\r\n" +
    		"                \"type\": \"object\",\r\n" +
    		"                \"properties\": {\r\n" +
    		"                    \"Url\": {\r\n" +
    		"                        \"type\": \"string\",\r\n" +
    		"                        \"minLength\": 3,\r\n" +
    		"                        \"maxLength\": 100,\r\n" +
    		"                        \"description\": \"Supporting document URL\"\r\n" +
    		"                    },\r\n" +
    		"                    \"Docs\": {\r\n" +
    		"                        \"type\": \"string\",\r\n" +
    		"                        \"minLength\": 3,\r\n" +
    		"                        \"maxLength\": 1000,\r\n" +
    		"                        \"description\": \"Supporting document in Base64 Format\"\r\n" +
    		"                    },\r\n" +
    		"                    \"Info\": {\r\n" +
    		"                        \"type\": \"string\",\r\n" +
    		"                        \"minLength\": 3,\r\n" +
    		"                        \"maxLength\": 1000,\r\n" +
    		"                        \"description\": \"Any additional information\"\r\n" +
    		"                    }\r\n" +
    		"                }\r\n" +
    		"            }\r\n" +
    		"        },\r\n" +
    		"        \"ExpDtls\": {\r\n" +
    		"            \"type\": \"object\",\r\n" +
    		"            \"properties\": {\r\n" +
    		"                \"ShipBNo\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 1,\r\n" +
    		"                    \"maxLength\": 20,\r\n" +
    		"                    \"description\": \"Shipping Bill No.\"\r\n" +
    		"                },\r\n" +
			"     \"ExpDuty\": {\r\n" +
			"                    \"type\": \"number\",\r\n" +
			"                    \"minimum\": 0,\r\n" +
			"                    \"maximum\": 99999999999999.99,\r\n" +
			"                    \"description\": \"Export Duty\"\r\n" +
			"                },\r\n" +
			"               \r\n" +
			"                \"ShipBDt\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\r\n" +
    		"                    \"description\": \"Shipping Bill Date\"\r\n" +
    		"                },\r\n" +
    		"                \"Port\": {\r\n" +
    		"                    \"enum\": [\"INABG1\", \"INACH1\", \"INADA6\", \"INADI1\", \"INAGI1\", \"INAGR4\", \"INAGR5\", \"INAGR6\", \"INAGTB\", \"INAGX4\", \"INAHD6\", \"INAIG6\", \"INAII6\", \"INAIK6\", \"INAIR6\", \"INAJE6\", \"INAJJ6\", \"INAJL4\", \"INAJM6\", \"INAKB6\", \"INAKD4\", \"INAKP6\", \"INAKR6\", \"INAKV6\", \"INALA1\", \"INALF1\", \"INAMD4\", \"INAMD5\", \"INAMD6\", \"INAMG6\", \"INAMI1\", \"INAMK6\", \"INANG1\", \"INANL1\", \"INAPI6\", \"INAPL6\", \"INAPT6\", \"INARR6\", \"INASR2\", \"INASR6\", \"INATQ4\", \"INATQ6\", \"INATRB\", \"INATT2\", \"INAWM6\", \"INAWS6\", \"INAWW6\", \"INAZK1\", \"INBAG6\", \"INBAI6\", \"INBAM6\", \"INBAP6\", \"INBAT6\", \"INBAU6\", \"INBAW6\", \"INBBI4\", \"INBBM6\", \"INBBP1\", \"INBBS6\", \"INBCH6\", \"INBCO6\", \"INBCP6\", \"INBDB6\", \"INBDG1\", \"INBDH6\", \"INBDI6\", \"INBDM6\", \"INBDQ1\", \"INBDR1\", \"INBED1\", \"INBEK4\", \"INBEP4\", \"INBET1\", \"INBEY1\", \"INBFR6\", \"INBGK6\", \"INBGMB\", \"INBGQ6\", \"INBGUB\", \"INBGW1\", \"INBHC6\", \"INBHD6\", \"INBHJ4\", \"INBHL6\", \"INBHM1\", \"INBHO4\", \"INBHS6\", \"INBHU1\", \"INBHU4\", \"INBKB4\", \"INBKR1\", \"INBKT1\", \"INBLC6\", \"INBLE6\", \"INBLJ6\", \"INBLK1\", \"INBLM1\", \"INBLP1\", \"INBLR4\", \"INBLR5\", \"INBLR6\", \"INBLTB\", \"INBLV6\", \"INBMA6\", \"INBMR2\", \"INBNC6\", \"INBND1\", \"INBNG6\", \"INBNK6\", \"INBNP1\", \"INBNRB\", \"INBNT6\", \"INBNW6\", \"INBNX6\", \"INBNYB\", \"INBOK6\", \"INBOLB\", \"INBOM1\", \"INBOM4\", \"INBOM5\", \"INBOM6\", \"INBPL5\", \"INBPS5\", \"INBRAB\", \"INBRC6\", \"INBRH1\", \"INBRI6\", \"INBRL6\", \"INBRM1\", \"INBRS6\", \"INBRY1\", \"INBSAB\", \"INBSB6\", \"INBSL6\", \"INBSN1\", \"INBSR1\", \"INBSW6\", \"INBTK1\", \"INBTMB\", \"INBTR1\", \"INBUD1\", \"INBUL6\", \"INBUP4\", \"INBUP6\", \"INBVC6\", \"INBWD6\", \"INBWN1\", \"INBXR6\", \"INBYT1\", \"INCAG6\", \"INCAM1\", \"INCAP1\", \"INCAR1\", \"INCAS6\", \"INCBC6\", \"INCBD4\", \"INCBDB\", \"INCBE6\", \"INCBL1\", \"INCBS6\", \"INCCH6\", \"INCCI6\", \"INCCJ1\", \"INCCJ4\", \"INCCP6\", \"INCCQ6\", \"INCCT6\", \"INCCU1\", \"INCCU4\", \"INCCU5\", \"INCCW6\", \"INCDC6\", \"INCDD6\", \"INCDL1\", \"INCDP1\", \"INCDP4\", \"INCDP6\", \"INCDQ6\", \"INCDR6\", \"INCEC6\", \"INCGA6\", \"INCGE6\", \"INCGI6\", \"INCGL6\", \"INCHE6\", \"INCHJ6\", \"INCHL1\", \"INCHMB\", \"INCHN6\", \"INCHPB\", \"INCHR1\", \"INCJA6\", \"INCJB4\", \"INCJB6\", \"INCJC6\", \"INCJD6\", \"INCJE6\", \"INCJF6\", \"INCJH6\", \"INCJI6\", \"INCJJ6\", \"INCJN6\", \"INCJO6\", \"INCJS6\", \"INCLK6\", \"INCLU6\", \"INCLX6\", \"INCMB1\", \"INCML6\", \"INCNB1\", \"INCNC6\", \"INCNN1\", \"INCOA6\", \"INCOH4\", \"INCOK1\", \"INCOK4\", \"INCOK6\", \"INCOL1\", \"INCOO1\", \"INCOP6\", \"INCPC6\", \"INCPL6\", \"INCPR6\", \"INCRL6\", \"INCRN1\", \"INCRW6\", \"INCRXB\", \"INCSP6\", \"INCSV6\", \"INCTI1\", \"INCUM1\", \"INDAE4\", \"INDAH1\", \"INDAI4\", \"INDAM1\", \"INDAM4\", \"INDAR6\", \"INDBD4\", \"INDBS6\", \"INDDL6\", \"INDEA6\", \"INDED4\", \"INDEF6\", \"INDEG1\", \"INDEH6\", \"INDEI6\", \"INDEJ6\", \"INDEL4\", \"INDEL5\", \"INDEM6\", \"INDEN6\", \"INDEP4\", \"INDER6\", \"INDES6\", \"INDET6\", \"INDEU6\", \"INDEW6\", \"INDGI6\", \"INDGT6\", \"INDHA6\", \"INDHBB\", \"INDHLB\", \"INDHM4\", \"INDHN1\", \"INDHP1\", \"INDHR1\", \"INDHU1\", \"INDIB4\", \"INDID6\", \"INDIG1\", \"INDIG6\", \"INDIT6\", \"INDIU1\", \"INDIU4\", \"INDIV1\", \"INDLAB\", \"INDLH6\", \"INDLI2\", \"INDLOB\", \"INDLUB\", \"INDMA1\", \"INDMRB\", \"INDMT1\", \"INDMU4\", \"INDPC4\", \"INDPR6\", \"INDRC6\", \"INDRGB\", \"INDRK1\", \"INDRL1\", \"INDRU6\", \"INDSK1\", \"INDSM6\", \"INDTW1\", \"INDUR6\", \"INDWA1\", \"INDWKB\", \"INDWN6\", \"INDWR6\", \"INENR1\", \"INERP6\", \"INERV6\", \"INESH1\", \"INFBD6\", \"INFBE6\", \"INFBM6\", \"INFBP6\", \"INFBRB\", \"INFBS6\", \"INFCH5\", \"INFLT6\", \"INFMA6\", \"INFMH6\", \"INFMJ6\", \"INFMS6\", \"INGAIB\", \"INGALB\", \"INGAO6\", \"INGAS6\", \"INGAU1\", \"INGAU2\", \"INGAU4\", \"INGAU5\", \"INGAW2\", \"INGAY4\", \"INGDL6\", \"INGDM6\", \"INGDP6\", \"INGED2\", \"INGGA1\", \"INGGB6\", \"INGGC6\", \"INGGD6\", \"INGGE6\", \"INGGF6\", \"INGGG6\", \"INGGI6\", \"INGGL6\", \"INGGM6\", \"INGGN2\", \"INGGO6\", \"INGGP6\", \"INGGS6\", \"INGGU6\", \"INGGV1\", \"INGHA1\", \"INGHC6\", \"INGHPB\", \"INGHR6\", \"INGHWB\", \"INGID6\", \"INGIN6\", \"INGJIB\", \"INGJXB\", \"INGKJ2\", \"INGKJB\", \"INGLY6\", \"INGMI6\", \"INGNA6\", \"INGNC6\", \"INGNG6\", \"INGNL6\", \"INGNP6\", \"INGNR6\", \"INGNT6\", \"INGOI4\", \"INGOP4\", \"INGPB6\", \"INGPR1\", \"INGRD6\", \"INGRL6\", \"INGRN6\", \"INGRR6\", \"INGRS6\", \"INGRW6\", \"INGTGB\", \"INGTI6\", \"INGTR2\", \"INGTS6\", \"INGTZB\", \"INGUX4\", \"INGWL4\", \"INGWL6\", \"INGWM4\", \"INHAL1\", \"INHAN6\", \"INHAO6\", \"INHAS6\", \"INHBB6\", \"INHBX4\", \"INHDD6\", \"INHEB6\", \"INHEI6\", \"INHEM6\", \"INHGLB\", \"INHGT1\", \"INHIR6\", \"INHJR4\", \"INHLD2\", \"INHLE6\", \"INHLIB\", \"INHND1\", \"INHON1\", \"INHPI6\", \"INHRN1\", \"INHSF6\", \"INHSP6\", \"INHSS4\", \"INHST6\", \"INHSU6\", \"INHTSB\", \"INHUR6\", \"INHWR1\", \"INHYB6\", \"INHYD4\", \"INHYD5\", \"INHYD6\", \"INHZA1\", \"INHZA6\", \"INIDR4\", \"INIDR6\", \"INIGU6\", \"INILP6\", \"INIMF4\", \"ININB6\", \"ININD6\", \"ININI6\", \"ININN6\", \"ININT6\", \"INISK4\", \"INISK6\", \"INIXA4\", \"INIXB4\", \"INIXC4\", \"INIXD4\", \"INIXE1\", \"INIXE4\", \"INIXG4\", \"INIXH4\", \"INIXI4\", \"INIXJ4\", \"INIXK4\", \"INIXL4\", \"INIXL5\", \"INIXM4\", \"INIXM6\", \"INIXN4\", \"INIXP4\", \"INIXQ4\", \"INIXR4\", \"INIXS4\", \"INIXT4\", \"INIXU4\", \"INIXW4\", \"INIXW6\", \"INIXY1\", \"INIXY4\", \"INIXY6\", \"INIXZ1\", \"INIXZ4\", \"INJAI4\", \"INJAI5\", \"INJAI6\", \"INJAK1\", \"INJAL6\", \"INJAYB\", \"INJBD1\", \"INJBL6\", \"INJBNB\", \"INJDA1\", \"INJDH4\", \"INJDH6\", \"INJGA4\", \"INJGB4\", \"INJGD1\", \"INJGI6\", \"INJHA6\", \"INJHOB\", \"INJHV6\", \"INJIGB\", \"INJJK6\", \"INJKA6\", \"INJLR4\", \"INJNJ6\", \"INJNR4\", \"INJNR6\", \"INJPGB\", \"INJPI6\", \"INJPV6\", \"INJPW6\", \"INJRH4\", \"INJSA4\", \"INJSG6\", \"INJSM6\", \"INJSZ6\", \"INJTP1\", \"INJUC6\", \"INJUX6\", \"INJWAB\", \"INKAK1\", \"INKAK6\", \"INKAL1\", \"INKAP6\", \"INKAR6\", \"INKAT1\", \"INKBC6\", \"INKBT1\", \"INKCG6\", \"INKDD6\", \"INKDI1\", \"INKDL6\", \"INKDN1\", \"INKDP1\", \"INKELB\", \"INKGG6\", \"INKGJ1\", \"INKHD6\", \"INKIW1\", \"INKJA6\", \"INKJB6\", \"INKJD6\", \"INKJG6\", \"INKJH6\", \"INKJIB\", \"INKJM6\", \"INKJR6\", \"INKKR1\", \"INKKU6\", \"INKLB6\", \"INKLC6\", \"INKLG6\", \"INKLH4\", \"INKLI6\", \"INKLK6\", \"INKLM6\", \"INKLN6\", \"INKLS6\", \"INKLY1\", \"INKMAB\", \"INKMB1\", \"INKMI6\", \"INKML6\", \"INKND1\", \"INKNK6\", \"INKNLB\", \"INKNU4\", \"INKNU5\", \"INKNU6\", \"INKOC5\", \"INKOD1\", \"INKOI1\", \"INKOK1\", \"INKON1\", \"INKPK6\", \"INKRI1\", \"INKRK1\", \"INKRM6\", \"INKRN1\", \"INKRP1\", \"INKRW1\", \"INKSG1\", \"INKSH1\", \"INKSP1\", \"INKTD1\", \"INKTGB\", \"INKTI1\", \"INKTRB\", \"INKTT6\", \"INKTU4\", \"INKTU6\", \"INKTW1\", \"INKTY6\", \"INKUK1\", \"INKUK6\", \"INKUR6\", \"INKUU4\", \"INKVI1\", \"INKVL1\", \"INKVR6\", \"INKVT1\", \"INKWAB\", \"INKWGB\", \"INKWHB\", \"INKXJ2\", \"INKYM6\", \"INKZE6\", \"INKZP6\", \"INKZT6\", \"INLCH6\", \"INLDA4\", \"INLDH6\", \"INLGLB\", \"INLKO4\", \"INLKQB\", \"INLON6\", \"INLPB6\", \"INLPC6\", \"INLPD6\", \"INLPG6\", \"INLPI6\", \"INLPJ6\", \"INLPM6\", \"INLPR1\", \"INLPS6\", \"INLPW6\", \"INLTBB\", \"INLUD6\", \"INLUH4\", \"INLUH5\", \"INLUH6\", \"INLWG6\", \"INMAA1\", \"INMAA4\", \"INMAA5\", \"INMAA6\", \"INMAB6\", \"INMAE6\", \"INMAH1\", \"INMAI6\", \"INMAL1\", \"INMAP1\", \"INMAQ6\", \"INMAS6\", \"INMBC6\", \"INMBD6\", \"INMBS6\", \"INMCI1\", \"INMDA1\", \"INMDD6\", \"INMDE6\", \"INMDG6\", \"INMDK1\", \"INMDP1\", \"INMDU6\", \"INMDV1\", \"INMDW1\", \"INMEA6\", \"INMEC6\", \"INMGHB\", \"INMGR1\", \"INMHA1\", \"INMHDB\", \"INMHE1\", \"INMHGB\", \"INMHN2\", \"INMKCB\", \"INMKD6\", \"INMLI1\", \"INMLP1\", \"INMLW1\", \"INMNB2\", \"INMNR1\", \"INMNUB\", \"INMNW1\", \"INMOH4\", \"INMOR2\", \"INMPC1\", \"INMPR6\", \"INMQK6\", \"INMRA1\", \"INMRD1\", \"INMREB\", \"INMRG4\", \"INMRJ6\", \"INMRM1\", \"INMSR6\", \"INMTW1\", \"INMUC6\", \"INMUL6\", \"INMUN1\", \"INMUR1\", \"INMUZ6\", \"INMWA6\", \"INMYB1\", \"INMYL6\", \"INMYO6\", \"INMYQ4\", \"INMZA4\", \"INMZU4\", \"INNAG4\", \"INNAG6\", \"INNAN1\", \"INNAV1\", \"INNDA6\", \"INNDC4\", \"INNDG1\", \"INNDP1\", \"INNEE1\", \"INNEL1\", \"INNGB6\", \"INNGKB\", \"INNGO6\", \"INNGP6\", \"INNGRB\", \"INNGSB\", \"INNKI6\", \"INNKNB\", \"INNML1\", \"INNMTB\", \"INNNN6\", \"INNPGB\", \"INNPT1\", \"INNRP6\", \"INNSA1\", \"INNSK6\", \"INNTLB\", \"INNTVB\", \"INNUR6\", \"INNVB1\", \"INNVP1\", \"INNVT1\", \"INNVY4\", \"INNWP1\", \"INNYP6\", \"INOKH1\", \"INOMN4\", \"INOMU1\", \"INONJ1\", \"INPAB4\", \"INPAK6\", \"INPAN1\", \"INPAO6\", \"INPAP2\", \"INPAT4\", \"INPAV1\", \"INPAV2\", \"INPBD1\", \"INPBD4\", \"INPBLB\", \"INPDD1\", \"INPEK6\", \"INPGH4\", \"INPHBB\", \"INPID1\", \"INPIN1\", \"INPIT6\", \"INPKD6\", \"INPKR6\", \"INPMB1\", \"INPMP6\", \"INPMT6\", \"INPNB6\", \"INPNE6\", \"INPNF5\", \"INPNI6\", \"INPNJ1\", \"INPNK6\", \"INPNL6\", \"INPNM1\", \"INPNN1\", \"INPNP6\", \"INPNQ2\", \"INPNQ4\", \"INPNQ6\", \"INPNTB\", \"INPNU6\", \"INPNV6\", \"INPNY1\", \"INPNY4\", \"INPNY6\", \"INPPG6\", \"INPPJ1\", \"INPRD6\", \"INPRG1\", \"INPRK6\", \"INPRT1\", \"INPSH1\", \"INPSI6\", \"INPSN6\", \"INPSP6\", \"INPTL6\", \"INPTN1\", \"INPTPB\", \"INPUA6\", \"INPUE6\", \"INPUI6\", \"INPUL1\", \"INPUM6\", \"INPUN6\", \"INPUR1\", \"INPUT4\", \"INPVL6\", \"INPVS6\", \"INPWL6\", \"INPYB4\", \"INPYS6\", \"INQRP6\", \"INQUI1\", \"INRAI6\", \"INRAJ4\", \"INRAJ6\", \"INRAM1\", \"INRDP2\", \"INREA6\", \"INRED1\", \"INREW4\", \"INRGBB\", \"INRGH4\", \"INRGJ2\", \"INRGT1\", \"INRGUB\", \"INRJA4\", \"INRJI4\", \"INRJN6\", \"INRJP1\", \"INRJR1\", \"INRKG1\", \"INRMD4\", \"INRML6\", \"INRNC5\", \"INRNG2\", \"INRNR1\", \"INRPL6\", \"INRPR4\", \"INRPR6\", \"INRPU5\", \"INRRI1\", \"INRRK4\", \"INRTC1\", \"INRTC4\", \"INRTM6\", \"INRUP4\", \"INRVD1\", \"INRWR1\", \"INRXLB\", \"INSABB\", \"INSAC6\", \"INSAJ6\", \"INSAL1\", \"INSAS6\", \"INSAU6\", \"INSBC6\", \"INSBH1\", \"INSBI6\", \"INSBK6\", \"INSBL6\", \"INSBW6\", \"INSBZ1\", \"INSCH6\", \"INSGF6\", \"INSHI1\", \"INSHL4\", \"INSHP1\", \"INSIK1\", \"INSJR6\", \"INSKD6\", \"INSKPB\", \"INSLL6\", \"INSLR2\", \"INSLRB\", \"INSLT6\", \"INSLV4\", \"INSMK6\", \"INSMPB\", \"INSMR1\", \"INSNA6\", \"INSNBB\", \"INSNF6\", \"INSNG2\", \"INSNI6\", \"INSNLB\", \"INSNN6\", \"INSNR6\", \"INSNS6\", \"INSPC6\", \"INSPE6\", \"INSRE6\", \"INSRK6\", \"INSRV1\", \"INSSE4\", \"INSTFB\", \"INSTIB\", \"INSTM6\", \"INSTP1\", \"INSTRB\", \"INSTT6\", \"INSTU6\", \"INSTV1\", \"INSTV4\", \"INSTV6\", \"INSWD1\", \"INSXE6\", \"INSXR4\", \"INSXR5\", \"INSXV4\", \"INSXV6\", \"INTAD1\", \"INTAS6\", \"INTBC6\", \"INTBM6\", \"INTBP6\", \"INTBS6\", \"INTBT6\", \"INTCR6\", \"INTDE6\", \"INTEI4\", \"INTEL1\", \"INTEN6\", \"INTEZ4\", \"INTGN6\", \"INTHA6\", \"INTHL1\", \"INTHO6\", \"INTIR4\", \"INTIV1\", \"INTJA1\", \"INTJPB\", \"INTJV4\", \"INTKD2\", \"INTKD6\", \"INTKNB\", \"INTLG6\", \"INTLT6\", \"INTMI6\", \"INTMP1\", \"INTMX6\", \"INTNA1\", \"INTNC6\", \"INTND1\", \"INTNGB\", \"INTNI6\", \"INTNK1\", \"INTNS6\", \"INTPH1\", \"INTPJ6\", \"INTPN1\", \"INTRA1\", \"INTRL6\", \"INTRP1\", \"INTRV4\", \"INTRZ4\", \"INTSI6\", \"INTTP6\", \"INTTS1\", \"INTUI6\", \"INTUN1\", \"INTUP6\", \"INTUT1\", \"INTUT6\", \"INTVC6\", \"INTVT6\", \"INTYR1\", \"INUDI6\", \"INUDN6\", \"INUDR4\", \"INUDR6\", \"INUDZ6\", \"INUKL6\", \"INULPB\", \"INULW1\", \"INUMB1\", \"INUMR1\", \"INURF6\", \"INURG6\", \"INURI6\", \"INURT6\", \"INUTN1\", \"INVAD1\", \"INVAL6\", \"INVAP1\", \"INVEN1\", \"INVEP1\", \"INVGA4\", \"INVGA5\", \"INVGR6\", \"INVKH6\", \"INVKM1\", \"INVLD6\", \"INVLN6\", \"INVLR6\", \"INVNG1\", \"INVNS4\", \"INVNS5\", \"INVNS6\", \"INVPI6\", \"INVRD1\", \"INVRU1\", \"INVSA6\", \"INVSI1\", \"INVSK6\", \"INVSP6\", \"INVSV1\", \"INVTC6\", \"INVTZ1\", \"INVTZ4\", \"INVTZ6\", \"INVVA1\", \"INVYD1\", \"INVZJ1\", \"INVZM6\", \"INVZR6\", \"INWAL6\", \"INWFD6\", \"INWFI6\", \"INWFT6\", \"INWGC4\", \"INWRR6\", \"INYMA6\", \"INYNA6\", \"INYNK6\", \"INYNL6\", \"INYNM6\", \"INYNT6\", \"INZIP6\"],\r\n" +
    		"                    \"description\": \"Port Code\"\r\n" +
    		"                },\r\n" +
    		"                \"RefClm\": {\r\n" +
    		"                    \"enum\": [\"Y\", \"N\"],\r\n" +
    		"                    \"description\": \"Options for supplier for refund. Y/N\"\r\n" +
    		"                },\r\n" +
    		"                \"ForCur\": {\r\n" +
    		"                    \"enum\": [\"GYD\", \"GIP\", \"JOD\", \"MNT\", \"IQD\", \"TJS\", \"BTN\", \"BZD\", \"CLF\", \"BYN\", \"UYW\", \"LBP\", \"MGA\", \"VES\", \"THB\", \"COU\", \"DOP\", \"LAK\", \"TZS\", \"COP\", \"GNF\", \"HTG\", \"TND\", \"NOK\", \"AFN\", \"UAH\", \"XAU\", \"MZN\", \"SZL\", \"AZN\", \"BMD\", \"MUR\", \"ZAR\", \"WST\", \"MDL\", \"CUC\", \"ERN\", \"XDR\", \"SOS\", \"HNL\", \"SDG\", \"ZWL\", \"PHP\", \"CLP\", \"BRL\", \"KES\", \"AMD\", \"PKR\", \"DKK\", \"MMK\", \"UYI\", \"SLL\", \"XBA\", \"XSU\", \"SEK\", \"KRW\", \"MAD\", \"CVE\", \"KZT\", \"PGK\", \"CHE\", \"GEL\", \"XPF\", \"VND\", \"DZD\", \"XCD\", \"NAD\", \"KYD\", \"HRK\", \"UYU\", \"NGN\", \"ARS\", \"BSD\", \"ILS\", \"LRD\", \"PEN\", \"KPW\", \"SCR\", \"USD\", \"NIO\", \"QAR\", \"BWP\", \"BOV\", \"MWK\", \"XBB\", \"NZD\", \"XPT\", \"BBD\", \"UZS\", \"PAB\", \"SHP\", \"BHD\", \"PLN\", \"XAG\", \"MXV\", \"AWG\", \"CZK\", \"AED\", \"FKP\", \"TMT\", \"HKD\", \"CAD\", \"XPD\", \"STN\", \"SBD\", \"MOP\", \"IDR\", \"XBD\", \"XOF\", \"JPY\", \"CUP\", \"GTQ\", \"INR\", \"TWD\", \"BND\", \"AOA\", \"XAF\", \"NPR\", \"MRU\", \"KWD\", \"XUA\", \"ZMW\", \"XTS\", \"YER\", \"CNY\", \"SAR\", \"EUR\", \"ISK\", \"GMD\", \"CRC\", \"JMD\", \"SVC\", \"KMF\", \"KGS\", \"BDT\", \"VUV\", \"XBC\", \"BGN\", \"GHS\", \"BAM\", \"BOB\", \"RWF\", \"KHR\", \"GBP\", \"SRD\", \"AUD\", \"ANG\", \"HUF\", \"RUB\", \"CHW\", \"TTD\", \"USN\", \"TOP\", \"ALL\", \"OMR\", \"MKD\", \"XXX\", \"ETB\", \"UGX\", \"MXN\", \"MVR\", \"EGP\", \"SYP\", \"CDF\", \"IRR\", \"DJF\", \"SSP\", \"RON\", \"PYG\", \"MYR\", \"SGD\", \"BIF\", \"RSD\", \"CHF\", \"LKR\", \"TRY\", \"LYD\", \"LSL\", \"FJD\"],\r\n" +
    		"                    \"description\": \"Foreign Currency\"\r\n" +
    		"                },\r\n" +
    		"                \"CntCode\": {\r\n" +
    		"                    \"enum\": [\"AD\", \"AE\", \"AF\", \"AG\", \"AI\", \"AL\", \"AM\", \"AO\", \"AQ\", \"AR\", \"AS\", \"AT\", \"AU\", \"AW\", \"AX\", \"AZ\", \"BA\", \"BB\", \"BD\", \"BE\", \"BF\", \"BG\", \"BH\", \"BI\", \"BJ\", \"BL\", \"BM\", \"BN\", \"BO\", \"BQ\", \"BR\", \"BS\", \"BT\", \"BV\", \"BW\", \"BY\", \"BZ\", \"CA\", \"CC\", \"CD\", \"CF\", \"CG\", \"CH\", \"CI\", \"CK\", \"CL\", \"CM\", \"CN\", \"CO\", \"CR\", \"CU\", \"CV\", \"CW\", \"CX\", \"CY\", \"CZ\", \"DE\", \"DJ\", \"DK\", \"DM\", \"DO\", \"DZ\", \"EC\", \"EE\", \"EG\", \"EH\", \"ER\", \"ES\", \"ET\", \"FI\", \"FJ\", \"FK\", \"FM\", \"FO\", \"FR\", \"GA\", \"GB\", \"GD\", \"GE\", \"GF\", \"GG\", \"GH\", \"GI\", \"GL\", \"GM\", \"GN\", \"GP\", \"GQ\", \"GR\", \"GS\", \"GT\", \"GU\", \"GW\", \"GY\", \"HK\", \"HM\", \"HN\", \"HR\", \"HT\", \"HU\", \"ID\", \"IE\", \"IL\", \"IM\", \"IN\", \"IO\", \"IQ\", \"IR\", \"IS\", \"IT\", \"JE\", \"JM\", \"JO\", \"JP\", \"KE\", \"KG\", \"KH\", \"KI\", \"KM\", \"KN\", \"KP\", \"KR\", \"KW\", \"KY\", \"KZ\", \"LA\", \"LB\", \"LC\", \"LI\", \"LK\", \"LR\", \"LS\", \"LT\", \"LU\", \"LV\", \"LY\", \"MA\", \"MC\", \"MD\", \"ME\", \"MF\", \"MG\", \"MH\", \"MK\", \"ML\", \"MM\", \"MN\", \"MO\", \"MP\", \"MQ\", \"MR\", \"MS\", \"MT\", \"MU\", \"MV\", \"MW\", \"MX\", \"MY\", \"MZ\", \"NA\", \"NC\", \"NE\", \"NF\", \"NG\", \"NI\", \"NL\", \"NO\", \"NP\", \"NR\", \"NU\", \"NZ\", \"OM\", \"PA\", \"PE\", \"PF\", \"PG\", \"PH\", \"PK\", \"PL\", \"PM\", \"PN\", \"PR\", \"PS\", \"PT\", \"PW\", \"PY\", \"QA\", \"RE\", \"RO\", \"RS\", \"RU\", \"RW\", \"SA\", \"SB\", \"SC\", \"SD\", \"SE\", \"SG\", \"SH\", \"SI\", \"SJ\", \"SK\", \"SL\", \"SM\", \"SN\", \"SO\", \"SR\", \"SS\", \"ST\", \"SV\", \"SX\", \"SY\", \"SZ\", \"TC\", \"TD\", \"TF\", \"TG\", \"TH\", \"TJ\", \"TK\", \"TL\", \"TM\", \"TN\", \"TO\", \"TR\", \"TT\", \"TV\", \"TW\", \"TZ\", \"UA\", \"UG\", \"UM\", \"US\", \"UY\", \"UZ\", \"VA\", \"VC\", \"VE\", \"VG\", \"VI\", \"VN\", \"VU\", \"WF\", \"WS\", \"YE\", \"YT\", \"ZA\", \"ZM\", \"ZW\"],\r\n" +
    		"                    \"description\": \"Country\"\r\n" +
    		"                }\r\n" +
    		"            }\r\n" +
    		"        },\r\n" +
    		"        \"EwbDtls\": {\r\n" +
    		"            \"type\": \"object\",\r\n" +
    		"            \"properties\": {\r\n" +
    		"                \"TransId\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 15,\r\n" +
    		"                    \"maxLength\": 15,\r\n" +
    		"                    \"description\": \"Transin/GSTIN\"\r\n" +
    		"                },\r\n" +
    		"                \"TransName\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 3,\r\n" +
    		"                    \"maxLength\": 100,\r\n" +
    		"                    \"description\": \"Name of the transporter\"\r\n" +
    		"                },\r\n" +
    		"                \"TransMode\": {\r\n" +
    		"                    \"enum\": [\"1\", \"2\", \"3\", \"4\"],\r\n" +
    		"                    \"description\": \"Mode of transport (Road-1, Rail-2, Air-3, Ship-4)\"\r\n" +
    		"                },\r\n" +
    		"                \"Distance\": {\r\n" +
    		"                    \"type\": \"number\",\r\n" +
    		"                    \"minimum\": 0,\r\n" +
    		"                    \"maximum\": 9999,\r\n" +
    		"                    \"description\": \"Distance between source and destination PIN codes\"\r\n" +
    		"                },\r\n" +
    		"                \"TransDocNo\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"pattern\": \"^([0-9A-Z/-]){1,15}$\",\r\n" +
    		"                    \"description\": \"Tranport Document Number\"\r\n" +
    		"                },\r\n" +
    		"                \"TransDocDt\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\r\n" +
    		"                    \"description\": \"Transport Document Date\"\r\n" +
    		"                },\r\n" +
    		"                \"VehNo\": {\r\n" +
    		"                    \"type\": \"string\",\r\n" +
    		"                    \"minLength\": 4,\r\n" +
    		"                    \"maxLength\": 20,\r\n" +
    		"                    \"description\": \"Vehicle Number\"\r\n" +
    		"                },\r\n" +
    		"                \"VehType\": {\r\n" +
    		"                    \"enum\": [\"O\", \"R\"],\r\n" +
    		"                    \"description\": \"Whether O-ODC or R-Regular \"\r\n" +
    		"                }\r\n" +
    		"            },\r\n" +
    		"            \"required\": [\"Distance\"]\r\n" +
    		"        }\r\n" +
    		"    },\r\n" +
    		"    \"required\": [\"User_GSTIN\", \"Version\", \"TranDtls\", \"DocDtls\", \"SellerDtls\", \"BuyerDtls\", \"ItemList\", \"ValDtls\"],\r\n" +
    		"    \"type\": \"object\"\r\n" +
    		"}";

	public static final String GEN_EWB_BY_IRN_PAYLOAD="{\n" +
			"\"$schema\":\"http://json-schema.org/draft-04/schema#\",\n" +
			"\"type\":\"object\",\n" +
			"\"properties\":{\n" +
			"\"User_GSTIN\":{\n" +
			"\"type\":\"string\",\n" +
			"\"pattern\":\"([0-9]{2}[0-9|A-Z]{13})\",\n" +
			"\"description\":\"UserGSTIN\"\n" +
			"},\n" +
			"\"Irn\":{\n" +
			"\"type\":\"string\",\n" +
			"\"minLength\":64,\n" +
			"\"maxLength\":64,\n" +
			"\"description\":\"IrnNumber\"\n" +
			"},\n" +
			"\"TransId\":{\n" +
			"\"type\":\"string\",\n" +
			"\"minLength\":15,\n" +
			"\"maxLength\":15,\n" +
			"\"description\":\"Transin/GSTIN\"\n" +
			"},\n" +
			"\"TransName\":{\n" +
			"\"type\":\"string\",\n" +
			"\"minLength\":3,\n" +
			"\"maxLength\":100,\n" +
			"\"description\":\"Nameofthetransporter\"\n" +
			"},\n" +
			"\"TransMode\":{\n" +
			"\"type\":\"string\",\n" +
			"\"maxLength\":1,\n" +
			"\"minLength\":1,\n" +
			"\"enum\":[\n" +
			"\"1\",\n" +
			"\"2\",\n" +
			"\"3\",\n" +
			"\"4\"\n" +
			"],\n" +
			"\"description\":\"Mode of transport(Road-1,Rail-2,Air-3,Ship-4)\"\n" +
			"},\n" +
			"\"Distance\":{\n" +
			"\"type\":\"number\",\n" +
			"\"maximum\":9999,\n" +
			"\"minimum\":0,\n" +
			"\"description\":\"Distance between source and destination PINcodes\"\n" +
			"},\n" +
			"\"TransDocNo\":{\n" +
			"\"type\":\"string\",\n" +
			"\"minLength\":1,\n" +
			"\"maxLength\":15,\n" +
			"\"pattern\":\"^([0-9A-Z/-]){1,15}$\",\n" +
			"\"description\":\"TranportDocumentNumber\"\n" +
			"},\n" +
			"\"TransDocDt\":{\n" +
			"\"type\":\"string\",\n" +
			"\"minLength\":10,\n" +
			"\"maxLength\":10,\n" +
			"\"pattern\":\"[0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9]\",\n" +
			"\"description\":\"TransportDocumentDate\"\n" +
			"},\n" +
			"\"VehNo\":{\n" +
			"\"type\":\"string\",\n" +
			"\"minLength\":4,\n" +
			"\"maxLength\":20,\n" +
			"\"description\":\"VehicleNumber\"\n" +
			"},\n" +
			"\"VehType\":{\n" +
			"\"type\":\"string\",\n" +
			"\"minLength\":1,\n" +
			"\"maxLength\":1,\n" +
			"\"enum\":[\n" +
			"\"O\",\n" +
			"\"R\"\n" +
			"],\n" +
			"\"description\":\"WhetherO-ODCorR-Regular\"\n" +
			"}\n" +
			"},\n" +
			"\"required\":[\n" +
			"\"Distance\",\n" +
			"\"User_GSTIN\"\n" +
			"]\n" +
			"}";

	public static final String GEN_EWB_PAYLOAD_SCHEMA = "{\n" +
		"    \"$schema\": \"http://json-schema.org/draft-07/schema#\",\n" +
		"    \"type\": \"object\",\n" +
		"    \"properties\": {\n" +
		"        \"TranDtls\": {\n" +
		"            \"type\": \"object\",\n" +
		"            \"properties\": {\n" +
		"                \"RegRev\": {\n" +
		"                    \"description\": \"Y- whether the tax liability is payable under reverse charge\",\n" +
		"                    \"enum\": [\n" +
		"                        \"Y\",\n" +
		"                        \"N\"\n" +
		"                    ]\n" +
		"                },\n" +
		"                \"IgstOnIntra\": {\n" +
		"                    \"description\": \"Y- indicates the supply is intra state but chargeable to IGST\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"enum\": [\n" +
		"                        \"Y\",\n" +
		"                        \"N\"\n" +
		"                    ]\n" +
		"                },\n" +
		"                \"EcmGstin\": {\n" +
		"                    \"pattern\": \"^([0-9]{2}[0-9A-Z]{13})$\",\n" +
		"                    \"description\": \"GSTIN of e-Commerce operator\",\n" +
		"                    \"type\": \"string\"\n" +
		"                },\n" +
		"                \"TaxSch\": {\n" +
		"                    \"description\": \"GST- Goods and Services Tax Scheme\",\n" +
		"                    \"enum\": [\n" +
		"                        \"GST\"\n" +
		"                    ]\n" +
		"                },\n" +
		"                \"SupTyp\": {\n" +
		"                    \"description\": \"Type of Supply: B2B-Business to Business, SEZWP - SEZ with payment, SEZWOP - SEZ without payment, EXPWP - Export with Payment, EXPWOP - Export without payment,DEXP - Deemed Export\",\n" +
		"                    \"enum\": [\n" +
		"                        \"B2B\",\n" +
		"                        \"SEZWP\",\n" +
		"                        \"SEZWOP\",\n" +
		"                        \"EXPWP\",\n" +
		"                        \"EXPWOP\",\n" +
		"                        \"DEXP\",\n" +
		"                        \"B2C\"\n" +
		"                    ]\n" +
		"                }\n" +
		"            },\n" +
		"            \"required\": []\n" +
		"        },\n" +
		"        \"DocDtls\": {\n" +
		"            \"type\": \"object\",\n" +
		"            \"properties\": {\n" +
		"                \"Dt\": {\n" +
		"                    \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\n" +
		"                    \"description\": \"Document Date\",\n" +
		"                    \"type\": \"string\"\n" +
		"                },\n" +
		"                \"No\": {\n" +
		"                    \"pattern\": \"^[1-9A-Z]{1}[0-9A-Z/-]{0,15}$\",\n" +
		"                    \"description\": \"Document Number\",\n" +
		"                    \"type\": \"string\"\n" +
		"                },\n" +
		"                \"Typ\": {\n" +
		"                    \"description\": \"Document Type: INV-INVOICE, CRN-CREDIT NOTE, DBN-DEBIT NOTE\",\n" +
		"                    \"enum\": [\n" +
		"                        \"INV\",\n" +
		"                        \"CRN\",\n" +
		"                        \"DBN\",\n" +
		"                        \"BIL\",\n" +
		"                        \"BOE\",\n" +
		"                        \"CHL\",\n" +
		"                        \"OTH\",\n" +
		"                        \"RCV\",\n" +
		"                        \"RFV\",\n" +
		"                        \"PMV\"\n" +
		"                    ]\n" +
		"                }\n" +
		"            },\n" +
		"            \"required\": [\n" +
		"                \"Typ\",\n" +
		"                \"No\",\n" +
		"                \"Dt\"\n" +
		"            ]\n" +
		"        },\n" +
		"        \"SellerDtls\": {\n" +
		"            \"type\": \"object\",\n" +
		"            \"properties\": {\n" +
		"                \"TrdNm\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Tradename\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Loc\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Location\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 50\n" +
		"                },\n" +
		"                \"Addr1\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Building/Flat no, Road/Street\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Gstin\": {\n" +
		"                    \"pattern\": \"^([0-9]{2}[0-9A-Z]{13}|URP)$\",\n" +
		"                    \"description\": \"GSTIN\",\n" +
		"                    \"type\": \"string\"\n" +
		"                },\n" +
		"                \"Addr2\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Address 2 of the supplier (Floor no., Name of the premises/building)\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Pin\": {\n" +
		"                    \"maximum\": 999999,\n" +
		"                    \"description\": \"Pincode\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 100000\n" +
		"                },\n" +
		"                \"Stcd\": {\n" +
		"                    \"description\": \"State Code of the supplier. Refer the master\",\n" +
		"                    \"enum\": [\n" +
		"                        \"01\",\n" +
		"                        \"02\",\n" +
		"                        \"03\",\n" +
		"                        \"04\",\n" +
		"                        \"05\",\n" +
		"                        \"06\",\n" +
		"                        \"07\",\n" +
		"                        \"08\",\n" +
		"                        \"09\",\n" +
		"                        \"1\",\n" +
		"                        \"2\",\n" +
		"                        \"3\",\n" +
		"                        \"4\",\n" +
		"                        \"5\",\n" +
		"                        \"6\",\n" +
		"                        \"7\",\n" +
		"                        \"8\",\n" +
		"                        \"9\",\n" +
		"                        \"10\",\n" +
		"                        \"11\",\n" +
		"                        \"12\",\n" +
		"                        \"13\",\n" +
		"                        \"14\",\n" +
		"                        \"15\",\n" +
		"                        \"16\",\n" +
		"                        \"17\",\n" +
		"                        \"18\",\n" +
		"                        \"19\",\n" +
		"                        \"20\",\n" +
		"                        \"21\",\n" +
		"                        \"22\",\n" +
		"                        \"23\",\n" +
		"                        \"24\",\n" +
		"                        \"25\",\n" +
		"                        \"26\",\n" +
		"                        \"27\",\n" +
		"                        \"28\",\n" +
		"                        \"29\",\n" +
		"                        \"30\",\n" +
		"                        \"31\",\n" +
		"                        \"32\",\n" +
		"                        \"33\",\n" +
		"                        \"34\",\n" +
		"                        \"35\",\n" +
		"                        \"36\",\n" +
		"                        \"37\",\n" +
		"                        \"96\",\n" +
		"                        \"97\",\n" +
		"                        \"38\",\n" +
		"                        \"99\"\n" +
		"                    ]\n" +
		"                },\n" +
		"                \"Ph\": {\n" +
		"                    \"minLength\": 6,\n" +
		"                    \"description\": \"Phone or Mobile No.\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 12\n" +
		"                },\n" +
		"                \"Em\": {\n" +
		"                    \"minLength\": 6,\n" +
		"                    \"description\": \"Email-Id\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"LglNm\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Legal Name\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                }\n" +
		"            },\n" +
		"            \"required\": [\n" +
		"                \"Gstin\",\n" +
		"                \"Stcd\"\n" +
		"            ]\n" +
		"        },\n" +
		"        \"BuyerDtls\": {\n" +
		"            \"type\": \"object\",\n" +
		"            \"properties\": {\n" +
		"                \"TrdNm\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Tradename\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Loc\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Location\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Addr1\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Building/Flat no, Road/Street\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Gstin\": {\n" +
		"                    \"pattern\": \"^([0-9]{2}[0-9A-Z]{13}|URP)$\",\n" +
		"                    \"description\": \"GSTIN of buyer , URP if exporting\",\n" +
		"                    \"type\": \"string\"\n" +
		"                },\n" +
		"                \"Addr2\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Address 2 of the supplier (Floor no., Name of the premises/building)\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Pin\": {\n" +
		"                    \"maximum\": 999999,\n" +
		"                    \"description\": \"Pincode\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 100000\n" +
		"                },\n" +
		"                \"Pos\": {\n" +
		"                    \"description\": \"State code of Place of supply. If POS lies outside the country, a the code shall be 96.\",\n" +
		"                    \"enum\": [\n" +
		"                        \"01\",\n" +
		"                        \"02\",\n" +
		"                        \"03\",\n" +
		"                        \"04\",\n" +
		"                        \"05\",\n" +
		"                        \"06\",\n" +
		"                        \"07\",\n" +
		"                        \"08\",\n" +
		"                        \"09\",\n" +
		"                        \"1\",\n" +
		"                        \"2\",\n" +
		"                        \"3\",\n" +
		"                        \"4\",\n" +
		"                        \"5\",\n" +
		"                        \"6\",\n" +
		"                        \"7\",\n" +
		"                        \"8\",\n" +
		"                        \"9\",\n" +
		"                        \"10\",\n" +
		"                        \"11\",\n" +
		"                        \"12\",\n" +
		"                        \"13\",\n" +
		"                        \"14\",\n" +
		"                        \"15\",\n" +
		"                        \"16\",\n" +
		"                        \"17\",\n" +
		"                        \"18\",\n" +
		"                        \"19\",\n" +
		"                        \"20\",\n" +
		"                        \"21\",\n" +
		"                        \"22\",\n" +
		"                        \"23\",\n" +
		"                        \"24\",\n" +
		"                        \"25\",\n" +
		"                        \"26\",\n" +
		"                        \"27\",\n" +
		"                        \"28\",\n" +
		"                        \"29\",\n" +
		"                        \"30\",\n" +
		"                        \"31\",\n" +
		"                        \"32\",\n" +
		"                        \"33\",\n" +
		"                        \"34\",\n" +
		"                        \"35\",\n" +
		"                        \"36\",\n" +
		"                        \"37\",\n" +
		"                        \"96\",\n" +
		"                        \"97\",\n" +
		"                        \"38\",\n" +
		"                        \"99\"\n" +
		"                    ]\n" +
		"                },\n" +
		"                \"Stcd\": {\n" +
		"                    \"description\": \"State Name\",\n" +
		"                    \"enum\": [\n" +
		"                        \"01\",\n" +
		"                        \"02\",\n" +
		"                        \"03\",\n" +
		"                        \"04\",\n" +
		"                        \"05\",\n" +
		"                        \"06\",\n" +
		"                        \"07\",\n" +
		"                        \"08\",\n" +
		"                        \"09\",\n" +
		"                        \"1\",\n" +
		"                        \"2\",\n" +
		"                        \"3\",\n" +
		"                        \"4\",\n" +
		"                        \"5\",\n" +
		"                        \"6\",\n" +
		"                        \"7\",\n" +
		"                        \"8\",\n" +
		"                        \"9\",\n" +
		"                        \"10\",\n" +
		"                        \"11\",\n" +
		"                        \"12\",\n" +
		"                        \"13\",\n" +
		"                        \"14\",\n" +
		"                        \"15\",\n" +
		"                        \"16\",\n" +
		"                        \"17\",\n" +
		"                        \"18\",\n" +
		"                        \"19\",\n" +
		"                        \"20\",\n" +
		"                        \"21\",\n" +
		"                        \"22\",\n" +
		"                        \"23\",\n" +
		"                        \"24\",\n" +
		"                        \"25\",\n" +
		"                        \"26\",\n" +
		"                        \"27\",\n" +
		"                        \"28\",\n" +
		"                        \"29\",\n" +
		"                        \"30\",\n" +
		"                        \"31\",\n" +
		"                        \"32\",\n" +
		"                        \"33\",\n" +
		"                        \"34\",\n" +
		"                        \"35\",\n" +
		"                        \"36\",\n" +
		"                        \"37\",\n" +
		"                        \"96\",\n" +
		"                        \"97\",\n" +
		"                        \"38\",\n" +
		"                        \"99\"\n" +
		"                    ]\n" +
		"                },\n" +
		"                \"Ph\": {\n" +
		"                    \"minLength\": 6,\n" +
		"                    \"description\": \"Phone or Mobile No.\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 12\n" +
		"                },\n" +
		"                \"Em\": {\n" +
		"                    \"minLength\": 6,\n" +
		"                    \"description\": \"Email-Id\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"LglNm\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Legal Name\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                }\n" +
		"            },\n" +
		"            \"required\": [\n" +
		"                \"Gstin\",\n" +
		"                \"Stcd\"\n" +
		"            ]\n" +
		"        },\n" +
		"\t\t\"ValDtls\": {\n" +
		"            \"type\": \"object\",\n" +
		"            \"properties\": {\n" +
		"                \"CgstVal\": {\n" +
		"                    \"maximum\": 9.999999999999998E13,\n" +
		"                    \"description\": \"Total CGST value of all items\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 0\n" +
		"                },\n" +
		"                \"Discount\": {\n" +
		"                    \"maximum\": 9.999999999999998E13,\n" +
		"                    \"description\": \"Discount\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 0\n" +
		"                },\n" +
		"                \"AssVal\": {\n" +
		"                    \"maximum\": 9.999999999999998E13,\n" +
		"                    \"description\": \"Total Assessable value of all items\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 0\n" +
		"                },\n" +
		"                \"OthChrg\": {\n" +
		"                    \"maximum\": 9.999999999999998E13,\n" +
		"                    \"description\": \"Other Charges\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 0\n" +
		"                },\n" +
		"                \"IgstVal\": {\n" +
		"                    \"maximum\": 9.999999999999998E13,\n" +
		"                    \"description\": \"Total IGST value of all items\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 0\n" +
		"                },\n" +
		"                \"RndOffAmt\": {\n" +
		"                    \"maximum\": 99.99,\n" +
		"                    \"description\": \"Rounded off amount\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 0\n" +
		"                },\n" +
		"                \"CesVal\": {\n" +
		"                    \"maximum\": 9.999999999999998E13,\n" +
		"                    \"description\": \"Total CESS value of all items\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 0\n" +
		"                },\n" +
		"                \"TotInvVal\": {\n" +
		"                    \"maximum\": 9.999999999999998E13,\n" +
		"                    \"description\": \"Final Invoice value \",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 0\n" +
		"                },\n" +
		"                \"TotInvValFc\": {\n" +
		"                    \"maximum\": 9.999999999999998E13,\n" +
		"                    \"description\": \"Final Invoice value in Additional Currency\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 0\n" +
		"                },\n" +
		"                \"StCesVal\": {\n" +
		"                    \"maximum\": 9.999999999999998E13,\n" +
		"                    \"description\": \"Total State CESS value of all items\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 0\n" +
		"                },\n" +
		"                \"SgstVal\": {\n" +
		"                    \"maximum\": 9.999999999999998E13,\n" +
		"                    \"description\": \"Total SGST value of all items\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 0\n" +
		"                }\n" +
		"            },\n" +
		"            \"required\": []\n" +
		"        },\n" +
		"\t\t\"DispDtls\": {\n" +
		"            \"type\": \"object\",\n" +
		"            \"properties\": {\n" +
		"                \"Loc\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Location\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Addr1\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Building/Flat no, Road/Street\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Addr2\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Address 2 of the supplier (Floor no., Name of the premises/building)\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Pin\": {\n" +
		"                    \"maximum\": 999999,\n" +
		"                    \"description\": \"Pincode\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 100000\n" +
		"                },\n" +
		"                \"Stcd\": {\n" +
		"                    \"description\": \"State Code\",\n" +
		"                    \"enum\": [\n" +
		"                        \"01\",\n" +
		"                        \"02\",\n" +
		"                        \"03\",\n" +
		"                        \"04\",\n" +
		"                        \"05\",\n" +
		"                        \"06\",\n" +
		"                        \"07\",\n" +
		"                        \"08\",\n" +
		"                        \"09\",\n" +
		"                        \"1\",\n" +
		"                        \"2\",\n" +
		"                        \"3\",\n" +
		"                        \"4\",\n" +
		"                        \"5\",\n" +
		"                        \"6\",\n" +
		"                        \"7\",\n" +
		"                        \"8\",\n" +
		"                        \"9\",\n" +
		"                        \"10\",\n" +
		"                        \"11\",\n" +
		"                        \"12\",\n" +
		"                        \"13\",\n" +
		"                        \"14\",\n" +
		"                        \"15\",\n" +
		"                        \"16\",\n" +
		"                        \"17\",\n" +
		"                        \"18\",\n" +
		"                        \"19\",\n" +
		"                        \"20\",\n" +
		"                        \"21\",\n" +
		"                        \"22\",\n" +
		"                        \"23\",\n" +
		"                        \"24\",\n" +
		"                        \"25\",\n" +
		"                        \"26\",\n" +
		"                        \"27\",\n" +
		"                        \"28\",\n" +
		"                        \"29\",\n" +
		"                        \"30\",\n" +
		"                        \"31\",\n" +
		"                        \"32\",\n" +
		"                        \"33\",\n" +
		"                        \"34\",\n" +
		"                        \"35\",\n" +
		"                        \"36\",\n" +
		"                        \"37\",\n" +
		"                        \"96\",\n" +
		"                        \"97\",\n" +
		"                        \"38\",\n" +
		"                        \"99\"\n" +
		"                    ]\n" +
		"                },\n" +
		"                \"Nm\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Name of the company from which the goods are dispatched\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                }\n" +
		"            },\n" +
		"            \"required\": []\n" +
		"        },\n" +
		"\t\t\"ShipDtls\": {\n" +
		"            \"type\": \"object\",\n" +
		"            \"properties\": {\n" +
		"                \"TrdNm\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Tradename\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Loc\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Place (City,Town,Village) entity to whom the supplies are shipped to.\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Addr1\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Address1 of the entity to whom the supplies are shipped to. (Building/Flat no., Road/Street etc.)\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Gstin\": {\n" +
		"                    \"pattern\": \"^([0-9]{2}[0-9A-Z]{13}|URP)$\",\n" +
		"                    \"description\": \"GSTIN of entity to whom goods are shipped\",\n" +
		"                    \"type\": \"string\"\n" +
		"                },\n" +
		"                \"Addr2\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Address 2 of the entity to whom the supplies are shipped to. (Floor no., Name of the premises/building).\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"Pin\": {\n" +
		"                    \"maximum\": 999999,\n" +
		"                    \"description\": \"Pincode\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 100000\n" +
		"                },\n" +
		"                \"Stcd\": {\n" +
		"                    \"description\": \"State Code to which supplies are shipped to.\",\n" +
		"                    \"enum\": [\n" +
		"                        \"01\",\n" +
		"                        \"02\",\n" +
		"                        \"03\",\n" +
		"                        \"04\",\n" +
		"                        \"05\",\n" +
		"                        \"06\",\n" +
		"                        \"07\",\n" +
		"                        \"08\",\n" +
		"                        \"09\",\n" +
		"                        \"1\",\n" +
		"                        \"2\",\n" +
		"                        \"3\",\n" +
		"                        \"4\",\n" +
		"                        \"5\",\n" +
		"                        \"6\",\n" +
		"                        \"7\",\n" +
		"                        \"8\",\n" +
		"                        \"9\",\n" +
		"                        \"10\",\n" +
		"                        \"11\",\n" +
		"                        \"12\",\n" +
		"                        \"13\",\n" +
		"                        \"14\",\n" +
		"                        \"15\",\n" +
		"                        \"16\",\n" +
		"                        \"17\",\n" +
		"                        \"18\",\n" +
		"                        \"19\",\n" +
		"                        \"20\",\n" +
		"                        \"21\",\n" +
		"                        \"22\",\n" +
		"                        \"23\",\n" +
		"                        \"24\",\n" +
		"                        \"25\",\n" +
		"                        \"26\",\n" +
		"                        \"27\",\n" +
		"                        \"28\",\n" +
		"                        \"29\",\n" +
		"                        \"30\",\n" +
		"                        \"31\",\n" +
		"                        \"32\",\n" +
		"                        \"33\",\n" +
		"                        \"34\",\n" +
		"                        \"35\",\n" +
		"                        \"36\",\n" +
		"                        \"37\",\n" +
		"                        \"96\",\n" +
		"                        \"97\",\n" +
		"                        \"38\",\n" +
		"                        \"99\"\n" +
		"                    ]\n" +
		"                },\n" +
		"                \"LglNm\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Legal Name\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                }\n" +
		"            },\n" +
		"            \"required\": []\n" +
		"        },\n" +
		"\t\t\"EwbDtls\": {\n" +
		"            \"type\": \"object\",\n" +
		"            \"properties\": {\n" +
		"                \"TransDocNo\": {\n" +
		"                    \"pattern\": \"^([0-9A-Z/-]){1,15}$\",\n" +
		"                    \"description\": \"Tranport Document Number\",\n" +
		"                    \"type\": \"string\"\n" +
		"                },\n" +
		"                \"TransDocDt\": {\n" +
		"                    \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\n" +
		"                    \"description\": \"Transport Document Date\",\n" +
		"                    \"type\": \"string\"\n" +
		"                },\n" +
		"                \"VehNo\": {\n" +
		"                    \"minLength\": 4,\n" +
		"                    \"description\": \"Vehicle Number\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 20\n" +
		"                },\n" +
		"                \"VehType\": {\n" +
		"                    \"description\": \"Whether O-ODC or R-Regular \",\n" +
		"                    \"enum\": [\n" +
		"                        \"O\",\n" +
		"                        \"R\"\n" +
		"                    ]\n" +
		"                },\n" +
		"                \"TransName\": {\n" +
		"                    \"minLength\": 3,\n" +
		"                    \"description\": \"Name of the transporter\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 100\n" +
		"                },\n" +
		"                \"TransId\": {\n" +
		"                    \"minLength\": 15,\n" +
		"                    \"description\": \"Transin/GSTIN\",\n" +
		"                    \"type\": \"string\",\n" +
		"                    \"maxLength\": 15\n" +
		"                },\n" +
		"                \"TransMode\": {\n" +
		"                    \"description\": \"Mode of transport (Road-1, Rail-2, Air-3, Ship-4)\",\n" +
		"                    \"enum\": [\n" +
		"                        \"1\",\n" +
		"                        \"2\",\n" +
		"                        \"3\",\n" +
		"                        \"4\"\n" +
		"                    ]\n" +
		"                },\n" +
		"                \"Distance\": {\n" +
		"                    \"maximum\": 4000,\n" +
		"                    \"description\": \"Distance between source and destination PIN codes\",\n" +
		"                    \"type\": \"number\",\n" +
		"                    \"minimum\": 0\n" +
		"                }\n" +
		"            },\n" +
		"            \"required\": [\n" +
		"                \"Distance\"\n" +
		"            ]\n" +
		"        },\n" +
		"\t\t\"ItemList\": {\n" +
		"            \"contains\": {\n" +
		"                \"type\": \"object\"\n" +
		"            },\n" +
		"            \"type\": \"array\",\n" +
		"            \"items\": {\n" +
		"                \"type\": \"object\",\n" +
		"                \"properties\": {\n" +
		"                    \"SgstAmt\": {\n" +
		"                        \"maximum\": 9.9999999999999E11,\n" +
		"                        \"description\": \" Amount of SGST payable.\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"Discount\": {\n" +
		"                        \"maximum\": 9.9999999999999E11,\n" +
		"                        \"description\": \"Discount\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"IsServc\": {\n" +
		"                        \"description\": \"Specify whether the supply is service or not. Specify Y-for Service\",\n" +
		"                        \"enum\": [\n" +
		"                            \"Y\",\n" +
		"                            \"N\"\n" +
		"                        ]\n" +
		"                    },\n" +
		"                    \"CesNonAdvlAmt\": {\n" +
		"                        \"maximum\": 9.9999999999999E11,\n" +
		"                        \"description\": \"Cess Non-Advol Amount\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"HsnCd\": {\n" +
		"                        \"pattern\": \"^[0-9]{4,8}$\",\n" +
		"                        \"description\": \"HSN Code\",\n" +
		"                        \"type\": \"string\"\n" +
		"                    },\n" +
		"                    \"AttribDtls\": {\n" +
		"                        \"type\": \"array\",\n" +
		"                        \"items\": {\n" +
		"                            \"type\": \"object\",\n" +
		"                            \"properties\": {\n" +
		"                                \"Val\": {\n" +
		"                                    \"minLength\": 1,\n" +
		"                                    \"description\": \"Attribute value of the item\",\n" +
		"                                    \"type\": \"string\",\n" +
		"                                    \"maxLength\": 100\n" +
		"                                },\n" +
		"                                \"Nm\": {\n" +
		"                                    \"minLength\": 1,\n" +
		"                                    \"description\": \"Attribute details of the item\",\n" +
		"                                    \"type\": \"string\",\n" +
		"                                    \"maxLength\": 100\n" +
		"                                }\n" +
		"                            }\n" +
		"                        }\n" +
		"                    },\n" +
		"                    \"Unit\": {\n" +
		"                        \"description\": \"Unit\",\n" +
		"                        \"enum\": [\n" +
		"                            \"BAG\",\n" +
		"                            \"BAL\",\n" +
		"                            \"BDL\",\n" +
		"                            \"BGS\",\n" +
		"                            \"BKL\",\n" +
		"                            \"BND\",\n" +
		"                            \"BOU\",\n" +
		"                            \"BOX\",\n" +
		"                            \"BTL\",\n" +
		"                            \"BUN\",\n" +
		"                            \"CAN\",\n" +
		"                            \"CBM\",\n" +
		"                            \"CCM\",\n" +
		"                            \"CMS\",\n" +
		"                            \"CMT\",\n" +
		"                            \"CTN\",\n" +
		"                            \"DOZ\",\n" +
		"                            \"DRM\",\n" +
		"                            \"DZN\",\n" +
		"                            \"GGK\",\n" +
		"                            \"GMS\",\n" +
		"                            \"GRS\",\n" +
		"                            \"GYD\",\n" +
		"                            \"KGS\",\n" +
		"                            \"KLR\",\n" +
		"                            \"KME\",\n" +
		"                            \"KMS\",\n" +
		"                            \"LTR\",\n" +
		"                            \"MLS\",\n" +
		"                            \"MLT\",\n" +
		"                            \"MTR\",\n" +
		"                            \"MTS\",\n" +
		"                            \"NOS\",\n" +
		"                            \"OTH\",\n" +
		"                            \"PAC\",\n" +
		"                            \"PAR\",\n" +
		"                            \"PCS\",\n" +
		"                            \"PRS\",\n" +
		"                            \"QTL\",\n" +
		"                            \"QTS\",\n" +
		"                            \"ROL\",\n" +
		"                            \"SET\",\n" +
		"                            \"SFT\",\n" +
		"                            \"SMT\",\n" +
		"                            \"SNO\",\n" +
		"                            \"SQF\",\n" +
		"                            \"SQM\",\n" +
		"                            \"SQY\",\n" +
		"                            \"TBS\",\n" +
		"                            \"TGM\",\n" +
		"                            \"THD\",\n" +
		"                            \"TON\",\n" +
		"                            \"TUB\",\n" +
		"                            \"UGS\",\n" +
		"                            \"UNT\",\n" +
		"                            \"YDS\"\n" +
		"                        ]\n" +
		"                    },\n" +
		"                    \"CesRt\": {\n" +
		"                        \"maximum\": 999.999,\n" +
		"                        \"description\": \"Cess Rate\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"CesAmt\": {\n" +
		"                        \"maximum\": 9.9999999999999E11,\n" +
		"                        \"description\": \"Cess Amount(Advalorem) on basis of rate and quantity of item\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"StateCesNonAdvlAmt\": {\n" +
		"                        \"maximum\": 9.9999999999999E11,\n" +
		"                        \"description\": \"State CESS Non Adval Amount\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"AssAmt\": {\n" +
		"                        \"maximum\": 9.9999999999999E11,\n" +
		"                        \"description\": \"Taxable Value (Total Amount -Discount)\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"GstRt\": {\n" +
		"                        \"description\": \"The GST rate, represented as percentage that applies to the invoiced item. It will IGST rate only.\",\n" +
		"                        \"enum\": [\n" +
		"                            0,\n" +
		"                            0.1,\n" +
		"                            0.25,\n" +
		"                            1,\n" +
		"                            1.5,\n" +
		"                            3,\n" +
		"                            5,\n" +
		"                            7.5,\n" +
		"                            12,\n" +
		"                            18,\n" +
		"                            28\n" +
		"                        ]\n" +
		"                    },\n" +
		"                    \"Qty\": {\n" +
		"                        \"maximum\": 9.999999999999E9,\n" +
		"                        \"description\": \"Quantity\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"StateCesAmt\": {\n" +
		"                        \"maximum\": 9.9999999999999E11,\n" +
		"                        \"description\": \"State CESS Amount\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"IgstAmt\": {\n" +
		"                        \"maximum\": 9.9999999999999E11,\n" +
		"                        \"description\": \" Amount of IGST payable.\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"OrdLineRef\": {\n" +
		"                        \"minLength\": 1,\n" +
		"                        \"description\": \"Order line referencee\",\n" +
		"                        \"type\": \"string\",\n" +
		"                        \"maxLength\": 50\n" +
		"                    },\n" +
		"                    \"OthChrg\": {\n" +
		"                        \"maximum\": 9.9999999999999E11,\n" +
		"                        \"description\": \"Other Charges\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"TotAmt\": {\n" +
		"                        \"maximum\": 9.9999999999999E11,\n" +
		"                        \"description\": \"Gross Amount (Unit Price * Quantity)\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"OrgCntry\": {\n" +
		"                        \"description\": \"Orgin Country\",\n" +
		"                        \"enum\": [\n" +
		"                            \"AD\",\n" +
		"                            \"AE\",\n" +
		"                            \"AF\",\n" +
		"                            \"AG\",\n" +
		"                            \"AI\",\n" +
		"                            \"AL\",\n" +
		"                            \"AM\",\n" +
		"                            \"AO\",\n" +
		"                            \"AQ\",\n" +
		"                            \"AR\",\n" +
		"                            \"AS\",\n" +
		"                            \"AT\",\n" +
		"                            \"AU\",\n" +
		"                            \"AW\",\n" +
		"                            \"AX\",\n" +
		"                            \"AZ\",\n" +
		"                            \"BA\",\n" +
		"                            \"BB\",\n" +
		"                            \"BD\",\n" +
		"                            \"BE\",\n" +
		"                            \"BF\",\n" +
		"                            \"BG\",\n" +
		"                            \"BH\",\n" +
		"                            \"BI\",\n" +
		"                            \"BJ\",\n" +
		"                            \"BL\",\n" +
		"                            \"BM\",\n" +
		"                            \"BN\",\n" +
		"                            \"BO\",\n" +
		"                            \"BQ\",\n" +
		"                            \"BR\",\n" +
		"                            \"BS\",\n" +
		"                            \"BT\",\n" +
		"                            \"BV\",\n" +
		"                            \"BW\",\n" +
		"                            \"BY\",\n" +
		"                            \"BZ\",\n" +
		"                            \"CA\",\n" +
		"                            \"CC\",\n" +
		"                            \"CD\",\n" +
		"                            \"CF\",\n" +
		"                            \"CG\",\n" +
		"                            \"CH\",\n" +
		"                            \"CI\",\n" +
		"                            \"CK\",\n" +
		"                            \"CL\",\n" +
		"                            \"CM\",\n" +
		"                            \"CN\",\n" +
		"                            \"CO\",\n" +
		"                            \"CR\",\n" +
		"                            \"CU\",\n" +
		"                            \"CV\",\n" +
		"                            \"CW\",\n" +
		"                            \"CX\",\n" +
		"                            \"CY\",\n" +
		"                            \"CZ\",\n" +
		"                            \"DE\",\n" +
		"                            \"DJ\",\n" +
		"                            \"DK\",\n" +
		"                            \"DM\",\n" +
		"                            \"DO\",\n" +
		"                            \"DZ\",\n" +
		"                            \"EC\",\n" +
		"                            \"EE\",\n" +
		"                            \"EG\",\n" +
		"                            \"EH\",\n" +
		"                            \"ER\",\n" +
		"                            \"ES\",\n" +
		"                            \"ET\",\n" +
		"                            \"FI\",\n" +
		"                            \"FJ\",\n" +
		"                            \"FK\",\n" +
		"                            \"FM\",\n" +
		"                            \"FO\",\n" +
		"                            \"FR\",\n" +
		"                            \"GA\",\n" +
		"                            \"GB\",\n" +
		"                            \"GD\",\n" +
		"                            \"GE\",\n" +
		"                            \"GF\",\n" +
		"                            \"GG\",\n" +
		"                            \"GH\",\n" +
		"                            \"GI\",\n" +
		"                            \"GL\",\n" +
		"                            \"GM\",\n" +
		"                            \"GN\",\n" +
		"                            \"GP\",\n" +
		"                            \"GQ\",\n" +
		"                            \"GR\",\n" +
		"                            \"GS\",\n" +
		"                            \"GT\",\n" +
		"                            \"GU\",\n" +
		"                            \"GW\",\n" +
		"                            \"GY\",\n" +
		"                            \"HK\",\n" +
		"                            \"HM\",\n" +
		"                            \"HN\",\n" +
		"                            \"HR\",\n" +
		"                            \"HT\",\n" +
		"                            \"HU\",\n" +
		"                            \"ID\",\n" +
		"                            \"IE\",\n" +
		"                            \"IL\",\n" +
		"                            \"IM\",\n" +
		"                            \"IN\",\n" +
		"                            \"IO\",\n" +
		"                            \"IQ\",\n" +
		"                            \"IR\",\n" +
		"                            \"IS\",\n" +
		"                            \"IT\",\n" +
		"                            \"JE\",\n" +
		"                            \"JM\",\n" +
		"                            \"JO\",\n" +
		"                            \"JP\",\n" +
		"                            \"KE\",\n" +
		"                            \"KG\",\n" +
		"                            \"KH\",\n" +
		"                            \"KI\",\n" +
		"                            \"KM\",\n" +
		"                            \"KN\",\n" +
		"                            \"KP\",\n" +
		"                            \"KR\",\n" +
		"                            \"KW\",\n" +
		"                            \"KY\",\n" +
		"                            \"KZ\",\n" +
		"                            \"LA\",\n" +
		"                            \"LB\",\n" +
		"                            \"LC\",\n" +
		"                            \"LI\",\n" +
		"                            \"LK\",\n" +
		"                            \"LR\",\n" +
		"                            \"LS\",\n" +
		"                            \"LT\",\n" +
		"                            \"LU\",\n" +
		"                            \"LV\",\n" +
		"                            \"LY\",\n" +
		"                            \"MA\",\n" +
		"                            \"MC\",\n" +
		"                            \"MD\",\n" +
		"                            \"ME\",\n" +
		"                            \"MF\",\n" +
		"                            \"MG\",\n" +
		"                            \"MH\",\n" +
		"                            \"MK\",\n" +
		"                            \"ML\",\n" +
		"                            \"MM\",\n" +
		"                            \"MN\",\n" +
		"                            \"MO\",\n" +
		"                            \"MP\",\n" +
		"                            \"MQ\",\n" +
		"                            \"MR\",\n" +
		"                            \"MS\",\n" +
		"                            \"MT\",\n" +
		"                            \"MU\",\n" +
		"                            \"MV\",\n" +
		"                            \"MW\",\n" +
		"                            \"MX\",\n" +
		"                            \"MY\",\n" +
		"                            \"MZ\",\n" +
		"                            \"NA\",\n" +
		"                            \"NC\",\n" +
		"                            \"NE\",\n" +
		"                            \"NF\",\n" +
		"                            \"NG\",\n" +
		"                            \"NI\",\n" +
		"                            \"NL\",\n" +
		"                            \"NO\",\n" +
		"                            \"NP\",\n" +
		"                            \"NR\",\n" +
		"                            \"NU\",\n" +
		"                            \"NZ\",\n" +
		"                            \"OM\",\n" +
		"                            \"PA\",\n" +
		"                            \"PE\",\n" +
		"                            \"PF\",\n" +
		"                            \"PG\",\n" +
		"                            \"PH\",\n" +
		"                            \"PK\",\n" +
		"                            \"PL\",\n" +
		"                            \"PM\",\n" +
		"                            \"PN\",\n" +
		"                            \"PR\",\n" +
		"                            \"PS\",\n" +
		"                            \"PT\",\n" +
		"                            \"PW\",\n" +
		"                            \"PY\",\n" +
		"                            \"QA\",\n" +
		"                            \"RE\",\n" +
		"                            \"RO\",\n" +
		"                            \"RS\",\n" +
		"                            \"RU\",\n" +
		"                            \"RW\",\n" +
		"                            \"SA\",\n" +
		"                            \"SB\",\n" +
		"                            \"SC\",\n" +
		"                            \"SD\",\n" +
		"                            \"SE\",\n" +
		"                            \"SG\",\n" +
		"                            \"SH\",\n" +
		"                            \"SI\",\n" +
		"                            \"SJ\",\n" +
		"                            \"SK\",\n" +
		"                            \"SL\",\n" +
		"                            \"SM\",\n" +
		"                            \"SN\",\n" +
		"                            \"SO\",\n" +
		"                            \"SR\",\n" +
		"                            \"SS\",\n" +
		"                            \"ST\",\n" +
		"                            \"SV\",\n" +
		"                            \"SX\",\n" +
		"                            \"SY\",\n" +
		"                            \"SZ\",\n" +
		"                            \"TC\",\n" +
		"                            \"TD\",\n" +
		"                            \"TF\",\n" +
		"                            \"TG\",\n" +
		"                            \"TH\",\n" +
		"                            \"TJ\",\n" +
		"                            \"TK\",\n" +
		"                            \"TL\",\n" +
		"                            \"TM\",\n" +
		"                            \"TN\",\n" +
		"                            \"TO\",\n" +
		"                            \"TR\",\n" +
		"                            \"TT\",\n" +
		"                            \"TV\",\n" +
		"                            \"TW\",\n" +
		"                            \"TZ\",\n" +
		"                            \"UA\",\n" +
		"                            \"UG\",\n" +
		"                            \"UM\",\n" +
		"                            \"US\",\n" +
		"                            \"UY\",\n" +
		"                            \"UZ\",\n" +
		"                            \"VA\",\n" +
		"                            \"VC\",\n" +
		"                            \"VE\",\n" +
		"                            \"VG\",\n" +
		"                            \"VI\",\n" +
		"                            \"VN\",\n" +
		"                            \"VU\",\n" +
		"                            \"WF\",\n" +
		"                            \"WS\",\n" +
		"                            \"YE\",\n" +
		"                            \"YT\",\n" +
		"                            \"ZA\",\n" +
		"                            \"ZM\",\n" +
		"                            \"ZW\"\n" +
		"                        ]\n" +
		"                    },\n" +
		"                    \"CgstAmt\": {\n" +
		"                        \"maximum\": 9.9999999999999E11,\n" +
		"                        \"description\": \" Amount of CGST payable.\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"PrdDesc\": {\n" +
		"                        \"minLength\": 3,\n" +
		"                        \"description\": \"Product Description\",\n" +
		"                        \"type\": \"string\",\n" +
		"                        \"maxLength\": 300\n" +
		"                    },\n" +
		"                    \"FreeQty\": {\n" +
		"                        \"maximum\": 9.999999999999E9,\n" +
		"                        \"description\": \"Free Quantity\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"UnitPrice\": {\n" +
		"                        \"maximum\": 9.99999999999999E11,\n" +
		"                        \"description\": \"Unit Price - Rate\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"StateCesRt\": {\n" +
		"                        \"maximum\": 999.999,\n" +
		"                        \"description\": \"State CESS Rate\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"PreTaxVal\": {\n" +
		"                        \"maximum\": 9.9999999999999E11,\n" +
		"                        \"description\": \"Pre tax value\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"BchDtls\": {\n" +
		"                        \"type\": \"object\",\n" +
		"                        \"properties\": {\n" +
		"                            \"WrDt\": {\n" +
		"                                \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\n" +
		"                                \"description\": \"Warranty Date\",\n" +
		"                                \"type\": \"string\"\n" +
		"                            },\n" +
		"                            \"ExpDt\": {\n" +
		"                                \"pattern\": \"^([0-3][0-9]/[0-1][0-9]/[2][0][1-2][0-9])$\",\n" +
		"                                \"description\": \"Batch Expiry Date\",\n" +
		"                                \"type\": \"string\"\n" +
		"                            },\n" +
		"                            \"Nm\": {\n" +
		"                                \"minLength\": 3,\n" +
		"                                \"description\": \"Batch name\",\n" +
		"                                \"type\": \"string\",\n" +
		"                                \"maxLength\": 20\n" +
		"                            }\n" +
		"                        },\n" +
		"                        \"required\": [\n" +
		"                            \"Nm\"\n" +
		"                        ]\n" +
		"                    },\n" +
		"                    \"SlNo\": {\n" +
		"                        \"pattern\": \"^[0-9]{1,6}$\",\n" +
		"                        \"description\": \"Serial No. of Item\",\n" +
		"                        \"type\": \"string\"\n" +
		"                    },\n" +
		"                    \"Barcde\": {\n" +
		"                        \"minLength\": 3,\n" +
		"                        \"description\": \"Bar Code\",\n" +
		"                        \"type\": \"string\",\n" +
		"                        \"maxLength\": 30\n" +
		"                    },\n" +
		"                    \"TotItemVal\": {\n" +
		"                        \"maximum\": 9.9999999999999E11,\n" +
		"                        \"description\": \"Total Item Value = Assessable Amount + CGST Amt + SGST Amt + Cess Amt + CesNonAdvlAmt + StateCesAmt + StateCesNonAdvlAmt+Otherchrg\",\n" +
		"                        \"type\": \"number\",\n" +
		"                        \"minimum\": 0\n" +
		"                    },\n" +
		"                    \"PrdSlNo\": {\n" +
		"                        \"minLength\": 1,\n" +
		"                        \"description\": \"Serial number in case of each item having a unique number.\",\n" +
		"                        \"type\": \"string\",\n" +
		"                        \"maxLength\": 20\n" +
		"                    }\n" +
		"                },\n" +
		"                \"required\": [\n" +
		"                    \"HsnCd\",\n" +
		"                    \"AssAmt\"\n" +
		"                ]\n" +
		"            }\n" +
		"        },\n" +
		"    },\n" +
		"    \"required\": [\n" +
		"        \"User_GSTIN\",\n" +
		"        \"Version\",\n" +
		"        \"TranDtls\",\n" +
		"        \"DocDtls\",\n" +
		"        \"SellerDtls\",\n" +
		"        \"BuyerDtls\",\n" +
		"        \"ItemList\",\n" +
		"        \"ValDtls\",\n" +
		"        \"EwbDtls\",\n" +
		"    ]\n" +
		"}";
}
