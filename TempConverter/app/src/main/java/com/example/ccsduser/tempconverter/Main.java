package com.example.ccsduser.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Main extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText temp = (EditText)findViewById(R.id.etTemp);
        final RadioButton rbFtoC = (RadioButton)findViewById(R.id.rbFtoC);
        final RadioButton rbCtoF = (RadioButton)findViewById(R.id.rbCtoF);
        final TextView finalTemp = (TextView)findViewById(R.id.tvTemp);
        final Button convert = (Button)findViewById(R.id.bConvert);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double currentTemp;
                double convertedTemp;
                String Message = "";
                if(temp.getText().toString() != "") {
                    currentTemp = Double.parseDouble(temp.getText().toString());
                    if (rbFtoC.isSelected()) {
                        convertedTemp = FtoC(currentTemp);
                        Message = convertedTemp + "° C";
                    }

                    if(rbCtoF.isSelected())
                    {
                        convertedTemp = CtoF(currentTemp);
                        Message = convertedTemp + "° F";
                    }
                }


                finalTemp.setText(Message);
            }
        });
    }

    protected double FtoC(double temp)
    {
        return (temp - 32) * 5 / 9;
    }

    protected double CtoF(double temp)
    {
        return (temp*9/5) + 32;
    }
}
