package com.example.a124610.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        String username = getIntent().getStringExtra("username");
        final Button bSearchText = (Button) findViewById(R.id.bSearchText);
        final Button bSearchMap = (Button) findViewById(R.id.bSearchMap);
        final TextView tvUsername = (TextView) findViewById(R.id.tvUsername);

        tvUsername.setText(username + " !");





    }
}
