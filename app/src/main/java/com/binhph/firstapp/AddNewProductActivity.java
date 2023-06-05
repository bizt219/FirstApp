package com.binhph.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddNewProductActivity extends AppCompatActivity {
    private EditText edtProductName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_product);
        Button btSaveProduct = findViewById(R.id.btSaveProduct);
        edtProductName = findViewById(R.id.edtProductName);
        btSaveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtProductName.getText().toString().trim().length() == 0){
                    edtProductName.setError("Product name is required");
                    edtProductName.setText(edtProductName.getText().toString().trim());
                    return;
                }else {
                    Intent intent = new Intent();
                    intent.putExtra(IntentKeys.PRODUCT_NAME, edtProductName.getText().toString().trim());
                    setResult(2, intent);
                    finish();
                }

            }
        });
    }
}