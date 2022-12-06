package com.company.algo.dfs;

import com.company.graph.Edge;
import com.company.graph.Graph;
import com.company.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    private final List<Vertex> nodes;
    private final List<Edge> edges;
    public DFS(Graph graph) {
        // create a copy of the array so that we can operate on this array
        this.nodes = new ArrayList<>(graph.vertexes());
        this.edges = new ArrayList<>(graph.edges());

        // our code always use A as a starting point
    }

}
