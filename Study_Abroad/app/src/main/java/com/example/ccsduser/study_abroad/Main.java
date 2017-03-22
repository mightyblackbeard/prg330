package com.example.ccsduser.study_abroad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main extends AppCompatActivity {

    double tickPrice = 1288.00;
    int numTickets;
    double totalCost;
    String dest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText tickets = (EditText)findViewById(R.id.ticketTxt);
        final Spinner destination = (Spinner)findViewById(R.id.destinations);
        final TextView result = (TextView)findViewById(R.id.tbFinal);
        Button calc = (Button)findViewById(R.id.calculateTrip);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numTickets = Integer.parseInt(tickets.getText().toString());
                dest = destination.getSelectedItem().toString();

                result.setText(calcTotal(numTickets, dest));
            }
        });


    }
    public String calcTotal(int numTick, String dest)
    {
        totalCost = tickPrice * numTick;

        String message = "Flight Cost for " + dest + " is $" + totalCost;

        return message;
    }
}
