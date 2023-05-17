package com.pwc.nic.util;

import com.pwc.nic.model.EwbDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.sql.DataSource;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import static com.pwc.nic.util.Constants.*;

@Component
public class Utils {

    @Autowired
    DataSource dataSource;

   public static boolean isError(HttpStatus status) {
       HttpStatus.Series series = status.series();
       return (HttpStatus.Series.CLIENT_ERROR.equals(series)
               || HttpStatus.Series.SERVER_ERROR.equals(series));
   }

    public static String formattedCurrentDateAtServerTimeZone() {
        ZonedDateTime now = ZonedDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssZ"));
    }
    public static String encrypt(String sek, String dataJson) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] sekBytesEncoded = sek.getBytes();
        byte[] sekBytes = Base64.getDecoder().decode(sekBytesEncoded);
        byte[] dataBytes = dataJson.getBytes();
        Cipher cipher = Cipher.getInstance(PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(sekBytes, AES));
        byte[] encrypted = cipher.doFinal(dataBytes);
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String message, String key) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] sekBytesEncoded = key.getBytes();
        byte[] sekBytes = Base64.getDecoder().decode(sekBytesEncoded);
        byte[] dataBytes = Base64.getDecoder().decode(message);
        Cipher cipher = Cipher.getInstance(PADDING);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(sekBytes, AES));
        byte[] decrypted = cipher.doFinal(dataBytes);
        return new String(decrypted);
    }

    public EwbDetails generateLoadId(EwbDetails ewbDetails) throws SQLException {
        try (Connection connection = dataSource.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement("select NEXT VALUE for ewb_cusdb.demo" +
//                 ".upload_id_seq as loadId")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select NEXT VALUE for demo" +
                ".upload_id_seq as loadId")) { //SwitchSamsungDB
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int loadId = Integer.parseInt(resultSet.getString("loadId"));
                    ewbDetails.setLoadId(loadId);
                }
            }
        }
        return ewbDetails;
    }

    public EwbDetails fetchBuId(String bu, EwbDetails ewbDetails) throws SQLException {
        if (!StringUtils.isEmpty(bu)) {
            try (Connection connection = dataSource.getConnection();
//                 PreparedStatement preparedStatement = connection.prepareStatement("select bu_id " +
//                     "from ewb_cusdb.demo.bu_master where bu=? and active='Y'")) {
                PreparedStatement preparedStatement = connection.prepareStatement("select bu_id " +
                    "from demo.bu_master where bu=? and active='Y'")) { //SwitchSamsungDB
                preparedStatement.setString(1, bu);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    int buId = (resultSet.next() && !StringUtils.isEmpty(resultSet.getString(BU_ID))) ?
                        Integer.parseInt(resultSet.getString(BU_ID)) : -1;
                    ewbDetails.setBuId(resultSet.next() ? buId : -1);
                }
            }
        } else {
            ewbDetails.setBuId(0);
        }
        return ewbDetails;
    }

    public EwbDetails fetchSbuId(String sbu, EwbDetails ewbDetails) throws SQLException {
        if (!StringUtils.isEmpty(sbu)) {
            try (Connection connection = dataSource.getConnection();
//                 PreparedStatement preparedStatement = connection.prepareStatement("select sbu_id from " +
//                     "ewb_cusdb.demo.sbu_master where sbu_name=? and active='Y'")) {
                PreparedStatement preparedStatement = connection.prepareStatement("select sbu_id from " +
                    "ewb_cusdb.demo.sbu_master where sbu_name=? and active='Y'")) { //SwitchSamsungDB
                preparedStatement.setString(1, sbu);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    int sbuId = (resultSet.next() && !StringUtils.isEmpty(resultSet.getString(SBU_ID))) ?
                        Integer.parseInt(resultSet.getString(SBU_ID)) : -1;
                    ewbDetails.setSbuId(resultSet.next() ? sbuId : -1);
                }
            }
        } else {
            ewbDetails.setSbuId(0);
        }
        return ewbDetails;
    }

    public EwbDetails fetchLocationId(String location, EwbDetails ewbDetails) throws SQLException {
        if (!StringUtils.isEmpty(location)) {
            try (Connection connection = dataSource.getConnection();
//                 PreparedStatement preparedStatement = connection.prepareStatement("select location_id from " +
//                     "ewb_cusdb.demo.location_master where location_name=? and active='Y'")) {
                PreparedStatement preparedStatement = connection.prepareStatement("select location_id from " +
                    "demo.location_master where location_name=? and active='Y'")) { //SwitchSamsungDB
                preparedStatement.setString(1, location);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    int locationId =
                        (resultSet.next() && !StringUtils.isEmpty(resultSet.getString(LOCATION_ID))) ?
                            Integer.parseInt(resultSet.getString(LOCATION_ID)) : -1;
                    ewbDetails.setLocationId(resultSet.next() ? locationId : -1);
                }
            }
        } else {
            ewbDetails.setLocationId(0);
        }
        return ewbDetails;
    }
}