package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityDetailBinding;
import com.example.myapplication.databinding.ActivitySuccessfulOrderBinding;

public class successful_Order extends AppCompatActivity {

    ActivitySuccessfulOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_order);
        getSupportActionBar().hide();


    }
}