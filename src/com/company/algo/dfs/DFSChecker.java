package com.company.algo.dfs;

import com.company.algo.Checker;
import com.company.graph.FileToGraph;
import com.company.graph.Edge;
import com.company.graph.Graph;
import com.company.graph.Vertex;

import java.io.IOException;
import java.util.List;

public class DFSChecker extends Checker {

    public DFSChecker(int fileNameNumber) throws IOException {
        // Get Graph
        FileToGraph graphReader = new FileToGraph(fileNameNumber);
        Graph graph = graphReader.getGraph();
        nodes = graphReader.getNodes();
        edges = graphReader.getEdges();
        List<String> listVertex = graphReader.getListVertex();

        // Instantiate DFS
        DFS dfs = new DFS(graph);
    }
}
