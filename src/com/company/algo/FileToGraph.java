package com.company.algo;

import com.company.algo.dijkstra.Edge;
import com.company.algo.dijkstra.Graph;
import com.company.algo.dijkstra.Vertex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileToGraph {
    private List<Vertex> nodes;
    private Graph graph;

    private List<Edge> edges;
    // for file number we want to use
    private int fileNumber;

    // for temporary list that needed to be returned
    List<String> listVertex;
    List<String> listAwalan;
    List<String> listAkhiran;
    List<String> listWeight;

    public FileToGraph(int fileNameNumber) throws IOException {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();

        // Initializing what file we want to check
        fileNumber = fileNameNumber;

        // Taking file
        BufferedReader reader = new BufferedReader(new FileReader(String.format("src/com/company/soal/adjlist/%d.txt", fileNumber)));
        listVertex = new ArrayList<>();
        listAwalan = new ArrayList<>();
        listAkhiran = new ArrayList<>();
        listWeight = new ArrayList<>();
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
                    Integer.parseInt(listAkhiran.get(i)),
                    Integer.parseInt(listWeight.get(i))
            );
        }

        // Set up graph
        graph = new Graph(nodes, edges);

        // Closing reader
        reader.close();
    }


    public Graph getGraph() {
        return graph;
    }

    public  List<Vertex> getNodes() {
        return nodes;
    }

    public  List<Edge> getEdges() {
        return edges;
    }

    public List<String> getListVertex() {
        return listVertex;
    }

    public List<String> getListAwalan() {
        return listAwalan;
    }

    public List<String> getListAkhiran() {
        return listAkhiran;
    }

    public List<String> getListWeight() {
        return listWeight;
    }

    private  void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }
}
