package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;


public class Splash_Screen extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME=5000;
    public static SharedPreferences sharedPreferences; // to save info of user in this action to store data
    public static SharedPreferences.Editor editor;
    public static String user_id;

    Animation topAnim,bottomAnim;
    ImageView img1;
    TextView txt1,txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        img1=findViewById(R.id.imgV1);
        txt1=findViewById(R.id.txtV1);
        txt2=findViewById(R.id.txtV2);

        img1.setAnimation(topAnim);
        txt1.setAnimation(bottomAnim);
        txt2.setAnimation(bottomAnim);

        sharedPreferences =getSharedPreferences("SM Services", Context.MODE_PRIVATE);
        //get_shared_perferences();

        FirebaseApp.initializeApp(this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash_Screen.this, Step1.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN_TIME);

    }
}