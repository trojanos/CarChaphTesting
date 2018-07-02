package com.example.trojanos.cargraphtesting;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
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
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnChartValueSelectedListener {
    private CombinedChart mChart;
    double[] kg = {1.650,1.670,1.590,2.550,1.671,1.389,1.430,1.535,1.760,1.352};
    String[] Names = {"Audi RS4","Volvo S80","Mercedes-AMG G 63 AT","Chevrolet Camaro 2018","Lamborghini Huracan","Porsche 911,","BMW I8","Aston Martin DB11","Ferrari F40"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                mChart = (CombinedChart) findViewById(R.id.chart1);
//        mChart.setBackgroundColor(Color.WHITE);
        mChart.setDrawGridBackground(true);
        mChart.setDrawBarShadow(true);
        mChart.isHardwareAccelerated();
        mChart.setHighlightFullBarEnabled(true);
        mChart.setTouchEnabled(true);
       mChart.isInTouchMode();
        // draw bars behind lines
        mChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE
        });

        mChart.setOnChartValueSelectedListener(this);

        Legend l = mChart.getLegend();
        l.setWordWrapEnabled(true);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        mChart.isFocusableInTouchMode();
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
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mMount[(int) value % mMount.length];
            }
        });

        CombinedData data = new CombinedData();

        data.setData(generateLineData());
        //data.setData(generateBarData());

        xAxis.setAxisMaximum(data.getXMax() + 0.25f);
        mChart.setData(data);
        mChart.invalidate();

        mChart.animateX(1333, Easing.EasingOption.EaseInCirc);
        mChart.animateY(1333, Easing.EasingOption.EaseInOutBack);
    }

    protected String[] mMount = new String[]{
            "1,000$", "2,000$", "10,000$", "50,000$", "100,000$", "150,000$","200,000$","250,000$","300,000$","400,000$","500,000$"
    };

    private LineData generateLineData() {

        LineData d = new LineData();

        ArrayList<Entry> entries = new ArrayList<Entry>();

        entries = getLineEntriesData(entries);

        LineDataSet set = new LineDataSet(entries, "Speed");
        //set.setColor(Color.rgb(240, 238, 70));
        set.setColors(ColorTemplate.COLORFUL_COLORS);
        set.setLineWidth(2.5f);
        set.setCircleColor(Color.rgb(240, 238, 70));
        set.setCircleRadius(5f);
        set.setFillColor(Color.rgb(240, 238, 70));
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setHighlightEnabled(true);
        set.setHighLightColor(Color.BLACK);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.rgb(240, 238, 70));

        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(set);

        return d;
    }

    private ArrayList<Entry> getLineEntriesData(ArrayList<Entry> entries) {
        entries.add(new Entry(1, 250));
        entries.add(new Entry(2, 240));
        entries.add(new Entry(3, 260));
        entries.add(new Entry(4, 220));
        entries.add(new Entry(5, 280));
        entries.add(new Entry(6, 320));
        entries.add(new Entry(7, 295));
        entries.add(new Entry(8, 250));
        entries.add(new Entry(9, 300));
        entries.add(new Entry(10, 367));

        return entries;
    }

    private BarData generateBarData() {


        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
        entries = getBarEnteries(entries);

        BarDataSet set1 = new BarDataSet(entries, "Bar");
        //set1.setColor(Color.rgb(60, 220, 78));
        set1.setColors(ColorTemplate.COLORFUL_COLORS);
        set1.setValueTextColor(Color.rgb(60, 220, 78));
        set1.setValueTextSize(10f);
        set1.setHighlightEnabled(true);
        set1.setAxisDependency(YAxis.AxisDependency.RIGHT);

        float barWidth = 0.45f; // x2 dataset


       BarData d = new BarData(set1);


        d.setBarWidth(barWidth);


        return d;
    }

    private ArrayList<BarEntry> getBarEnteries(ArrayList<BarEntry> entries) {
        entries.add(new BarEntry(1, 1650));
        entries.add(new BarEntry(2, 1678));
        entries.add(new BarEntry(3, 1590));
        entries.add(new BarEntry(4, 2550));
        entries.add(new BarEntry(5, 1671));
        entries.add(new BarEntry(6, 1389));
        entries.add(new BarEntry(7, 1430));
        entries.add(new BarEntry(8, 1535));
        entries.add(new BarEntry(9, 1760));
        entries.add(new BarEntry(10, 1352));
        return entries;
    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {
        System.out.println("vasa" +e.getX());
            }

    @Override
    public void onNothingSelected() {

    }
}

