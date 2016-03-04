
import java.util.LinkedList;

import old.BinaryTree;

import org.jfree.ui.RefineryUtilities;

import charts.XYLIneChart_timeComplexity;
import charts.XYLineChart_AWT;
import charts.XYLineChart_memoryCoplexity;
import SearchAlgorithm.BFS;
import SearchAlgorithm.DFID;
import SearchAlgorithm.DFS;
import storage.Graph;
import storage.Result;


public class Main {
	

	public static void main(String[] args) {
		
		experiment1(500, 10000);
		
		experiment2(500, 10000, 40);
		
		experiment3(500, 10000, 40);
		
	}
	

	/**
	 * experiment 2
	 */
	private static void experiment3(int minDepth, int maxDepth, int repeat) {
		DFID dfid = new DFID();
		DFS dfs = new DFS();
		BFS bfs = new BFS();

		LinkedList<Result> resultsDFS = new LinkedList<Result>();
		LinkedList<Result> resultsBFS = new LinkedList<Result>();
		LinkedList<Result> resultsDFID = new LinkedList<Result>();

		int BFS_SumGenerateNodes = 0, DFS_SumGenerateNodes = 0, DFID_SumGenerateNodes = 0;
		int BFS_SumMaxHoldNodes = 0, DFS_SumMaxHoldNodes = 0, DFID_SumMaxHoldNodes = 0;
		
		Result resultBFS = null, resultDFS = null, resultDFID = null;
		Graph graph;
		int goalValue; // not exist

		//create the trees and get the results
		for (int i=minDepth; i<maxDepth; i=i+100){
			graph = Graph.create2Graph(i);
			
			for(int j=0; j< repeat; j++){
				goalValue= (int)(Math.random()*i);
				
				resultBFS = bfs.searchTree(graph, goalValue);
				resultDFS = dfs.searchTree(graph, goalValue);
				resultDFID = dfid.searchTree(graph, goalValue);
				
				BFS_SumGenerateNodes = BFS_SumGenerateNodes + resultBFS.getGenerateNodesNum();
				DFS_SumGenerateNodes = DFS_SumGenerateNodes + resultDFS.getGenerateNodesNum();
				DFID_SumGenerateNodes = DFID_SumGenerateNodes + resultDFID.getGenerateNodesNum();
				
				BFS_SumMaxHoldNodes = BFS_SumMaxHoldNodes + resultBFS.getMaxHoldNodes();
				DFS_SumMaxHoldNodes = DFS_SumMaxHoldNodes + resultDFS.getMaxHoldNodes();
				DFID_SumMaxHoldNodes = DFID_SumMaxHoldNodes + resultDFID.getMaxHoldNodes();

			}
			
			resultBFS.setGenerateNodesNum(BFS_SumGenerateNodes / repeat);
			resultDFS.setGenerateNodesNum(DFS_SumGenerateNodes / repeat);
			resultDFID.setGenerateNodesNum(DFID_SumGenerateNodes / repeat);

			resultBFS.setMaxNodesNum(BFS_SumMaxHoldNodes / repeat);
			resultDFS.setMaxNodesNum(DFS_SumMaxHoldNodes / repeat);
			resultDFID.setMaxNodesNum(DFID_SumMaxHoldNodes / repeat);
			
			resultsBFS.add(resultBFS);
			resultsDFS.add(resultDFS);
			resultsDFID.add(resultDFID);
		}
		
		//draw the chart generates
		XYLineChart_AWT chart_time = new XYLIneChart_timeComplexity("BFS, DFS, DFID", "time coplexity - goal value exist G2", "graph size(number of nodes)", "number of generated nodes", resultsBFS, resultsDFS, resultsDFID);
		chart_time.pack( );          
		RefineryUtilities.centerFrameOnScreen( chart_time );          
		chart_time.setVisible( true ); 

		XYLineChart_AWT chart_memory = new XYLineChart_memoryCoplexity("BFS, DFS, DFID", "space coplexity - goal value exist G2", "graph size(number of nodes)", "number of nodes the algorithm holds", resultsBFS, resultsDFS, resultsDFID);
		chart_memory.pack( );          
		RefineryUtilities.centerFrameOnScreen( chart_memory );          
		chart_memory.setVisible( true ); 
		
	}
	
	
	
	
	
