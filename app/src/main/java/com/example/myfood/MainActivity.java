package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recCateg,recPop;
public TextView see,txt,txt3,txt4,txt5;
private SearchView searchView;
InscActivity inscActivity;
ConstraintLayout bntm;
    private ArrayList<FoodD> foodDS;
private FirebaseDatabase database;
private DatabaseReference userR;
private static final String USER="Clients";
Client c;
ConstraintLayout cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        see = findViewById(R.id.see);
        recPop = findViewById(R.id.view2);
        txt = findViewById(R.id.txt);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
       bntm = findViewById(R.id.btnm);

bntm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this,PageActivity.class));
    }
});

        //----------
        String prenom = getIntent().getStringExtra("prenom");
        txt.setText(prenom);
        String nom = getIntent().getStringExtra("nom");
        txt3.setText(nom);
        String emaill = getIntent().getStringExtra("email");
        txt4.setText(emaill);
        String telee = getIntent().getStringExtra("tele");
        txt5.setText(telee);
        //------------
        //atabase=FirebaseDatabase.getInstance();
       // userR=database.getReference(USER);
        recCategory();
        recPopolur();
        buttonNavigation();
        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PageActivity.class));
            }
        });

    }



    private void buttonNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout profileBtn=findViewById(R.id.profileBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        LinearLayout supBtn=findViewById(R.id.supBtn);
        LinearLayout setBtn=findViewById(R.id.setBtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                intent.putExtra("prenom",txt.getText().toString());
                intent.putExtra("nom",txt3.getText().toString());
                intent.putExtra("email",txt4.getText().toString());
                intent.putExtra("tele",txt5.getText().toString());
                startActivity(intent);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CartActivity.class);
                intent.putExtra("prenom",txt.getText().toString());
                intent.putExtra("nom",txt3.getText().toString());
                intent.putExtra("email",txt4.getText().toString());
                intent.putExtra("tele",txt5.getText().toString());
                startActivity(intent);
            }
        });
        supBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PageActivity.class);
                intent.putExtra("prenom",txt.getText().toString());
                intent.putExtra("nom",txt3.getText().toString());
                intent.putExtra("email",txt4.getText().toString());
                intent.putExtra("tele",txt5.getText().toString());
                startActivity(intent);
            }
        });
        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ParaActivity.class);
                intent.putExtra("prenom",txt.getText().toString());
                intent.putExtra("nom",txt3.getText().toString());
                intent.putExtra("email",txt4.getText().toString());
                intent.putExtra("tele",txt5.getText().toString());
                startActivity(intent);
            }
        });
    }


    private void recPopolur() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recPop=findViewById(R.id.view2);
        recPop.setLayoutManager(linearLayoutManager);
        ArrayList<FoodD> foodDS=new ArrayList<>();
        foodDS.add(new FoodD("Laundry service","laundry","Burger avec double filet de poulet ananas roquette tomates,cheese et sauce sur fond blanc",9.0,4,25));
        foodDS.add(new FoodD("Sterilization home service","nettoyage","Burger avec flit de Kefta ananas roquette tomates ,cheese et sauce sur fond blanc",4.5,4,25));
        foodDS.add(new FoodD("Plumbing service ","plumbing","Ahmed omar \n Provides a range of services to install, maintain, and repair plumbing systems in residential and commercial buildings",4.5,4,25));
        foodDS.add(new FoodD("Electricity service","electricity"," Imad \n Allow customers to purchase renewable energy, such as solar or wind power, to meet their electricity needs",4.5,5,20));
        foodDS.add(new FoodD("Reparing service","reparing","Tomate, mozzarella, gruyère râpé, champignon, tomates fraîches, oignons confits épices, olives. \n\n Petite 5 / Moyenne 9 / Large 12",4.5,5,20));
        foodDS.add(new FoodD("Hairdressing service","hairdress","Recette Poulet aux olives et citrons confits",9.0,4,25));
        foodDS.add(new FoodD("Reparing service","reparing","Tomate, mozzarella, gruyère râpé, champignon, tomates fraîches, oignons confits épices, olives. \n\n Petite 5 / Moyenne 9 / Large 12",4.5,5,20));
        foodDS.add(new FoodD("Laundry service","laundry","Burger avec double filet de poulet ananas roquette tomates,cheese et sauce sur fond blanc",9.0,4,25));
        foodDS.add(new FoodD("Manicure and pedicure service","manicure","poulet avec riz , carottes coupées , poivrons vert,et oignons rouges",4.5,4,25));
        foodDS.add(new FoodD("Pets walking service","walking","Toutes les légumes,et Kefta",2.0,4,25));
        foodDS.add(new FoodD("Pets training service","training","Toutes les légumes,et thon",1.7,4,25));
        adapter2=new PopAdapter(foodDS);
        recPop.setAdapter(adapter2);
    }

    private void recCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recCateg=findViewById(R.id.view1);
        recCateg.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryD> categoryD=new ArrayList<>();
        categoryD.add(new CategoryD("House hold","cat1"));
        categoryD.add(new CategoryD("Cleaning","cat2"));
        categoryD.add(new CategoryD("Beauty","cat3"));
        categoryD.add(new CategoryD("Pets","cat4"));

        adapter=new CateAdapter(categoryD);
        recCateg.setAdapter(adapter);
    }


}