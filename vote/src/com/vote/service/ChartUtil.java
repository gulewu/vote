package com.vote.service;

import java.awt.Color;
import java.awt.Font;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.servlet.http.HttpSession;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.servlet.ChartDeleter;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class ChartUtil {
	public static String generatePieChart(DefaultPieDataset dataset,
			String titleName, int width, int height, HttpSession session,
			PrintWriter pw) {
		String filename = null;
		try {
			if (session != null) {
				ChartDeleter deleter = (ChartDeleter) session
						.getAttribute("JFreeChart_Deleter");
				session.removeAttribute("JFreeChart_Deleter");
				session.setAttribute("JFreeChart_Deleter", deleter);
			}
			JFreeChart chart = ChartFactory.createPieChart3D(titleName,
					dataset, false, true, false);

			PiePlot3D plot = (PiePlot3D) chart.getPlot();

			plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
					"{0}={1}({2})", NumberFormat.getNumberInstance(),
					new DecimalFormat("0%")));

			chart.setBackgroundPaint(Color.white);

			plot.setForegroundAlpha(1.0F);

			plot.setCircular(true);

			Font font = new Font("ºÚÌå", 1, 12);
			Font titleFont = new Font("ºÚÌå", 1, 15);
			TextTitle title = new TextTitle(titleName);
			title.setFont(titleFont);

			plot.setLabelFont(font);
			chart.setTitle(title);

			ChartRenderingInfo info = new ChartRenderingInfo(
					new StandardEntityCollection());

			filename = ServletUtilities.saveChartAsPNG(chart, width, height,
					info, session);

			ChartUtilities.writeImageMap(pw, filename, info, true);
			pw.flush();
		} catch (Exception e) {
			System.out.println("Exception - " + e.toString());
			e.printStackTrace(System.out);
			filename = "picture_error.png";
		}
		return filename;
	}
}
