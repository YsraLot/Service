package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProviderDash extends AppCompatActivity {

    private ImageView category1,category2,category3,category4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_dash);

        category1=findViewById(R.id.Image_category1);
        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProviderDash.this,ProviderAddService.class);// edit MainActivity.class to your add category
                intent.putExtra("services","service1");
                startActivity(intent);
            }
        });

        category2=findViewById(R.id.Image_category2);
        category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProviderDash.this,ProviderAddService.class);// edit MainActivity.class to your add category
                intent.putExtra("services","service2");
                startActivity(intent);
            }
        });


        category3=findViewById(R.id.Image_category3);
        category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProviderDash.this,ProviderAddService.class);// edit MainActivity.class to your add category
                intent.putExtra("services","service3");
                startActivity(intent);
            }
        });




        category4=findViewById(R.id.Image_category4);
        category4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProviderDash.this,ProviderAddService.class);// edit MainActivity.class to your add category
                intent.putExtra("services","service4");
                startActivity(intent);
            }
        });




    }
}