package com.company.algo;

import com.company.graph.Edge;
import com.company.graph.Vertex;

import java.util.List;
import java.util.Objects;

public abstract class Checker {
    // Declaration
    protected List<Vertex> nodes;
    protected List<Edge> edges;
    protected String returnValue;
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
