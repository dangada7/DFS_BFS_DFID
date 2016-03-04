package charts;

import java.util.LinkedList;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import storage.Result;

public class XYLineChart_memoryCoplexity extends XYLineChart_AWT{

	public XYLineChart_memoryCoplexity(String applicationTitle,
			String chartTitle, String xTitle, String yTitle,
			LinkedList<Result> resultsBFS, LinkedList<Result> resultsDFS,
			LinkedList<Result> resultsDFID) {
		super(applicationTitle, chartTitle, xTitle, yTitle, resultsBFS, resultsDFS,
				resultsDFID);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected XYDataset createDataset(LinkedList<Result> resultsBFS, LinkedList<Result> resultsDFS, LinkedList<Result> resultsDFID) {
		
		final XYSeries BFS = new XYSeries("BFS"); 
		for(Result result: resultsBFS){
			BFS.add(result.getGraphSize(),result.getMaxHoldNodes());
		}
		
		final XYSeries DFS = new XYSeries("DFS"); 
		for(Result result: resultsDFS){
			DFS.add(result.getGraphSize(),result.getMaxHoldNodes());
		}
		
		final XYSeries DFID = new XYSeries("DFID"); 
		for(Result result: resultsDFID){
			DFID.add(result.getGraphSize(),result.getMaxHoldNodes());
		}
			
		
		final XYSeriesCollection dataset = new XYSeriesCollection( );          
		dataset.addSeries( BFS );          
		dataset.addSeries( DFS );          
		dataset.addSeries( DFID );
		
		return dataset;
	}
}

