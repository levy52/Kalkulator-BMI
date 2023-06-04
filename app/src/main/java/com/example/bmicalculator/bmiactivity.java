package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bmiactivity extends AppCompatActivity {

    TextView mbmidisplay, mbmicategory, mgender;
    Button mgotomain;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;
    String height;
    String weight;
    float intheight, intweight;
    RelativeLayout mbackground;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        getSupportActionBar().setElevation(0);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#212171"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Wynik");

        intent = getIntent();
        mbmidisplay = findViewById(R.id.bmidisplay);
        mbmicategory = findViewById(R.id.bmicategorydispaly);
        mgotomain = findViewById(R.id.gotomain);
        mimageview = findViewById(R.id.imageview);
        mgender = findViewById(R.id.genderdisplay);
        mbackground = findViewById(R.id.contentlayout);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight / 100;
        intbmi = intweight / (intheight * intheight);

        mbmi = Float.toString(intbmi);

        if (intbmi < 16) {
            mbmicategory.setText("Wygłodzenie");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        } else if (intbmi < 16.9 && intbmi > 16) {
            mbmicategory.setText("Umiarkowane wygłodzenie");
            mbackground.setBackgroundColor(getResources().getColor(R.color.halfwarn));
            mimageview.setImageResource(R.drawable.warning);
        } else if (intbmi < 18.4 && intbmi > 17) {
            mbmicategory.setText("Lekkie wygłodzenie");
            mbackground.setBackgroundColor(getResources().getColor(R.color.halfwarn));
            mimageview.setImageResource(R.drawable.warning);
        } else if (intbmi < 24.9 && intbmi > 18.5) {
            mbmicategory.setText("Normalne");
            mimageview.setImageResource(R.drawable.ok);
        } else if (intbmi < 29.9 && intbmi > 25) {
            mbmicategory.setText("Nadwaga");
            mbackground.setBackgroundColor(getResources().getColor(R.color.halfwarn));
            mimageview.setImageResource(R.drawable.warning);
        } else if (intbmi < 34.9 && intbmi > 30) {
            mbmicategory.setText("Otyłość I stopnia");
            mbackground.setBackgroundColor(getResources().getColor(R.color.halfwarn));
            mimageview.setImageResource(R.drawable.warning);
        } else {
            mbmicategory.setText("Otyłość II stopnia");
            mbackground.setBackgroundColor(getResources().getColor(R.color.warn));
            mimageview.setImageResource(R.drawable.crosss);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);

        mgotomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
