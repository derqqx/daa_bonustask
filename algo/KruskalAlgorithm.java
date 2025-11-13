package com.example.mst.algo;

import com.example.mst.model.GraphContainer;
import com.example.mst.model.GraphEdge;
import com.example.mst.core.DisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {
    public static List<GraphEdge> buildMst(GraphContainer container) {
        List<GraphEdge> mst = new ArrayList<>();
        List<GraphEdge> sortedEdges = new ArrayList<>(container.allEdges);

        Collections.sort(sortedEdges);

        DisjointSet ds = new DisjointSet(container.vertexCount);

        for (GraphEdge edge : sortedEdges) {
            int rootU = ds.find(edge.u);
            int rootV = ds.find(edge.v);

            if (rootU != rootV) {
                mst.add(edge);
                ds.union(rootU, rootV);
            }
        }
        return mst;
    }
}