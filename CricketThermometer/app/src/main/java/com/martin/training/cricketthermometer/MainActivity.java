package com.martin.training.cricketthermometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //initializing all of the ui elements
    EditText chirps;
    Button calc;
    TextView explanation;
    TextView ans;

    //format to make the text look cleaner
    protected DecimalFormat f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //defining all ui elements
        chirps = findViewById(R.id.Chirps);
        calc = findViewById(R.id.btnCalc);
        explanation = findViewById(R.id.TVExplination);
        explanation.setText(R.string.Explanation);
        ans = findViewById(R.id.TVanswer);
        ans.setVisibility(View.GONE);

        f = new DecimalFormat("#0.00");

        //calculates based on chirp formula and gives results
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //chirp formula
                double finaltemp = (Double.parseDouble(chirps.getText().toString().trim()) / 3) + 4;

                String text = getString(R.string.AnswerStart) + " " + f.format(finaltemp);

                ans.setText(text);
                ans.setVisibility(View.VISIBLE);
            }
        });
    }
}