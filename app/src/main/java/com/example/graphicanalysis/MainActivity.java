package com.example.graphicanalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class MainActivity extends AppCompatActivity {
    LineChartView consumptionTrend;
    List xAxisValueList;
    List<lecho.lib.hellocharts.model.PointValue> yAxisValueList;
    Line trendLine;
    LineChartData data;
    int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};
    String[] xAxisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};

    BarChart barChart;
    ArrayList<BarEntry> entries;
    BarDataSet bardataset;
    BarData barData;
    ArrayList<String> barGraphHorizontalLabels;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xAxisValueList = new ArrayList<>();
        yAxisValueList = new ArrayList<>();
        trendLine = new Line(yAxisValueList).setColor(Color.parseColor("#9C27B0"));
        consumptionTrend = findViewById(R.id.graph_view);
        consumptionTrend.setContentDescription("LINE GRAPH SHOWING ANNUAL RAINFALL DISTRIBUTION");
        consumptionTrend.getContentDescription();
        data = new LineChartData();
        addXAxisDataToXAxisValueList();
        addYAxisDataToYAxisValueList();
        addGraphLinesToChatData();
        setHorizontalValues();
        setVerticalValues();

        barChart = findViewById(R.id.bar_chart);
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        setBarGraphDescription();
        initializeBarGraph();
//        setBarGraphData();
        initializeBarGraphHorizontalLabels();


    }



//    private void setBarGraphData() {
//        barData = new BarData(initializeBarGraphHorizontalLabels(), initializeBarGraph());
//        barChart.setData(barData);
//
//    }

    private void addYAxisDataToYAxisValueList() {
        if (yAxisData.length > 0) {
            for (int i=0; i<yAxisData.length; i++) {
                yAxisValueList.add(new PointValue(i, yAxisData[i]));
            }

        }

    }

    private void addXAxisDataToXAxisValueList() {
//        if (xAxisData.length>0) {
//            for (int i=0; i<xAxisData.length; i++) {
//                xAxisValueList.add(1, new AxisValue(i).setLabel(xAxisData[i]));
//            }
//
//        }
    }

    private void addGraphLinesToChatData() {
        List<Line> lines = new ArrayList<>();
        lines.add(trendLine);
        data.setLines(lines);
        consumptionTrend.setLineChartData(data);
        Viewport viewport = new Viewport(consumptionTrend.getMaximumViewport());
        viewport.top =100;
        consumptionTrend.setMaximumViewport(viewport);
        consumptionTrend.setCurrentViewport(viewport);
    }

    private void setHorizontalValues() {
        Axis xAxis = new Axis();
//        axis.setValues(xAxisValueList);
        xAxis.setTextSize(16);
        xAxis.setTextColor(Color.parseColor("#03A9F4"));
        xAxis.setName("Months In Numbers");
        data.setAxisXBottom(xAxis);

    }

    private void setVerticalValues() {
        Axis yAxis = new Axis();
        yAxis.setTextSize(16);
        yAxis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextSize(16);
        yAxis.setName("Rainfall Distribution In mm");
        data.setAxisYLeft(yAxis);
    }

    private BarDataSet initializeBarGraph() {
        entries = new ArrayList<>();
        entries.add(new BarEntry(8f, 0));
        entries.add(new BarEntry(2f, 1));
        entries.add(new BarEntry(5f, 2));
        entries.add(new BarEntry(20f, 3));
        entries.add(new BarEntry(15f, 4));
        entries.add(new BarEntry(19f, 5));

        bardataset = new BarDataSet(entries, "Cells");

        return bardataset;
    }

    private ArrayList<String> initializeBarGraphHorizontalLabels() {

        barGraphHorizontalLabels = new ArrayList<>();
        barGraphHorizontalLabels.add("2016");
        barGraphHorizontalLabels.add("2015");
        barGraphHorizontalLabels.add("2014");
        barGraphHorizontalLabels.add("2013");
        barGraphHorizontalLabels.add("2012");
        barGraphHorizontalLabels.add("2011");

        return barGraphHorizontalLabels;
    }

    private void setBarGraphDescription() {
        Description description = new Description();
        description.setText("My First Bar Graph");
        barChart.setDescription(description);
    }
}
