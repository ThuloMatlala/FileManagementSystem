package com.tprice.userManagement;

import com.tprice.userManagement.model.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.test.util.ReflectionTestUtils;

public class TestHelper {

    public JSONObject AddSingleUserJSONObject() throws JSONException
    {
        JSONObject userDetails = new JSONObject();
        userDetails.put("id", 1);
        userDetails.put("firstName", "Test First Name");
        userDetails.put("lastName", "Test Last Name");
        userDetails.put("phone", "+00(111)-222-3333");
        userDetails.put("position", "Test Position");
        userDetails.put("companyName", "Test Company");
        return userDetails;
    }

    public JSONObject AddMultipleUserJSONObjects() throws JSONException
    {
        JSONObject userDetails = new JSONObject();
        JSONObject userObject = new JSONObject();
        userDetails.put("id", 1);
        userDetails.put("firstName", "Test First Name");
        userDetails.put("lastName", "Test Last Name");
        userDetails.put("phone", "+00(111)-222-3333");
        userDetails.put("position", "Test Position");
        userDetails.put("companyName", "Test Company");
        userObject.put("user", userDetails);

        userDetails.put("id", 2);
        userDetails.put("firstName", "2Test First Name");
        userDetails.put("lastName", "2Test Last Name");
        userDetails.put("phone", "2+00(111)-222-3333");
        userDetails.put("position", "2Test Position");
        userDetails.put("companyName", "2Test Company");

        userDetails.put("id", 3);
        userDetails.put("firstName", "3Test First Name");
        userDetails.put("lastName", "3Test Last Name");
        userDetails.put("phone", "3+00(111)-222-3333");
        userDetails.put("position", "3Test Position");
        userDetails.put("companyName", "3Test Company");
        userObject.put("user", userDetails);


        userDetails.put("id", 4);
        userDetails.put("firstName", "4Test First Name");
        userDetails.put("lastName", "4Test Last Name");
        userDetails.put("phone", "4+00(111)-222-3333");
        userDetails.put("position", "4Test Position");
        userDetails.put("companyName", "4Test Company");
        userObject.put("user", userDetails);

        return userObject;
    }
}
