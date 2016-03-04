package charts;

import java.util.LinkedList;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import storage.Result;

public class XYLIneChart_timeComplexity extends XYLineChart_AWT{

	
	public XYLIneChart_timeComplexity(String applicationTitle,
			String chartTitle, String xTitle, String yTitle,
			LinkedList<Result> resultsBFS, LinkedList<Result> resultsDFS,
			LinkedList<Result> resultsDFID) {
		super(applicationTitle, chartTitle, xTitle, yTitle, resultsBFS, resultsDFS,
				resultsDFID);
		// TODO Auto-generated constructor stub
	}

	protected XYDataset createDataset(LinkedList<Result> resultsBFS, LinkedList<Result> resultsDFS, LinkedList<Result> resultsDFID) {
		
		final XYSeries BFS = new XYSeries("BFS"); 
		for(Result result: resultsBFS){
			BFS.add(result.getGraphSize(),result.getGenerateNodesNum());
		}
		
		final XYSeries DFS = new XYSeries("DFS"); 
		for(Result result: resultsDFS){
			DFS.add(result.getGraphSize(),result.getGenerateNodesNum());
		}
		
		final XYSeries DFID = new XYSeries("DFID"); 
		for(Result result: resultsDFID){
			DFID.add(result.getGraphSize(),result.getGenerateNodesNum());
		}
			
		
		final XYSeriesCollection dataset = new XYSeriesCollection( );          
		dataset.addSeries( BFS );          
		dataset.addSeries( DFS );          
		dataset.addSeries( DFID );
		
		return dataset;
	}

}
