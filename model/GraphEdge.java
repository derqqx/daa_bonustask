package com.example.mst.model;

public class GraphEdge implements Comparable<GraphEdge> {
    public int u;
    public int v;
    public int weight;

    public GraphEdge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.weight = w;
    }

    @Override
    public int compareTo(GraphEdge other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return u + " -- " + v + " == " + weight;
    }
}