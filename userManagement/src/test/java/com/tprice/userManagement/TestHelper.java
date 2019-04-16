package com.tprice.userManagement;

import org.json.JSONException;
import org.json.JSONObject;

public class TestHelper {

    public JSONObject AddSingleUser() throws JSONException
    {
        JSONObject userDetails = new JSONObject();
        userDetails.put("id", 1);
        userDetails.put("firstName", "Test First Name");
        userDetails.put("lastName", "Test Last Name");
        userDetails.put("phone", "+00(111)-222-3333");
        userDetails.put("position", "Test Position");
        userDetails.put("companyName", "Test Company");
        userDetails.put("tradingName", "Test Trading Name");
        userDetails.put("cdibGrade", "Test CDIB GRADE");
        return userDetails;
    }
}
