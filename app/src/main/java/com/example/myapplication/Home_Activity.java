package com.example.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.myapplication.Adapters.MainAdapters;
import com.example.myapplication.Models.MainModel;
import com.example.myapplication.databinding.ActivityHomeBinding;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity {

    ActivityHomeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("MENU ");
        binding= ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel>list=new ArrayList<>();

        list.add(new MainModel(R.drawable.burgger,"Crispy Veg Burger","80","Crunchy American Corn patty, topped with Jalapenos."));
        list.add(new MainModel(R.drawable.item_pizza,"Vegetariana Pizza[10 inches]","250","family size buttery veg pizza."));
        list.add(new MainModel(R.drawable.item_burger2,"Hot 'N' Cheezy Burger","100","Cheese Lovers Delight! Juicy Veg Patty, Veggies."));
        list.add(new MainModel(R.drawable.item_sandwitch,"Paneer Sandwitch","75","coated with double layer paneer ,delicious sandwitch."));
        list.add(new MainModel(R.drawable.item_pastry2,"Chocolate Cup Cake  ","110","super tasty ,mouth watery chocolate cup cake."));
        list.add(new MainModel(R.drawable.item_pastry,"Chocolate Mousee Pastry","175","coated with dark layered chocolate."));
        list.add(new MainModel(R.drawable.item_cake,"Cake","350","spongy,chocolaty and ultra sweet."));
        list.add(new MainModel(R.drawable.item_oreoshake,"Oreo Shake","250","milky shake with crisp of oreo plus vanilla ice cream.."));
        list.add(new MainModel(R.drawable.item_coffe,"Coffee","100","strong aroma ,light-sweet coffee."));

        MainAdapters adapters=new MainAdapters(list,this);
        binding.recyleview.setAdapter(adapters);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyleview.setLayoutManager(layoutManager);
    }
}