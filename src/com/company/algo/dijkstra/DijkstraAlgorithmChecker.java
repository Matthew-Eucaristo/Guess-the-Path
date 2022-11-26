package com.company.algo.dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DijkstraAlgorithmChecker {

    private static List<Vertex> nodes;
    private static List<Edge> edges;
    // for file number we want to use
    private int fileNumber;
    // for returning value of shortest path
    private String returnValue;

    // All the magic is done on the constructor
    public DijkstraAlgorithmChecker(int fileNameNumber) throws IOException {
        // Initializing nodes and edges
        nodes = new ArrayList<>();
        edges = new ArrayList<>();

        // Initializing what file we want to check
        fileNumber = fileNameNumber;

        // Taking file
        BufferedReader reader = new BufferedReader(new FileReader(String.format("src/com/company/soal/adjlist/%d.txt", fileNumber)));
        List<String> listVertex = new ArrayList<>();
        List<String> listAwalan = new ArrayList<>();
        List<String> listAkhiran = new ArrayList<>();
        List<String> listWeight = new ArrayList<>();
        String temp;

        // Reading Vertex
        temp = reader.readLine(); // berisi vertex
        Collections.addAll(listVertex, temp.split(" ")); // sudah berisi vertex yang terpisah
        for (String s :
                listVertex) {
            Vertex location = new Vertex(s, s);
            nodes.add(location);
        }
        
        // Reading edges and weights
        temp = reader.readLine();
        while (temp != null) {
            String[] pengambilanEdges = temp.split(" ");
            listAwalan.add(pengambilanEdges[0]);
            listAkhiran.add(pengambilanEdges[1]);
            listWeight.add(pengambilanEdges[2]);

            // next line
            temp = reader.readLine();
        }

        // Test validity of edges and weights
        assert listAkhiran.size() == listAwalan.size();

        // Add lanes / edges
        for (int i = 0; i < listAkhiran.size(); i++) {
            addLane(
                    String.format("lane%d", i),
                    Integer.parseInt(listAwalan.get(i)),
                    Integer.parseInt(listWeight.get(i)),
                    Integer.parseInt(listAkhiran.get(i))
            );
        }

        // Set up graph
        Graph graph = new Graph(nodes, edges);
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

        // Closing reader
        reader.close();
    }

    public boolean getReturnValue(String answer) {
        // value to check is in lowercase, no space between
        return Objects.equals(returnValue.toLowerCase(), Arrays.toString(answer.split(" ")).toLowerCase());
    }

    private static void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }
}