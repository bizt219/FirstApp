package com.binhph.firstapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binhph.firstapp.IntentKeys;
import com.binhph.firstapp.ProductDetailActivity;
import com.binhph.firstapp.R;
import com.binhph.firstapp.bean.ProductInfo;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {
    private List<ProductInfo> productInfos;
    private Context context;

    public ProductListAdapter(Context context, List<ProductInfo> productInfoList) {
        this.context = context;
        this.productInfos = productInfoList;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false);
        return new ProductViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductInfo productInfo = productInfos.get(position);
        holder.tvProductID.setText(productInfo.getId());
        holder.tvProductName.setText((productInfo.getName()));
    }

    @Override
    public int getItemCount() {
        return productInfos.size();
    }

    protected class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ProductListAdapter adapter;
        private TextView tvProductID;
        private TextView tvProductName;

        public ProductViewHolder(@NonNull View itemView, ProductListAdapter adapter) {
            super(itemView);
            tvProductID = itemView.findViewById(R.id.tvProductID);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            this.adapter = adapter;
            tvProductID.setOnClickListener(this);
            tvProductName.setOnClickListener(this);
        }

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductID = itemView.findViewById(R.id.tvProductID);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductID.setOnClickListener(this);
            tvProductName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ProductDetailActivity.class);
            intent.putExtra(IntentKeys.PRODUCT_NAME, tvProductName.getText().toString());
            intent.putExtra(IntentKeys.PRODUCT_ID, tvProductID.getText().toString());
            context.startActivity(intent);
        }
    }
}
