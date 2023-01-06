package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.awt.font.TextAttribute;

public class SowDetailActivity extends AppCompatActivity {
private TextView addToCartBtn,titleTxt,feeTxt,descriptionTxt,numberOrderTxt,totalPrice;
private ImageView picFood;
private FoodD object;
private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sow_detail);
        managementCart=new ManagementCart(this);
        iniView();
        getBudle();
    }

    private void getBudle() {
        object=(FoodD) getIntent().getSerializableExtra("object");
        int drawableRessourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this).load(drawableRessourceId).into(picFood);
        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getFee());
        descriptionTxt.setText(object.getDesc());
        totalPrice.setText("$"+Math.round(object.getFee()));

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.insertFood(object);

            }
        });
    }

    private void iniView() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
        titleTxt=findViewById(R.id.titlep);
      descriptionTxt=findViewById(R.id.description);
      picFood=findViewById(R.id.foodpic);
      feeTxt=findViewById(R.id.pricetxt);
      totalPrice=findViewById(R.id.totalPrice);




    }
}