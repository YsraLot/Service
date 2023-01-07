package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class BurgerActivity extends AppCompatActivity {
    private PizaAdapter adapter2;
    private RecyclerView recPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burg);
        recPopolur();
    }
    private void recPopolur() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recPop=findViewById(R.id.burg);
        recPop.setLayoutManager(linearLayoutManager);
        ArrayList<FoodD> foodDS=new ArrayList<>();
        foodDS.add(new FoodD("Cleaning home service","homeclean","Burger avec filet de poulet ananas roquette tomates,cheese  et sauce sur fond blanc",4.5,4,25));
        foodDS.add(new FoodD("Laundry service","laundry","Burger avec double filet de poulet ananas roquette tomates,cheese et sauce sur fond blanc",9.0,4,25));
        foodDS.add(new FoodD("Sterilization home service","nettoyage","Burger avec flit de Kefta ananas roquette tomates ,cheese et sauce sur fond blanc",4.5,4,25));
        foodDS.add(new FoodD("Dishes cleaning service","dishes","Burger avec double flit de Kefta ananas roquette tomates ,cheese et sauce sur fond blanc",9.0,4,25));

        adapter2=new PizaAdapter(foodDS);
        recPop.setAdapter(adapter2);

    }
}