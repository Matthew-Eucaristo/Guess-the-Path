package com.company.graph;

public record Edge(String id, Vertex source, Vertex destination, int weight) {
    /**
     * Edge records containing Edge's id, source, destination and weight.
     */
    @Override
    public String toString() {
        return source + " " + destination;
    }


}