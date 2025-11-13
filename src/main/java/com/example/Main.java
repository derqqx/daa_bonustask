package com.example;

import com.example.mst.model.GraphContainer;
import com.example.mst.model.GraphEdge;
import com.example.mst.algo.KruskalAlgorithm;
import java.util.*;

public class Main {

    // Component Search (BFS)
    private static List<Set<Integer>> findComponents(int V, List<GraphEdge> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (GraphEdge e : edges) {
            adj.get(e.u).add(e.v);
            adj.get(e.v).add(e.u);
        }

        boolean[] visited = new boolean[V];
        List<Set<Integer>> components = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Set<Integer> comp = new HashSet<>();
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;

                while (!q.isEmpty()) {
                    int node = q.poll();
                    comp.add(node);
                    for (int neighbor : adj.get(node)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            q.add(neighbor);
                        }
                    }
                }
                components.add(comp);
            }
        }
        return components;
    }

    // Finding a replacement edge
    private static GraphEdge findReplacement(GraphContainer container, List<Set<Integer>> components) {
        if (components.size() != 2) return null;

        Set<Integer> comp0 = components.get(0);

        GraphEdge replacement = null;
        int minWeight = Integer.MAX_VALUE;

        for (GraphEdge edge : container.allEdges) {
            boolean uInComp0 = comp0.contains(edge.u);
            boolean vInComp0 = comp0.contains(edge.v);

            if (uInComp0 != vInComp0) {
                if (edge.weight < minWeight) {
                    minWeight = edge.weight;
                    replacement = edge;
                }
            }
        }
        return replacement;
    }

    public static void main(String[] args) {
        // just some graph
        GraphContainer container = new GraphContainer(6);
        container.addEdge(0, 1, 4);
        container.addEdge(0, 2, 3);
        container.addEdge(1, 2, 1);
        container.addEdge(1, 3, 2);
        container.addEdge(2, 3, 4);
        container.addEdge(3, 4, 2);
        container.addEdge(4, 5, 6);

        // Building an MST using Kruskal
        List<GraphEdge> mst = KruskalAlgorithm.buildMst(container);

        System.out.println("Initial MST:");
        mst.forEach(System.out::println);

        GraphEdge removed = mst.remove(2);
        System.out.println("\nRemoved edge: " + removed);

        List<Set<Integer>> components = findComponents(container.vertexCount, mst);

        System.out.println("\nComponents after removal:");
        for (Set<Integer> c : components)
            System.out.println(c);

        GraphEdge replacement = findReplacement(container, components);

        if (replacement != null) {
            mst.add(replacement);
            System.out.println("\nReplacement edge found: " + replacement);
        }

        System.out.println("\nNew MST:");
        mst.forEach(System.out::println);
    }
}