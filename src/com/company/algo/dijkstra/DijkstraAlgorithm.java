package com.company.algo.dijkstra;
import com.company.graph.Edge;
import com.company.graph.Graph;
import com.company.graph.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {
    // Declaration
    private final List<Edge> edges;
    private final Set<Vertex> settledNodes = new HashSet<>();
    private Set<Vertex> unSettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distance;

    public DijkstraAlgorithm(Graph graph) {
        // Constructor for generating new array, so we can operate independently (not risking the original graph
        this.edges = new ArrayList<>(graph.edges());
    }

    public void execute(Vertex source) {
        // Execute method to execute whole Dijkstra's Shortest Path Algorithm
        unSettledNodes = new HashSet<>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();

        // first time only, put source to array
        distance.put(source, 0);
        unSettledNodes.add(source);

        // Loop while there are unsettled Nodes left
        while (!unSettledNodes.isEmpty()) {
            // call all helper function
            Vertex node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Vertex node) {
        // function to get the minimal distances while correcting the distance of the nodes
        List<Vertex> adjacentNodes = getNeighbors(node);

        // loop all target vertex that is connected and fix each of the nodes
        for (Vertex target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }

    }

    private int getDistance(Vertex node, Vertex target) {
        // helper function to get the weight
        for (Edge edge : edges) {
            if (edge.source().equals(node)
                    && edge.destination().equals(target)) {
                return edge.weight();
            }
        }

        // Error Case
        return -1;
    }

    private List<Vertex> getNeighbors(Vertex node) {
        // helper function to get all neighbor (all vertex connected)
        List<Vertex> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.source().equals(node)
                    && !isSettled(edge.destination())) {
                neighbors.add(edge.destination());
            }
        }
        return neighbors;
    }

    private Vertex getMinimum(Set<Vertex> vertexes) {
        // helper function to get the minimum shortest distance vertex
        Vertex minimum = null;
        for (Vertex vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertex vertex) {
        return settledNodes.contains(vertex);
    }

    private int getShortestDistance(Vertex destination) {
        // helper function to get the distance and handling if it's null
        Integer d = distance.get(destination);
        if (d == null) return Integer.MAX_VALUE; else return d;
    }

    public List<Vertex> getPath(Vertex target) {
        /*
         * This method returns the path from the source to the selected target and
         * NULL if no path exists
         */
        LinkedList<Vertex> path = new LinkedList<>();
        Vertex step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return Collections.emptyList();
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

}