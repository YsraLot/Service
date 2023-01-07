package com.example.myfood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SandwActivity extends AppCompatActivity {
    private PizaAdapter adapter2;
    private RecyclerView recPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sand);
        recPopolur();
    }
    private void recPopolur() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recPop=findViewById(R.id.san);
        recPop.setLayoutManager(linearLayoutManager);
        ArrayList<FoodD> foodDS=new ArrayList<>();
        foodDS.add(new FoodD("Pets walking service","walking","Toutes les légumes,et Kefta",2.0,4,25));
        foodDS.add(new FoodD("Pets training service","training","Toutes les légumes,et thon",1.7,4,25));
        foodDS.add(new FoodD("Pets caring","caring","Toutes les légumes,et poisson",2.0,4,25));
        foodDS.add(new FoodD("Pets adoption","adop","Toutes les légumes,et mortadelle",1.6,4,25));

        adapter2=new PizaAdapter(foodDS);
        recPop.setAdapter(adapter2);

    }
}