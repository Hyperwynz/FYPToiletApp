package com.example.a14023882.fyptoiletapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AddToiletRequest extends StringRequest{
    private static final String ADDTOILET_REQUEST_URL = "http://homes.soi.rp.edu.sg/124610/addToilet.php";
    private Map<String , String> params;

    public AddToiletRequest(String location, String toilet_gender, String no_of_urinal, String no_of_cubicles, String latitude, String longitude, String owner_email, Response.Listener<String> listener){
        super(Request.Method.POST, ADDTOILET_REQUEST_URL, listener, null );
        params = new HashMap<>();
        params.put("location",location);
        params.put("toilet_gender",toilet_gender);
        params.put("no_of_urinal",no_of_urinal);
        params.put("no_of_cubicles",no_of_cubicles);
        params.put("latitude",latitude);
        params.put("longitude",longitude);
        params.put("owner_email",owner_email);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
