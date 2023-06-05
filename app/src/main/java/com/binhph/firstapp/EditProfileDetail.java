package com.binhph.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditProfileDetail extends AppCompatActivity {

    private EditText edtFirstName, edtLastName, edtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_detail);
        Button btnSave = findViewById(R.id.btnSave);
        edtFirstName = findViewById(R.id.edtEditFirstName);
        edtLastName = findViewById(R.id.edtEditLastName);
        edtPhone = findViewById(R.id.edtEditPhone);

        btnSave.setOnClickListener(v -> sendData());
    }

    public void sendData(){
        String firstName = edtFirstName.getText().toString();
        String lastName = edtLastName.getText().toString();
        String phone = edtPhone.getText().toString();
        Intent intent = new Intent(this, ProfileDetailActivity.class);
        intent.putExtra(IntentKeys.FIRST_NAME, firstName);
        intent.putExtra(IntentKeys.LAST_NAME, lastName);
        intent.putExtra(IntentKeys.PHONE, phone);
        startActivity(intent);
    }
}