package com.company.algo.bfs;

import com.company.algo.Checker;
import com.company.graph.FileToGraph;
import com.company.graph.Graph;

import java.io.IOException;

public class BFSChecker extends Checker {
    public BFSChecker(int fileNameNumber) throws IOException {
        // Get Graph
        FileToGraph graphReader = new FileToGraph(fileNameNumber);
        Graph graph = graphReader.getGraph();
        nodes = graphReader.getNodes();
        edges = graphReader.getEdges();


        // Instantiate BFS
        BFS bfs = new BFS(graph);
        System.out.println("--Depth First Search--");
        System.out.println(bfs.getAnswer());
        returnValue = bfs.getAnswer();

    }
}
