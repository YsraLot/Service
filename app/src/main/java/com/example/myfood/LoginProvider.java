package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginProvider extends AppCompatActivity {

    private TextView client_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_provider);

        client_txt=(TextView) findViewById(R.id.p1);

        client_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginProvider.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}