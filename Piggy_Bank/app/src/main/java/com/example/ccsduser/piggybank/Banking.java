package com.example.ccsduser.piggybank;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Banking extends AppCompatActivity {

    double qValue = 0.25;
    double dValue = 0.10;
    double nValue = 0.05;
    double pValue = 0.01;

    double Total = 0.00;

    int numQ, numN, numD, numP;

    DecimalFormat currency = new DecimalFormat("$###,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking);


        String message;

        final EditText quarters = (EditText)findViewById(R.id.etQuarters);
        final EditText dimes = (EditText)findViewById(R.id.etDimes);
        final EditText nickels = (EditText)findViewById(R.id.etNickels);
        final EditText pennies = (EditText)findViewById(R.id.etPennies);
        final Spinner toDo = (Spinner)findViewById(R.id.spinDoing);
        final TextView total = (TextView)findViewById(R.id.tvCalc);

        Button calc = (Button)findViewById(R.id.bCalc);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String qs = quarters.getText().toString();
                final String ds = dimes.getText().toString();
                final String ns = nickels.getText().toString();
                final String ps = pennies.getText().toString();

                if(TextUtils.isEmpty(qs)) {
                    numQ = 0;
                }
                else {
                    numQ = Integer.parseInt(quarters.getText().toString());
                }

                if (TextUtils.isEmpty(ds)){
                    numD = 0;
                }
                else{
                    numD = Integer.parseInt(dimes.getText().toString());
                }

                if (TextUtils.isEmpty(ns)){
                    numN = 0;
                }
                else{
                    numN = Integer.parseInt(nickels.getText().toString());
                }

                if (TextUtils.isEmpty(ps)){
                    numP = 0;
                }
                else{
                    numP = Integer.parseInt(pennies.getText().toString());
                }

                if(toDo.getSelectedItemPosition() == 0) {
                    CalculateTotal(true);
                }
                else {
                    CalculateTotal(false);
                }

                String message = currency.format(Total);
                total.setText(message);

                quarters.setText("");
                dimes.setText("");
                nickels.setText("");
                pennies.setText("");


                numQ = 0;
                numD = 0;
                numN = 0;
                numP = 0;

            }
        });
    }

    private void CalculateTotal(boolean todo)
    {

        if(todo)
        {
            Total += (numQ*qValue) + (numD*dValue) + (numN*nValue) + (numP*pValue);
        }
        else
        {
            Total += -1*((numQ*qValue) + (numD*dValue) + (numN*nValue) + (numP*pValue));
        }

    }
}
