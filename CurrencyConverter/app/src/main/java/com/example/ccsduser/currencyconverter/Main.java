package com.example.ccsduser.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    // euro = .93 peso = 19.03 canada = 1.33

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText us = (EditText)findViewById(R.id.tbUSCurrency);
        RadioButton rbEuro = (RadioButton)findViewById(R.id.rbEuro);
        RadioButton rbPeso = (RadioButton)findViewById(R.id.rbPeso);
        RadioButton rbCanada = (RadioButton)findViewById(R.id.rbCanada);
        TextView NewDenom = (TextView)findViewById(R.id.tvNewAmount);
        Button bConvert = (Button)findViewById(R.id.bConvert);

        bConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double current = 0.00;
                String usCurrency = us.getText().toString();

                if(usCurrency != "") {
                    current = Double.parseDouble(usCurrency);
                }
            }
        });

    }
}
