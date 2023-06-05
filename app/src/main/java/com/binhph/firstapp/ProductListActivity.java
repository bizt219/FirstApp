package com.binhph.firstapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.binhph.firstapp.adapter.ProductListAdapter;
import com.binhph.firstapp.bean.ProductInfo;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {
    private List<ProductInfo> productInfos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        addProduct();
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProductListAdapter productListAdapter = new ProductListAdapter(this, productInfos);
        recyclerView.setAdapter(productListAdapter);
    }

    private void addProduct() {
        for (int i = 0; i < 20; i++) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.setId("ID: " + i);
            productInfo.setName("Product Name: " + i);
            productInfos.add(productInfo);
        }
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        if (menu instanceof MenuBuilder){
            ((MenuBuilder) menu).setOptionalIconsVisible(true);
        }
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        /*switch (menuItem.getItemId()) {
            case R.id.option_setting:
                showSetting();
                return true;
            case R.id.option_favorite:
                showFavorite();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }*/

        if (menuItem.getItemId() == R.id.option_setting){
            showSetting();
            return true;
        }
        else if (menuItem.getItemId() == R.id.option_favorite){
            showFavorite();
            return true;
        }

        return super.onOptionsItemSelected(menuItem);

    }

    private void showFavorite() {

    }

    private void showSetting() {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
}