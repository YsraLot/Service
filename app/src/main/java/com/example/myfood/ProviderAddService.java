package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ProviderAddService extends AppCompatActivity {
    private String CategoryName;
    private Button AddNewServiceButton;
    private ImageView InputServiceImage;
    private EditText InputServiceName,InputServiceDescription, InputServicePrice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_add_service);


        CategoryName=getIntent().getExtras().get("services").toString();

        AddNewServiceButton=(Button)findViewById(R.id.add_new_service);

        InputServiceImage=(ImageView) findViewById(R.id.select_service_image);

        InputServiceName=(EditText) findViewById(R.id.service_name);
        InputServiceDescription=(EditText) findViewById(R.id.service_description);
        InputServicePrice=(EditText) findViewById(R.id.service_price);



    }
}