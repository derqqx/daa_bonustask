package com.example.mst.model;
import java.util.ArrayList;
import java.util.List;

public class GraphContainer {
    public int vertexCount;
    public List<GraphEdge> allEdges = new ArrayList<>();

    public GraphContainer(int count) {
        this.vertexCount = count;
    }
    public void addEdge(int u, int v, int weight) {
        allEdges.add(new GraphEdge(u, v, weight));
    }
}