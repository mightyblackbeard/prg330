package com.example.ccsduser.addressbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button viewJim = (Button)findViewById(R.id.viewJim);
        Button viewJerry = (Button)findViewById(R.id.viewJerry);


        viewJim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main.this, JimContact.class));
            }
        });

        viewJerry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(main.this, JerryContact.class));
            }
        });


    }
}
