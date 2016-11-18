package com.example.a124610.loginregister;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 124610 on 8/11/2016.
 */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://toiletapp.000webhostapp.com/register.php";
    private Map<String , String> params;

    public RegisterRequest(String email, String username, String phoneNo, String password, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null );
        params = new HashMap<>();
        params.put("email", email);
        params.put("username",username);
        params.put("phoneNo",phoneNo);
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
