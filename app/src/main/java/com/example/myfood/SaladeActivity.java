package com.example.myfood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SaladeActivity extends AppCompatActivity {
    private PizaAdapter adapter2;
    private RecyclerView recPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salade);
        recPopolur();
    }
    private void recPopolur() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recPop=findViewById(R.id.salade);
        recPop.setLayoutManager(linearLayoutManager);
        ArrayList<FoodD> foodDS=new ArrayList<>();
        foodDS.add(new FoodD("Thon","sal1","Salade avec légumes et thon",2.0,4,25));




        adapter2=new PizaAdapter(foodDS);
        recPop.setAdapter(adapter2);

    }
}