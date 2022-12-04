package com.example.fuzzyart;

import static com.example.fuzzyart.Rules.genRules;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView IMT;
    TextView H;
    TextView ST;
    int Ph;
    int BH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ST = findViewById(R.id.steps);
        H = findViewById(R.id.age);
        IMT = findViewById(R.id.imt);
    }

    public void getRes(View view){
        try {
            ArrayList<Rules> rules = genRules();
            ArrayList<Double> fuzziArray = Fuzzifier.fuzzi(rules, Integer.valueOf(IMT.getText().toString()), Ph, Integer.valueOf(H.getText().toString()), BH, Integer.valueOf(ST.getText().toString()));
            ArrayList<Double> aggregateArray = Aggregator.aggregate(fuzziArray);
            double defRes = Defuzzifier.defuzzi(aggregateArray, rules);

            ArrayList<Double> badRes = new ArrayList<>();
            badRes.add(Variables.IMT_high(Integer.valueOf(IMT.getText().toString())));
            badRes.add(Variables.Ph_yes(Ph));
            badRes.add(Variables.H_old(Integer.valueOf(H.getText().toString())));
            badRes.add(Variables.BH_yes(BH));
            badRes.add(Variables.ST_high(Integer.valueOf(ST.getText().toString())));

            Intent intent = new Intent(this, ResActivity.class);
            intent.putExtra("result", defRes);
            intent.putExtra("points", badRes);
            startActivity(intent);
        }
        catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Проверьте введенные данные", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void phAnswerClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.yPh:
                if (checked){
                    Ph =1;
                }
                break;
            case R.id.nPh:
                if (checked){
                    Ph =0;
                }
                break;
        }
    }

    public void bhAnswerClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.yBadHabits:
                if (checked){
                    BH = 1;
                }
                break;
            case R.id.nBadHabits:
                if (checked){
                    BH = 0;
                }
                break;
        }
    }
}