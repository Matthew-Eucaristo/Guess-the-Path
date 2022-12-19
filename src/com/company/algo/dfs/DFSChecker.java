package com.company.algo.dfs;

import com.company.algo.Checker;
import com.company.graph.FileToGraph;
import com.company.graph.Graph;

import java.io.IOException;

public class DFSChecker extends Checker {

    public DFSChecker(int fileNameNumber) throws IOException {
        // Get Graph
        FileToGraph graphReader = new FileToGraph(fileNameNumber);
        Graph graph = graphReader.getGraph();
        nodes = graphReader.getNodes();
        edges = graphReader.getEdges();


        // Instantiate DFS
        DFS dfs = new DFS(graph);
        System.out.println("--Depth First Search--");
        System.out.println(dfs.getAnswer());
        returnValue = dfs.getAnswer();
    }
}