	/**
	 * experiment 2
	 */
	private static void experiment2(int minDepth, int maxDepth, int repeat) {
		DFID dfid = new DFID();
		DFS dfs = new DFS();
		BFS bfs = new BFS();

		LinkedList<Result> resultsDFS = new LinkedList<Result>();
		LinkedList<Result> resultsBFS = new LinkedList<Result>();
		LinkedList<Result> resultsDFID = new LinkedList<Result>();

		int BFS_SumGenerateNodes = 0, DFS_SumGenerateNodes = 0, DFID_SumGenerateNodes = 0;
		int BFS_SumMaxHoldNodes = 0, DFS_SumMaxHoldNodes = 0, DFID_SumMaxHoldNodes = 0;
		
		Result resultBFS = null, resultDFS = null, resultDFID = null;
		Graph graph;
		int goalValue; // not exist

		//create the trees and get the results
		for (int i=minDepth; i<maxDepth; i=i+100){
			graph = Graph.create3Graph(i);
			
			for(int j=0; j< repeat; j++){
				goalValue= (int)(Math.random()*i);
				
				resultBFS = bfs.searchTree(graph, goalValue);
				resultDFS = dfs.searchTree(graph, goalValue);
				resultDFID = dfid.searchTree(graph, goalValue);
				
				BFS_SumGenerateNodes = BFS_SumGenerateNodes + resultBFS.getGenerateNodesNum();
				DFS_SumGenerateNodes = DFS_SumGenerateNodes + resultDFS.getGenerateNodesNum();
				DFID_SumGenerateNodes = DFID_SumGenerateNodes + resultDFID.getGenerateNodesNum();
				
				BFS_SumMaxHoldNodes = BFS_SumMaxHoldNodes + resultBFS.getMaxHoldNodes();
				DFS_SumMaxHoldNodes = DFS_SumMaxHoldNodes + resultDFS.getMaxHoldNodes();
				DFID_SumMaxHoldNodes = DFID_SumMaxHoldNodes + resultDFID.getMaxHoldNodes();

			}
			
			resultBFS.setGenerateNodesNum(BFS_SumGenerateNodes / repeat);
			resultDFS.setGenerateNodesNum(DFS_SumGenerateNodes / repeat);
			resultDFID.setGenerateNodesNum(DFID_SumGenerateNodes / repeat);

			resultBFS.setMaxNodesNum(BFS_SumMaxHoldNodes / repeat);
			resultDFS.setMaxNodesNum(DFS_SumMaxHoldNodes / repeat);
			resultDFID.setMaxNodesNum(DFID_SumMaxHoldNodes / repeat);
			
			resultsBFS.add(resultBFS);
			resultsDFS.add(resultDFS);
			resultsDFID.add(resultDFID);
		}
		
		//draw the chart generates
		XYLineChart_AWT chart_time = new XYLIneChart_timeComplexity("BFS, DFS, DFID", "time coplexity - goal value exist G3", "graph size(number of nodes)", "number of generated nodes", resultsBFS, resultsDFS, resultsDFID);
		chart_time.pack( );          
		RefineryUtilities.centerFrameOnScreen( chart_time );          
		chart_time.setVisible( true ); 

		XYLineChart_AWT chart_memory = new XYLineChart_memoryCoplexity("BFS, DFS, DFID", "space coplexity - goal value exist G3", "graph size(number of nodes)", "number of nodes the algorithm holds", resultsBFS, resultsDFS, resultsDFID);
		chart_memory.pack( );          
		RefineryUtilities.centerFrameOnScreen( chart_memory );          
		chart_memory.setVisible( true ); 
		
	}
	/**
	 * experiment 1
	 * search trees with value that dont exist
	 * how long it take to generate all the tree;
	 */
	private static void experiment1(int minDepth, int maxDepth) {
		DFID dfid = new DFID();
		DFS dfs = new DFS();
		BFS bfs = new BFS();

		LinkedList<Result> resultsDFS = new LinkedList<Result>();
		LinkedList<Result> resultsBFS = new LinkedList<Result>();
		LinkedList<Result> resultsDFID = new LinkedList<Result>();

		Result resultBFS, resultDFS, resultDFID;
		Graph graph;
		int goalValue = -1; // not exist

		//create the trees and get the results
		for (int i=minDepth; i<maxDepth; i=i+500){
			
			graph = Graph.create3Graph(i);
							
			resultBFS = bfs.searchTree(graph, goalValue);
			resultDFS = dfs.searchTree(graph, goalValue);
			resultDFID = dfid.searchTree(graph, goalValue);
			
			resultsBFS.add(resultBFS);
			resultsDFS.add(resultDFS);
			resultsDFID.add(resultDFID);
		}
		
		//draw the chart generates
		XYLineChart_AWT chart_time = new XYLIneChart_timeComplexity("BFS, DFS, DFID", "time coplexity - goal value doesn't exist G3", "graph size(number of nodes)", "number of generated nodes", resultsBFS, resultsDFS, resultsDFID);
		chart_time.pack( );          
		RefineryUtilities.centerFrameOnScreen( chart_time );          
		chart_time.setVisible( true ); 

		XYLineChart_AWT chart_memory = new XYLineChart_memoryCoplexity("BFS, DFS, DFID", "space coplexity - goal value doesn't exist G3", "graph size(number of nodes)", "number of nodes the algorithm holds", resultsBFS, resultsDFS, resultsDFID);
		chart_memory.pack( );          
		RefineryUtilities.centerFrameOnScreen( chart_memory );          
		chart_memory.setVisible( true ); 
	}
	

	
}
