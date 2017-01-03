package com.example.a14023882.fyptoiletapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AddToiletActivity extends AppCompatActivity {

    private RadioButton radioSexGroup;
    private RadioButton radioSexButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtoilet);

        final EditText etLocation = (EditText) findViewById(R.id.etLocation);
        final RadioButton rbMale = (RadioButton) findViewById(R.id.rbMale);
        final RadioButton rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        final EditText etCubicle = (EditText) findViewById(R.id.etCubicle);
        final EditText etUrinal = (EditText) findViewById(R.id.etUrinal);
        final Button bSetLocation = (Button) findViewById(R.id.bSetLocation);
        final EditText etLatitude = (EditText) findViewById(R.id.etLatitude);
        final EditText etLongitude = (EditText) findViewById(R.id.etLongitude);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final Button bAddToilet = (Button) findViewById(R.id.bAddToilet);
        final RadioGroup radioSexGroup = (RadioGroup) findViewById(R.id.rgSex);


        bAddToilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String location = etLocation.getText().toString();
                final String no_of_urinal = etUrinal.getText().toString();
                final String no_of_cubicles = etCubicle.getText().toString();
                final String longitude = etLongitude.getText().toString();
                final String latitude = etLatitude.getText().toString();
                final String owner_email = etEmail.getText().toString();
                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);
                final String toilet_gender = radioSexButton.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Toast.makeText(AddToiletActivity.this, "Add Toilet Successful!", Toast.LENGTH_LONG).show();

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(AddToiletActivity.this);
                                builder.setMessage("Add Toilet Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                };

                AddToiletRequest addtoiletRequest = new AddToiletRequest(location, toilet_gender, no_of_urinal, no_of_cubicles, latitude, longitude, owner_email, responseListener);
                RequestQueue queue = Volley.newRequestQueue(AddToiletActivity.this);
                queue.add(addtoiletRequest);

            }
        });
    }

    public void onRadioButtonClicked (View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbMale:
                if (checked)

                break;

            case R.id.rbFemale:
                if (checked)

                break;
        }

    }

}
