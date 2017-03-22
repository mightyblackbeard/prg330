package com.example.ccsduser.healtyrecipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Recipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Button b = (Button)findViewById(R.id.bBack);

        b.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                startActivity(new Intent(Recipe.this, main.class));
            }
        });
    }
}
