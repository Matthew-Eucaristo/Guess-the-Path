package com.company.algo.dijkstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestDijkstraAlgorithm {

    private static List<Vertex> nodes;
    private static List<Edge> edges;

    public static void main(String[] args) {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLane("lane1", 0, 2, 5);
        addLane("lane2", 0, 3, 9);
        addLane("lane3", 1, 2, 2);
        addLane("lane4", 1, 3, 1);
        addLane("lane5", 2, 3, 3);

        // Setting up the source
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0));

        // Setting up the destination
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(3));

        // Printing
        for (Vertex vertex :
                path) {
            System.out.println(vertex);
        }
    }

    private static void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }
}