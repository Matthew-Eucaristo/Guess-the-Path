package com.company.algo.dijkstra;

import com.company.algo.Checker;
import com.company.graph.FileToGraph;
import com.company.graph.Graph;
import com.company.graph.Vertex;

import java.io.IOException;
import java.util.*;

public class DijkstraAlgorithmChecker extends Checker {
    // All the magic is done on the constructor
    public DijkstraAlgorithmChecker(int fileNameNumber) throws IOException {
        // Get Graph
        FileToGraph graphReader = new FileToGraph(fileNameNumber);
        Graph graph = graphReader.getGraph();
        nodes = graphReader.getNodes();
        edges = graphReader.getEdges();
        List<String> listVertex = graphReader.getListVertex();

        // Run dijkstra Algorithm
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0)); // Start always first vertex

        // Setting up the destination
        LinkedList<Vertex> path = (LinkedList<Vertex>) dijkstra.getPath(nodes.get(listVertex.size() - 1)); // Destination always at last

        // Print for debugging purposes
        StringBuilder strBuild = new StringBuilder();
        System.out.println("--Shortest path--");
        for (Vertex vertex :
                path) {
            System.out.println(vertex);
            strBuild.append(vertex);
        }

        // Set up the return value
        returnValue = strBuild.toString();

    }


}