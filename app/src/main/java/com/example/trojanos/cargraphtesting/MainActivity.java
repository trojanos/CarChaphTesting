package com.example.trojanos.cargraphtesting;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import static com.example.trojanos.cargraphtesting.R.id.carGraph;

public class MainActivity extends AppCompatActivity {
         CombinedChart mCombinedChart;
        private final int  carItems = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mCombinedChart = findViewById(R.id.carGraph);
        mCombinedChart.getDescription().setText("test");
        mCombinedChart.setDrawBarShadow(false);
        mCombinedChart.setDrawValueAboveBar(true);
        mCombinedChart.setMaxVisibleValueCount(10);
        mCombinedChart.setBackgroundColor(Color.WHITE);
        mCombinedChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE, CombinedChart.DrawOrder.CANDLE, CombinedChart.DrawOrder.SCATTER
        });
        Legend legend = mCombinedChart.getLegend();
        legend.setWordWrapEnabled(true);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);

        mCombinedChart.setVisibleXRangeMaximum((float)10);

        XAxis x1 = mCombinedChart.getXAxis();
        x1.setDrawGridLines(false);
        x1.setAxisMaxValue(1200);
        x1.setAvoidFirstLastClipping(true);

        YAxis y1 = mCombinedChart.getAxisLeft();
        y1.setAxisMaxValue(255);
        y1.setAxisMinValue(0);
        y1.setDrawGridLines(true);


        YAxis y12 = mCombinedChart.getAxisRight();
        y12.setEnabled(false);


        CombinedData data = new CombinedData();

        data.setData(1,20.2);
        data.setData(generateBarData());
        data.setData(generateBubbleData());
        data.setData(generateScatterData());
        data.setData(generateCandleData());
        data.setValueTypeface(mTfLight);

        xAxis.setAxisMaximum(data.getXMax() + 0.25f);

        mChart.setData(data);
        mChart.invalidate();

    }
}