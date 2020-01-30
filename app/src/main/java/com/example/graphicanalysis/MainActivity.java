package com.example.graphicanalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class MainActivity extends AppCompatActivity {
    LineChartView consumptionTrend;
    ArrayList<AxisValue> xAxisValueList;
    List<lecho.lib.hellocharts.model.PointValue> yAxisValueList;

    String[] axisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept",
            "Oct", "Nov", "Dec"};

    int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};
    Line trendLine;
    LineChartData data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        xAxisValueList = new ArrayList<>();
        yAxisValueList = new ArrayList<>();
        trendLine = new Line(yAxisValueList).setColor(Color.parseColor("#9C27B0"));
        consumptionTrend = findViewById(R.id.graph_view);
        data = new LineChartData();
//        addXAxisDataToXAxisValueList();
        addYAxisDataToYAxisValueList();
        addGraphLinesToChatData();
        setHorizontalValues();
        setVerticalValues();
    }

    private void addYAxisDataToYAxisValueList() {
        if (yAxisData.length > 0) {
            for (int i=0; i<yAxisData.length; i++) {
                yAxisValueList.add(new PointValue(i, yAxisData[i]));
            }

        }

    }

//    private void addXAxisDataToXAxisValueList() {
//        xAxisValueList = new ArrayList<>();
//
//
//        if (axisData.length >0) {
//            for (int i=0; i<axisData.length; i++) {
//                xAxisValueList.add(1, new AxisValue(i).setLabel(axisData[i]));
//            }
//
//        }
//
//
//    }

    private void addGraphLinesToChatData() {
        List<Line> lines = new ArrayList<>();
        lines.add(trendLine);
        data.setLines(lines);
        consumptionTrend.setLineChartData(data);
        Viewport viewport = new Viewport(consumptionTrend.getMaximumViewport());
        viewport.top =110;
        consumptionTrend.setMaximumViewport(viewport);
        consumptionTrend.setCurrentViewport(viewport);
    }

    private void setHorizontalValues() {
        Axis axis = new Axis();
        axis.setValues(xAxisValueList);
        axis.setTextSize(16);
        axis.setTextColor(Color.parseColor("#03A9F4"));
        data.setAxisXBottom(axis);
    }

    private void setVerticalValues() {
        Axis yAxis = new Axis();
        yAxis.setTextSize(16);
        yAxis.setTextColor(Color.parseColor("#03A9F4"));
        yAxis.setTextSize(16);
        yAxis.setName("consumption in units");
        data.setAxisYLeft(yAxis);
    }
}
