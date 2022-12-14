package com.company.algo.bfs;

import com.company.graph.Edge;
import com.company.graph.Graph;
import com.company.graph.Vertex;

import java.util.*;

import static com.company.algo.Checker.returnIndexInCharArray;

public class BFS {
    /**
     * Code is inspired by <a href="https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/">...</a>
     * and modified solely just for the purpose of this project.
     */
    private final char[] alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final List<Vertex> nodes;
    private final List<Edge> edges;

    private String answer;

    public BFS(Graph graph) {
        // create a copy of the array so that we can operate on this array
        this.nodes = new ArrayList<>(graph.vertexes());
        this.edges = new ArrayList<>(graph.edges());

        // create boolean visited array
        boolean[] visited = new boolean[nodes.size()];

        // our code always use A as a starting point
        visited[0] = true;

        // Create queue
        Queue<Integer> queue = new LinkedList<>();

        // Add starting point to queue
        queue.add(0);

        // Here we use A is 0, B is 1 and so on
        // Looping start
        StringBuilder sb = new StringBuilder();
        int temp;
        boolean first = true;
        while (!queue.isEmpty()) {
            // dequeue and return value to temp
            temp = queue.poll();

            if (!visited[temp] || first) {
                // set first to false
                first = false;

                // set visited to true
                visited[temp] = true;
                // get value and add to sb
                sb.append("%c".formatted(alphabetUpperCase[temp]));

                // get all connected vertex
                List<Integer> connectedVertex = returnConnectedVertex(temp);

                for (Integer i :
                        connectedVertex) {
                    // "i" is iterator for all vertex (in number) that is connected with temp
                    if (!visited[i]) {
                        queue.add(i);
                    }
                }
            }
        }

        // return the answer
        answer = sb.toString();
    }

    private ArrayList<Integer> returnConnectedVertex(int vertexInNumber) {
        // Get alphabetic representation of vertex
        char vertexInChar = alphabetUpperCase[vertexInNumber];

        // Create arraylist to contain all connected vertex
        ArrayList<Integer> connectedVertex = new ArrayList<>();

        // foreach to check from edges
        for (Edge e :
                edges) {
            if (e.source().name().charAt(0) == vertexInChar) {
                connectedVertex.add(returnIndexInCharArray(alphabetUpperCase, e.destination().name().charAt(0)));
            } else if (e.destination().name().charAt(0) == vertexInChar) {
                connectedVertex.add(returnIndexInCharArray(alphabetUpperCase, e.source().name().charAt(0)));
            }
        }

        // sort the connectedVertex
        Collections.sort(connectedVertex);

        // return the array
        return connectedVertex;
    }

    public String getAnswer() {
        // trim and convert to lowercase
        return answer.trim().toLowerCase();
    }

}
