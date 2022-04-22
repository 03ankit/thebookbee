package com.example.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Category extends AppCompatActivity {

    LinearLayout Comic,Theriller,Novel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Comic =findViewById(R.id.comic);
        Theriller =findViewById(R.id.theriller);
        Novel =findViewById(R.id.novel);

        Comic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent C=new Intent(Category.this,comic.class);
                startActivity(C);
            }
        });
       Theriller.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent T=new Intent(Category.this, thrillerr.class);
               startActivity(T);
           }
       });
       Novel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent N=new Intent(Category.this, scifi.class);
               startActivity(N);
           }
       });
    }
}