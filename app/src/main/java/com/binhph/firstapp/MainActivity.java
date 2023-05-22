package com.binhph.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText edtUsername, edtPassword;
    private Spinner spinner;
    private String campus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsername = findViewById(R.id.username);
        edtPassword = findViewById(R.id.password);
        spinner = findViewById(R.id.spinner);

        Button button = findViewById(R.id.btnLogin);

        // Set layout for spinner
        spinner.setOnItemSelectedListener(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin(v);
            }
        });
    }

    public void onLogin(View view) {
        //Toast.makeText(this, "Login is clicked", Toast.LENGTH_SHORT).show();
        String userName = edtUsername.getText().toString();
        String passWord = edtPassword.getText().toString();
        if (userName.isEmpty()) {
            edtUsername.setError("Username is required");
            return;
        }
        if (passWord.trim().isEmpty()) {
            edtPassword.setError("Password is required");
            return;
        }
        if (campus.isEmpty()) {
            Toast.makeText(this, "Campus is required", Toast.LENGTH_SHORT);
            return;
        }

        //Uri uri = Uri.parse("https://www.google.com.vn");
        //Intent i = new Intent(Intent.ACTION_VIEW, uri);

        Intent intent = new Intent(this, ProfileDetailActivity.class);
        intent.putExtra(IntentKeys.USER_NAME, userName);
        intent.putExtra(IntentKeys.PASSWORD, passWord);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        campus = parent.getItemAtPosition(parent.getSelectedItemPosition()).toString();
        //Toast.makeText(MainActivity.this, "Selected item : " + campus, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onStart() {
        // Create an adapter to handle data in spinner
        super.onStart();
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter
                .createFromResource(this, R.array.spinnerArray, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Code here to process when activity change from pause to resume
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        campus = null;
    }
}