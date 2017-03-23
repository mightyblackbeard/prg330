package com.example.ccsduser.currencyconverter;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    // euro = .93 peso = 19.03 canada = 1.33
    double exchangeEuro = 0.93;
    double exchangePeso = 19.03;
    double exchangeCanada = 1.33;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DecimalFormat money = new DecimalFormat("#,###,###.##");


        final EditText us = (EditText)findViewById(R.id.tbUSCurrency);
        final RadioButton rbEuro = (RadioButton)findViewById(R.id.rbEuro);
        final RadioButton rbPeso = (RadioButton)findViewById(R.id.rbPeso);
        final RadioButton rbCanada = (RadioButton)findViewById(R.id.rbCanada);
        final TextView NewDenom = (TextView)findViewById(R.id.tvNewAmount);
        Button bConvert = (Button)findViewById(R.id.bConvert);

        bConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double current;
                String usCurrency = us.getText().toString();
                double newMoney = 0;
                char MoneySymbol = '*';

                if(TextUtils.isEmpty(usCurrency)) {
                    current = 0.00;
                }
                else
                {
                    current = Double.parseDouble(usCurrency);
                }

                if(rbCanada.isChecked())
                {
                    newMoney = Converter(current, exchangeCanada);
                    MoneySymbol = '$';
                }

                if(rbEuro.isChecked())
                {
                    newMoney = Converter(current, exchangeEuro);
                    MoneySymbol = '€';
                }

                if(rbPeso.isChecked())
                {
                    newMoney = Converter(current, exchangePeso);
                    MoneySymbol = '$';
                }

                String message = MoneySymbol + money.format(newMoney).toString();
                NewDenom.setText(message);
            }
        });

    }

    private double Converter(double cur, double exchange)
    {
        return cur*exchange;
    }
}
