package com.example.fuzzyart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class ResActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle arguments = getIntent().getExtras();

        TextView res = findViewById(R.id.resValue);
        double value = (double) arguments.get("result");
        double scale = Math.pow(10, 3);
        double result = Math.ceil(value * scale) / scale;
        res.setText(String.valueOf(result));

        TextView textRes = findViewById(R.id.resText);
        Double doRes = Double.parseDouble(arguments.get("result").toString());
        if (doRes < 0.75)
            textRes.setText("Артроза нет");
        else if (doRes < 1.75)
            textRes.setText("Артроз возможен в будущем");
        else if (doRes < 2.75)
            textRes.setText("Артроз возмонжо появится в будущем \n или уже есть");
        else if (doRes < 3.75)
            textRes.setText("Серьезные подозрения на артроз");
        else
            textRes.setText("Артроз");

        ArrayList b = (ArrayList) arguments.get("points");
        GraphView graph = (GraphView) findViewById(R.id.resGraph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        series.appendData(new DataPoint(1,Math.ceil((double)b.get(0) * Math.pow(10,2)) / Math.pow(10,2)),true,500);
        series.appendData(new DataPoint(2,Math.ceil((double)b.get(1) * Math.pow(10,2)) / Math.pow(10,2)),true,500);
        series.appendData(new DataPoint(3,Math.ceil((double)b.get(2) * Math.pow(10,2)) / Math.pow(10,2)),true,500);
        series.appendData(new DataPoint(4,Math.ceil((double)b.get(3) * Math.pow(10,2)) / Math.pow(10,2)),true,500);
        series.appendData(new DataPoint(5,Math.ceil((double)b.get(4) * Math.pow(10,2)) / Math.pow(10,2)),true,500);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[] {"ИМТ", "Физ. нагрузки", "Возраст", "Вредные привычки", "Шаги"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.addSeries(series);
    }

    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(ResActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        catch (Exception e){
        }
    }
}