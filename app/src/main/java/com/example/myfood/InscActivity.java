package com.example.myfood;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InscActivity extends AppCompatActivity {
public EditText p,n,e,t;
public String prenom;
public ConstraintLayout ins;

    public FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference myRef,mn;

    // In InscActivity.java add
    public TextView gotoProviderDash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insc);
        p=findViewById(R.id.p);// First name
        n=findViewById(R.id.n);// last name
        e=findViewById(R.id.e);// email
        t=findViewById(R.id.t);// phone

        ins=findViewById(R.id.ins);// layout inscription
        mAuth=FirebaseAuth.getInstance();


// provider dashboard
        gotoProviderDash=findViewById(R.id.providerDash);
        gotoProviderDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InscActivity.this,ProviderDash.class);
                startActivity(intent);
            }
        });


//button pour l sig up
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                myRef=database.getReference("Clients");
                //Get all vallues

                String email= e.getText().toString().trim();
                if(email.isEmpty()) {
                    e.setError("Please enter your email");
                    return;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    e.setError("Please enter a valid email address");
                    return ;
                }

                String nom=n.getText().toString().trim();
                if(nom.isEmpty()) {
                    n.setError("please enter your name");
                    return;
                }else if (nom.length() > 15) {
                    n.setError("Last name too long");
                    return ;
                }else if (nom.length() <3) {
                    n.setError("Username too small");
                    return ;
                }

                prenom=p.getText().toString().trim();
                if(prenom.isEmpty()) {
                    p.setError("please enter your name");
                    return;
                }else if (prenom.length() > 15) {
                    p.setError("Fisrt name too long");
                    return ;
                }else if (prenom.length() <3) {
                    p.setError("Username too small");
                    return ;
                }

                String numero=t.getText().toString().trim();
                if(numero.isEmpty()) {
                    t.setError("please enter your numero");
                    return;
                }else if(numero.length()<10) {
                    t.setError("number not correct");
                    return;
                }
                else if(numero.length()>=11) {
                    t.setError("number not correct");
                    return;
                }


                // upload data to firebase
                Client cl=new Client(prenom, nom, email,numero);
                myRef.child(numero).setValue(cl);
                Toast.makeText(InscActivity.this, "Bien Enregistre", Toast.LENGTH_SHORT).show();


                //Intent intent=new Intent(InscActivity.this,MainActivity.class);
                //startActivity(intent);
//add info to profile interface


//----------------- zidi had  code f InscActivity.java f line 103
                // w mashi  Intent intent=new Intent(InscActivity.this,MainActivity.class);
                //          startActivity(intent);
                // hado kano deja
                Intent intent=new Intent(InscActivity.this,MainActivity.class);
                intent.putExtra("prenom",p.getText().toString());
                intent.putExtra("nom",n.getText().toString());
                intent.putExtra("email",e.getText().toString());
                intent.putExtra("tele",t.getText().toString());
                startActivity(intent);
                //----------------
            }
        });

    }
    }

