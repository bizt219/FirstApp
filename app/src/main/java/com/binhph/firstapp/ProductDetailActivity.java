package com.binhph.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        TextView tvProductId = findViewById(R.id.tvProductDetailId);
        TextView tvProductName = findViewById(R.id.tvProductDetailName);
        Intent intent = getIntent();
        if (intent != null) {
            tvProductId.setText(intent.getStringExtra(IntentKeys.PRODUCT_ID));
            tvProductName.setText(intent.getStringExtra(IntentKeys.PRODUCT_NAME));
        }
        registerForContextMenu(tvProductName);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.context_edit){
            ShowEdit();
            return true;
        }

        return super.onContextItemSelected(item);
    }

    private void ShowEdit() {
    }
}