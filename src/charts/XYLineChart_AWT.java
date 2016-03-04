package charts;
import java.awt.Color; 
import java.awt.BasicStroke; 
import java.util.LinkedList;

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import storage.Result;

public abstract class XYLineChart_AWT extends ApplicationFrame 
{
	/**
	 * http://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm
	 */
	private static final long serialVersionUID = 1L;


	public XYLineChart_AWT( String applicationTitle, String chartTitle, String xTitle, String yTitle, LinkedList<Result> resultsBFS, LinkedList<Result> resultsDFS, LinkedList<Result> resultsDFID )
	{
		super(applicationTitle);
		JFreeChart xylineChart = ChartFactory.createXYLineChart(
				chartTitle ,
				xTitle ,
				yTitle ,
				createDataset(resultsBFS, resultsDFS, resultsDFID) ,
				PlotOrientation.VERTICAL ,
				true , true , false);

		ChartPanel chartPanel = new ChartPanel( xylineChart);
		chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
		final XYPlot plot = xylineChart.getXYPlot( );
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
		renderer.setSeriesPaint( 0 , Color.GREEN );
		renderer.setSeriesPaint( 1 , Color.red );
		renderer.setSeriesPaint( 2 , Color.YELLOW );
		renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
		renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
		renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
		plot.setRenderer( renderer ); 
		setContentPane( chartPanel ); 
	} 

	abstract XYDataset createDataset(LinkedList<Result> resultsBFS,	LinkedList<Result> resultsDFS, LinkedList<Result> resultsDFID) ;
}