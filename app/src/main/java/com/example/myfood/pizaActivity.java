package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class pizaActivity extends AppCompatActivity {
    private PizaAdapter adapter2;
    private RecyclerView recPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piza);
        recPopolur();


    }
    private void recPopolur() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recPop=findViewById(R.id.recpiza);
        recPop.setLayoutManager(linearLayoutManager);
        ArrayList<FoodD> foodDS=new ArrayList<>();
        foodDS.add(new FoodD("Plumbing service ","userpng","Ahmed omar \n Provides a range of services to install, maintain, and repair plumbing systems in residential and commercial buildings",4.5,4,25));
        foodDS.add(new FoodD("Electricity service","userpng"," Imad \n Allow customers to purchase renewable energy, such as solar or wind power, to meet their electricity needs",4.5,5,20));
        foodDS.add(new FoodD("Reparing service","userpng","Tomate, mozzarella, gruyère râpé, champignon, tomates fraîches, oignons confits épices, olives. \n\n Petite 5 / Moyenne 9 / Large 12",4.5,5,20));
        foodDS.add(new FoodD("Technology service","userpng","Il y a (presque) tout : poivrons rouges rôtis, bébés épinards, oignons, champignons, tomates et olives noires. Il est également garni de trois sortes de fromages - feta, provolone et mozzarella - et saupoudré d'assaisonnement à l'ail et aux herbes. \n\n Petite 5 / Moyenne 9 / Large 12",45.0,4,23));
        foodDS.add(new FoodD("Painting service","userpng","Tomate, mozzarella, gruyère râpé, boeuf, tomates fraîches, oignons confits épices, olives. \n\n Petite 5 / Moyenne 9 / Large 12",4.5,5,20));

        adapter2=new PizaAdapter(foodDS);
        recPop.setAdapter(adapter2);

    }

}