package com.company.algo.dijkstra;

import com.company.algo.FileToGraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DijkstraAlgorithmChecker {

    private  List<Vertex> nodes;

    private  List<Edge> edges;
    // for file number we want to use
    private int fileNumber;
    // for returning value of the shortest path
    private String returnValue;

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
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(listVertex.size()-1)); // Destination always at last

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

    public boolean getReturnValue(String answer) {
        // value to check is in lowercase, no space between
        StringBuilder sb = new StringBuilder();
        for (String s :
                answer.split(" ")) {
            sb.append(s.toLowerCase());
        }
        return Objects.equals(returnValue.toLowerCase(), sb.toString());
    }

}