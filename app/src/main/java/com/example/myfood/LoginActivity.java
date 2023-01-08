package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public TextView CreateAccount;
    public ConstraintLayout loginbtn;
    public String prenom, nom, email, tele;
    public EditText phone, inputPass1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbtn=(ConstraintLayout) findViewById(R.id.LoginBtn);
        phone=(EditText) findViewById(R.id.eLogin);
        inputPass1=(EditText) findViewById(R.id.inputPass);
        CreateAccount=(TextView) findViewById(R.id.CrtAccount);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Client cl=new Client(getIntent().getStringExtra("prenom"),getIntent().getStringExtra("nom"),getIntent().getStringExtra("email"),getIntent().getStringExtra("tele"));


//

                 Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra("prenom",cl.getPrenom());
                intent.putExtra("nom",cl.getNom());
                intent.putExtra("email",cl.getEmail());
                intent.putExtra("tele",cl.getNum());
                 startActivity(intent);

            }
        });

        CreateAccount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent =new Intent(LoginActivity.this,SignUpCustomer.class);
                        startActivity(intent);


                    }
                });

    }
}