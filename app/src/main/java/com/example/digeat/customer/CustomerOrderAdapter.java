package com.example.digeat.customer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digeat.R;
import com.example.digeat.model.Transactions;

import java.util.Vector;

public class CustomerOrderAdapter extends RecyclerView.Adapter<CustomerOrderAdapter.CustomerOrderViewHolder>{

    Context context;
    private Vector<Transactions> transactionLists;

    public CustomerOrderAdapter(Context context) {
        this.context = context;
    }

    public void setTransactions(Vector<Transactions> transactionLists) {
        this.transactionLists = transactionLists;
    }

    @NonNull
    @Override
    public CustomerOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_customer_order, parent, false);
        return new CustomerOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerOrderAdapter.CustomerOrderViewHolder holder, int position) {
        holder.txtDate.setText(transactionLists.get(position).getTransactionDate());
        holder.totalPrice.setText("Rp. " + transactionLists.get(position).getTotalPrice());
    }

    @Override
    public int getItemCount() {
        return transactionLists.size();
    }

    class CustomerOrderViewHolder extends RecyclerView.ViewHolder{
        TextView txtDate, totalPrice;

        public CustomerOrderViewHolder(View view) {
            super(view);

            txtDate = view.findViewById(R.id.txtDate);
            totalPrice = view.findViewById(R.id.totalPrice);
        }
    }
}
