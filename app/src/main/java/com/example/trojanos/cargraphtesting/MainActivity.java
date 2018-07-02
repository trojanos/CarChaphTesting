package com.example.trojanos.cargraphtesting;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.github.mikephil.charting.charts.CombinedChart;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;


import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    private CombinedChart mChart;
    private final int itemcount = 10;

    /*
    audi rs4 2018 250km/h
    51 250 1650

    Volvo S80  1670fg
    62 000
    240 km

    Audi A3 260
    34 000 1590

     Mercedes-AMG G 63 AT
     220km
     170 000$
     2550 kg

     chervolet camaro 2018
     45.905$
     280km
     1671 kg

     Lamborghini Huracán
     225.000$
     320 km
     1,389 kg

     Porsche 911
     295 km
     1,430 kg
     104.000$

     BMW i8
     $149,900
    1,535 kg
    250km

    Aston Martin DB11
    233,650$
    1,760 kg
    300 km/h


    Ferrari f40
    1,352 kg
    367 km
    $400.000

     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mChart = findViewById(R.id.carGraph);
        mChart.getDescription().setEnabled(false);
        mChart.setBackgroundColor(Color.WHITE);
        mChart.setDrawGridBackground(false);
        mChart.setDrawBarShadow(false);
        mChart.setHighlightFullBarEnabled(false);

        // draw bars behind lines
        mChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.BUBBLE, CombinedChart.DrawOrder.CANDLE, CombinedChart.DrawOrder.LINE, CombinedChart.DrawOrder.SCATTER
        });

        Legend l = mChart.getLegend();
        l.setWordWrapEnabled(true);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);

         CombinedData data = new CombinedData();

       data.setData(generateLineData());
        data.setData(generateBarData());
      //  xAxis.setAxisMaximum(data.getXMax() + 0.25f);
        mChart.setData(data);
        mChart.invalidate();
        mChart.setTouchEnabled(true);
        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                mChart.getXAxis().getValueFormatter().getFormattedValue(e.getX(), mChart.getXAxis());
                       }

            @Override
            public void onNothingSelected() {

            }
        });
    }




    private LineData generateLineData() {

        LineData d = new LineData();

        ArrayList<Entry> entries = new ArrayList<>();


        entries.add((new Entry(51250,250)));
        entries.add((new Entry(62000,240)));
        entries.add((new Entry(34000,260)));
        entries.add((new Entry(170000,220)));
        entries.add((new Entry(45905,280)));
        entries.add((new Entry(225000,320)));
        entries.add((new Entry(104000,295)));
        entries.add((new Entry(149900,250)));
        entries.add((new Entry(233650,300)));
        entries.add((new Entry(400000,367)));



        LineDataSet set = new LineDataSet(entries, "Line DataSet");
        set.setColor(Color.rgb(240, 238, 70));
        set.setLineWidth(2.5f);
        set.setCircleColor(Color.rgb(240, 238, 70));
        set.setCircleRadius(5f);
        set.setFillColor(Color.rgb(240, 238, 70));
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.rgb(240, 238, 70));

        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(set);
        return d;
    }

    private BarData generateBarData() {

        ArrayList<BarEntry> entries1 = new ArrayList<BarEntry>();

        ArrayList<BarEntry> entries2 = new ArrayList<BarEntry>();

        entries1.add((new BarEntry(51250,1650)));
        entries1.add((new BarEntry(62000,1670)));
        entries1.add((new BarEntry(34000,1590)));
        entries1.add((new BarEntry(170000,2550)));
        entries1.add((new BarEntry(45905,1671)));
        entries1.add((new BarEntry(225000,1389)));
        entries1.add((new BarEntry(104000,1430)));
        entries1.add((new BarEntry(149900,1535)));
        entries1.add((new BarEntry(233650,1760)));
        entries1.add((new BarEntry(400000,1352)));

        entries2.add((new BarEntry(51250,1650)));
        entries2.add((new BarEntry(62000,1670)));
        entries2.add((new BarEntry(34000,1590)));
        entries2.add((new BarEntry(170000,2550)));
        entries2.add((new BarEntry(45905,1671)));
        entries2.add((new BarEntry(225000,1389)));
        entries2.add((new BarEntry(104000,1430)));
        entries2.add((new BarEntry(149900,1535)));
        entries2.add((new BarEntry(233650,1760)));
        entries2.add((new BarEntry(400000,1352)));

        BarDataSet set1 = new BarDataSet(entries1, "Bar 1");
        set1.setColor(Color.rgb(60, 220, 78));
        set1.setValueTextColor(Color.rgb(60, 220, 78));
        set1.setValueTextSize(10f);
        set1.setAxisDependency(YAxis.AxisDependency.RIGHT);

        BarDataSet set2 = new BarDataSet(entries2, "");
        set2.setStackLabels(new String[]{"Stack 1", "Stack 2"});
        set2.setColors(new int[]{Color.rgb(61, 165, 255), Color.rgb(23, 197, 255)});
        set2.setValueTextColor(Color.rgb(61, 165, 255));
        set2.setValueTextSize(10f);
        set2.setAxisDependency(YAxis.AxisDependency.RIGHT);

        float groupSpace = 0.06f;
        float barSpace = 0.02f; // x2 dataset
        float barWidth = 0.45f; // x2 dataset
        // (0.45 + 0.02) * 2 + 0.06 = 1.00 -> interval per "group"

        BarData d = new BarData(set1, set2);

        return d;
    }
}