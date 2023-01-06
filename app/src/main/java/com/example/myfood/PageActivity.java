package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PageActivity extends AppCompatActivity {
ConstraintLayout c,c1,c3,c4;
    TextView pr, nom, email, tele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        c=findViewById(R.id.c);
        c1=findViewById(R.id.c1);

        c3=findViewById(R.id.c3);
        c4=findViewById(R.id.c4);


        buttonNavigation();
        pr = findViewById(R.id.prenom);
        nom = findViewById(R.id.nom);
        email = findViewById(R.id.email);
        tele = findViewById(R.id.tele);
        String prenom = getIntent().getStringExtra("prenom");
        pr.setText(prenom);
        String nomm = getIntent().getStringExtra("nom");
        nom.setText(nomm);
        String emaill = getIntent().getStringExtra("email");
        email.setText(emaill);
        String telee = getIntent().getStringExtra("tele");
        tele.setText(telee);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PageActivity.this,pizaActivity.class);

                startActivity(intent);
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PageActivity.this,BurgerActivity.class);
                startActivity(intent);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PageActivity.this,SandwActivity.class);

                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PageActivity.this,JajActivity.class);

                startActivity(intent);
            }
        });

    }
    private void buttonNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout supBtn = findViewById(R.id.supBtn);
        LinearLayout setBtn = findViewById(R.id.setBtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageActivity.this, ProfileActivity.class);
                intent.putExtra("prenom", pr.getText().toString());
                intent.putExtra("nom", nom.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("tele", tele.getText().toString());
                startActivity(intent);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageActivity.this, MainActivity.class);
                intent.putExtra("prenom", pr.getText().toString());
                intent.putExtra("nom", nom.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("tele", tele.getText().toString());
                startActivity(intent);
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageActivity.this, CartActivity.class);
                intent.putExtra("prenom", pr.getText().toString());
                intent.putExtra("nom", nom.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("tele", tele.getText().toString());
                startActivity(intent);
            }
        });
        supBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageActivity.this, PageActivity.class);
                intent.putExtra("prenom", pr.getText().toString());
                intent.putExtra("nom", nom.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("tele", tele.getText().toString());
                startActivity(intent);
            }
        });
        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageActivity.this, ParaActivity.class);
                intent.putExtra("prenom", pr.getText().toString());
                intent.putExtra("nom", nom.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("tele", tele.getText().toString());
                startActivity(intent);
            }
        });
    }
}