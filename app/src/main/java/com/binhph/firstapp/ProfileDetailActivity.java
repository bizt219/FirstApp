package com.binhph.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);
        Intent intent = getIntent();
        String firstName = intent.getStringExtra(IntentKeys.FIRST_NAME);
        TextView txtFirstName = findViewById(R.id.txtFirst);
        txtFirstName.setText(firstName);
        String lastName = intent.getStringExtra(IntentKeys.LAST_NAME);
        TextView txtLastName = findViewById(R.id.txtSecond);
        txtLastName.setText(lastName);
        TextView txtPhone = findViewById(R.id.txtFourth);
        String phone = intent.getStringExtra(IntentKeys.PHONE);
        txtPhone.setText(phone);

        // Back to login
        Button btnBackToLogin = findViewById(R.id.btnBack);
        btnBackToLogin.setOnClickListener(v -> onBackLogin());

        // Button Edit
        Button btnEditData = findViewById(R.id.btnEdit);
        btnEditData.setOnClickListener(v -> onEditData());
    }

    public void onBackLogin(){
        Intent intent = new Intent();
        intent.putExtra("MSG", "This sent from Profile Detail");
        setResult(1, intent);
        finish();
    }

    public void onEditData(){
        Intent intent = new Intent(this, EditProfileDetail.class);
        startActivity(intent);
    }
}