package com.example.practicekt.activity.chart

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.practicekt.databinding.ActivityMpChartAndroidBinding
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.BubbleData
import com.github.mikephil.charting.data.BubbleDataSet
import com.github.mikephil.charting.data.BubbleEntry
import com.github.mikephil.charting.data.CandleData
import com.github.mikephil.charting.data.CandleDataSet
import com.github.mikephil.charting.data.CandleEntry
import com.github.mikephil.charting.data.CombinedData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.data.ScatterData
import com.github.mikephil.charting.data.ScatterDataSet

class MpChartAndroid : AppCompatActivity() {

    private lateinit var binding: ActivityMpChartAndroidBinding
    private lateinit var combinedChart: CombinedChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMpChartAndroidBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        lineChart()

//        barChart()

//        setupPieChart()

//        combinedChart()

//        setupScatterChart()

//        setupCandleStickChart()

//        setupRadarChart()

//        setupBubbleChart()

        setupMultiBarChart()
    }

    private fun setupMultiBarChart() {
        binding.barChart.visibility = View.VISIBLE

        val stackEntries1 = listOf(
            BarEntry(1f, floatArrayOf(10f, 15f, 8f)),
            BarEntry(2f, floatArrayOf(20f, 25f, 18f)),
            BarEntry(3f, floatArrayOf(20f, 25f, 18f)),
            BarEntry(4f, floatArrayOf(20f, 25f, 18f)),
            BarEntry(5f, floatArrayOf(15f, 20f, 12f))
        )

        val dataSet = BarDataSet(stackEntries1, "")

        dataSet.colors = listOf(
            Color.RED,
            Color.BLUE,
            Color.DKGRAY
        )

        dataSet.stackLabels = arrayOf("Dataset 1", "Dataset 2", "Dataset 3")

        val barData = BarData(dataSet)

        barData.barWidth = 0.5f

        binding.barChart.apply {
            data = barData
            description.isEnabled = false

            legend.isEnabled = true
            legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
            legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT

            xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM
                granularity = 1f
                setDrawGridLines(true)
            }

            axisLeft.apply {
                setDrawGridLines(true)
                axisMinimum = 0f
            }

            axisRight.isEnabled = false

            animateY(5000)

            invalidate()
        }
    }


    private fun setupPieChart() {
        binding.pieChart.visibility = View.VISIBLE
        val pieEntries = listOf(
            PieEntry(40f, "Category 1"),
            PieEntry(30f, "Category 2"),
            PieEntry(20f, "Category 3"),
            PieEntry(10f, "Category 4")
        )

        val dataSet = PieDataSet(pieEntries, "Sample Pie Chart")
        dataSet.colors = listOf(Color.RED, Color.GREEN, Color.DKGRAY, Color.YELLOW)
        dataSet.valueTextColor = Color.BLACK

        val pieData = PieData(dataSet)
        binding.pieChart.data = pieData

        binding.pieChart.animateY(1000)

        binding.pieChart.invalidate()
    }

    private fun setupRadarChart() {
        binding.radarChart.visibility = View.VISIBLE

        val radarEntries = mutableListOf(
            RadarEntry(4f),
            RadarEntry(2f),
            RadarEntry(6f),
            RadarEntry(3f),
            RadarEntry(4f),
            RadarEntry(2f),
            RadarEntry(6f),
            RadarEntry(3f),
            RadarEntry(5f)
        )
        val dataSet = RadarDataSet(radarEntries, "Sample Radar Chart")
        dataSet.color = Color.MAGENTA
        dataSet.fillColor = Color.MAGENTA
        dataSet.fillAlpha = 100
        dataSet.lineWidth = 2f
        dataSet.valueTextColor = Color.BLACK
        dataSet.valueTextSize = 12f
        val radarData = RadarData(dataSet)
        binding.radarChart.data = radarData
        binding.radarChart.webLineWidth = 1f
        binding.radarChart.webColor = Color.GRAY
        binding.radarChart.webAlpha = 100
        binding.radarChart.animateXY(1000, 1000)
        binding.radarChart.invalidate()
    }

    private fun setupScatterChart() {
        binding.scatterChart.visibility = View.VISIBLE
        val scatterEntries = listOf(
            Entry(1f, 1f),
            Entry(2f, 4f),
            Entry(3f, 9f),
            Entry(4f, 16f)
        )
        val dataSet = ScatterDataSet(scatterEntries, "Sample Scatter Chart")
        dataSet.color = Color.CYAN
        val scatterData = ScatterData(dataSet)
        binding.scatterChart.data = scatterData
        binding.scatterChart.invalidate()
    }

    private fun setupCandleStickChart() {
        binding.candleStickChart.visibility = View.VISIBLE

        val candleEntries = listOf(
            CandleEntry(1f, 20f, 10f, 15f, 18f),
            CandleEntry(2f, 25f, 15f, 20f, 22f),
            CandleEntry(3f, 30f, 18f, 24f, 28f),
            CandleEntry(4f, 35f, 25f, 30f, 32f),
            CandleEntry(5f, 20f, 10f, 18f, 15f),
            CandleEntry(6f, 25f, 15f, 20f, 22f),
            CandleEntry(7f, 30f, 18f, 35f, 28f),
            CandleEntry(8f, 35f, 25f, 30f, 32f)
        )
        val dataSet = CandleDataSet(candleEntries, "Sample CandleStick Chart")

        dataSet.setColor(Color.BLACK)
        dataSet.shadowColor = Color.BLACK
        dataSet.shadowWidth = 2f

        dataSet.decreasingColor = Color.RED
        dataSet.decreasingPaintStyle = Paint.Style.FILL_AND_STROKE
        dataSet.increasingColor = Color.GREEN
        dataSet.increasingPaintStyle = Paint.Style.FILL_AND_STROKE

        val candleData = CandleData(dataSet)
        binding.candleStickChart.data = candleData

        binding.candleStickChart.xAxis.setDrawGridLines(false)
        binding.candleStickChart.axisLeft.setDrawGridLines(false)
        binding.candleStickChart.axisRight.setDrawGridLines(false)

        binding.candleStickChart.setBackgroundColor(Color.WHITE)

        binding.candleStickChart.animateXY(1000, 1000)

        binding.candleStickChart.invalidate()
    }

    private fun setupBubbleChart() {
        binding.bubbleChart.visibility = View.VISIBLE

        val bubbleEntries = listOf(
            BubbleEntry(1f, 10f, 10f),
            BubbleEntry(2f, 20f, 10f),
            BubbleEntry(3f, 15f, 7f),
            BubbleEntry(4f, 25f, 12f)
        )
        val dataSet = BubbleDataSet(bubbleEntries, "Sample Bubble Chart")
        dataSet.setColor(Color.RED)
        val bubbleData = BubbleData(dataSet)
        binding.bubbleChart.data = bubbleData
        binding.bubbleChart.invalidate()
    }

    private fun combinedChart() {
        binding.combinedChart.visibility = View.VISIBLE

        combinedChart = binding.combinedChart
        val lineEntries = listOf(
            Entry(1f, 2f),
            Entry(2f, 6f),
            Entry(3f, 4f),
            Entry(4f, 8f),
            Entry(5f, 5f)
        )
        val lineDataSet = LineDataSet(lineEntries, "Line Data")
        lineDataSet.color = Color.BLUE
        lineDataSet.setDrawCircles(true)
        lineDataSet.setLineWidth(2f)
        val lineData = LineData(lineDataSet)

        val barEntries = listOf(
            BarEntry(1f, 10f),
            BarEntry(2f, 20f),
            BarEntry(3f, 15f),
            BarEntry(4f, 30f),
            BarEntry(5f, 25f)
        )
        val barDataSet = BarDataSet(barEntries, "Bar Data")
        barDataSet.color = Color.GREEN
        val barData = BarData(barDataSet)

        val combinedData = CombinedData()
        combinedData.setData(lineData)
        combinedData.setData(barData)

        combinedChart.data = combinedData
        combinedChart.invalidate()
        combinedChart.animateXY(1000, 1000)
        combinedChart.description.text = "Combined Line and Bar Chart"
        combinedChart.setNoDataText("No data available.")
    }

    private fun barChart() {
        binding.barChart.visibility = View.VISIBLE

        val entries = listOf(
            BarEntry(1f, 10f),
            BarEntry(2f, 20f),
            BarEntry(3f, 15f),
            BarEntry(4f, 30f),
            BarEntry(5f, 25f)
        )
        val dataSet = BarDataSet(entries, "Sample Data")
        dataSet.color = Color.BLUE
        val barData = BarData(dataSet)
        binding.barChart.data = barData
        binding.barChart.animateY(5000)
        binding.barChart.invalidate()
    }

    private fun lineChart() {
        binding.lineChart.visibility = View.VISIBLE

        val lineChart = binding.lineChart
        val lineEntries = ArrayList<Entry>()
        lineEntries.add(Entry(1f, 2f))
        lineEntries.add(Entry(2f, 6f))
        lineEntries.add(Entry(3f, 4f))
        lineEntries.add(Entry(4f, 8f))
        lineEntries.add(Entry(5f, 5f))

        val lineDataSet = LineDataSet(lineEntries, "Sample Data")
        lineDataSet.color = Color.BLUE
        lineDataSet.valueTextColor = Color.BLACK
        lineDataSet.valueTextSize = 12f

        val lineData = LineData(lineDataSet)
        lineChart.data = lineData

        val description = Description()
        description.text = "Sample Line Chart"
        lineChart.description = description
        lineChart.setNoDataText("No data available.")
        lineChart.animateXY(1000, 1000)
    }
}
