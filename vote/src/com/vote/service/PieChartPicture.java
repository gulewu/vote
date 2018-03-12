package com.vote.service;

import java.awt.Color;
import java.awt.Font;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieChartPicture {
	public static void main(String[] args) {
		PieDataset dataset = getDataSet();
		JFreeChart chart = ChartFactory.createPieChart3D(" 项目进度分布",

		dataset, true, true, false);
		PiePlot3D plot = (PiePlot3D) chart.getPlot();

		plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}={1}({2})", NumberFormat.getNumberInstance(),
				new DecimalFormat("0.00%")));

		plot.setLegendLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0}={1}({2})"));

		chart.setBackgroundPaint(Color.white);

		plot.setForegroundAlpha(1.0F);

		plot.setCircular(true);

		Font font = new Font("黑体", 1, 20);
		TextTitle title = new TextTitle(" 项目状态分布");
		title.setFont(font);

		chart.getLegend().setItemFont(font);

		plot.setLabelFont(font);
		chart.setTitle(title);
		FileOutputStream fos_jpg = null;
		try {
			fos_jpg = new FileOutputStream("c:\\AA.jpg");
			ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0F, chart, 640, 480,
					null);
			fos_jpg.close();
		} catch (Exception localException) {
		}
	}

	private static PieDataset getDataSet() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue(" 市场前期", new Double(10.0D));
		dataset.setValue(" 立项", new Double(15.0D));
		dataset.setValue(" 计划", new Double(10.0D));
		dataset.setValue(" 需求与设计", new Double(10.0D));
		dataset.setValue(" 执行控制", new Double(35.0D));
		dataset.setValue(" 收尾", new Double(10.0D));
		dataset.setValue(" 运维", new Double(10.0D));
		return dataset;
	}
}
