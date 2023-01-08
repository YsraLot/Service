package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChoixActivity extends AppCompatActivity {
    ConstraintLayout  ProviderRole, CustomerRole;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);

        ProviderRole=findViewById(R.id.rProvider);
        CustomerRole=findViewById(R.id.rCustomer);

        ProviderRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChoixActivity.this,SignUpProvider.class);
                startActivity(intent);
            }
        });

        CustomerRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ChoixActivity.this,SignUpCustomer.class);
                startActivity(intent);

            }
        });

    }
}