package tests;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import storage.Graph;
import storage.Node;
import SearchAlgorithm.BFS;
import SearchAlgorithm.DFID;
import SearchAlgorithm.DFS;


public class tests {

	
	
	@Test
	public void testGraph1() {
		Graph graph = Graph.create3Graph(5);
		
		assertEquals(graph.getRoot().getValue(), 0);
		
		assertEquals(graph.getRoot().getChildren().get(0).getValue(), 1);
		assertEquals(graph.getRoot().getChildren().get(1).getValue(), 2);
		assertEquals(graph.getRoot().getChildren().get(2).getValue(), 3);
		
		assertEquals(graph.getRoot().getChildren().get(0).getChildren().get(0).getValue(), 4);
		assertEquals(graph.getRoot().getChildren().get(0).getChildren().get(1).getValue(), 5);
		assertEquals(graph.getRoot().getChildren().get(0).getChildren().get(2).getValue(), 6);
		
		assertEquals(graph.getRoot().getChildren().get(1).getChildren().get(0).getValue(), 7);
		assertEquals(graph.getRoot().getChildren().get(1).getChildren().get(1).getValue(), 8);
		assertEquals(graph.getRoot().getChildren().get(1).getChildren().get(2).getValue(), 9);
		
		assertEquals(graph.getRoot().getChildren().get(2).getChildren().get(0).getValue(), 10);
		assertEquals(graph.getRoot().getChildren().get(2).getChildren().get(1).getValue(), 11);
		assertEquals(graph.getRoot().getChildren().get(2).getChildren().get(2).getValue(), 12);

	}
	
	@Test
	public void testGraph2() {
		Graph graph = Graph.create3Graph(0);
		assertEquals(graph.getGraphDepth(), 0);
		
		graph = Graph.create3Graph(1);
		assertEquals(graph.getGraphDepth(), 1);
		
		graph = Graph.create3Graph(2);
		assertEquals(graph.getGraphDepth(), 2);
		
		graph = Graph.create3Graph(13);
		assertEquals(graph.getGraphDepth(), 3);
		
		
		graph = Graph.create3Graph(14);
		assertEquals(graph.getGraphDepth(), 4);
	
	}

	@Test
	public void testBFS() {
		BFS bfs = new BFS();
		Graph graph = Graph.create3Graph(5);

		assertEquals(bfs.searchTree(graph, 1).getFindNode(), true);
		assertEquals(bfs.searchTree(graph, 4).getFindNode(), true);
		assertEquals(bfs.searchTree(graph, 15).getFindNode(), true);
		assertEquals(bfs.searchTree(graph, 16).getFindNode(), false);
		
	}
	
	@Test
	public void testDFS() {
		DFS dfs = new DFS();
		Graph graph = Graph.create3Graph(5);

		assertEquals(dfs.searchTree(graph, 1).getFindNode(), true);
		assertEquals(dfs.searchTree(graph, 4).getFindNode(), true);
		assertEquals(dfs.searchTree(graph, 15).getFindNode(), true);
		assertEquals(dfs.searchTree(graph, 16).getFindNode(), false);
	}
	
	@Test
	public void testDFID1() {
		DFID dfid = new DFID();
		Graph graph = Graph.create3Graph(5);

		assertEquals(dfid.searchTree(graph, 0).getFindNode(), true);
		assertEquals(dfid.searchTree(graph, 1).getFindNode(), true);
		assertEquals(dfid.searchTree(graph, 4).getFindNode(), true);
		assertEquals(dfid.searchTree(graph, 0).getFindNode(), true);
		assertEquals(dfid.searchTree(graph, 15).getFindNode(), true);
	}
	
	@Test
	public void testDFID2() {
		DFID dfid = new DFID();
		Graph graph = Graph.create3Graph(10);

		assertEquals(dfid.searchTree(graph, 1).getFindNode(), true);
		assertEquals(dfid.searchTree(graph, 4).getFindNode(), true);
		assertEquals(dfid.searchTree(graph, 30).getFindNode(), true);
		assertEquals(dfid.searchTree(graph, 31).getFindNode(), false);
		assertEquals(dfid.searchTree(graph, 0).getFindNode(), true);
	}
	

}
