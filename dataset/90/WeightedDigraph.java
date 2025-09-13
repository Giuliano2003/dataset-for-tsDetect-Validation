package com.example.evosuite.advanced;

import java.util.*;

/** Grafo orientato pesato (pesi non negativi). Include Dijkstra, topologico, ciclo. */
public class WeightedDigraph {
    private final Map<String, Map<String, Double>> adj = new HashMap<>();

    public void addNode(String id) {
        if (id == null ) throw new IllegalArgumentException("id");
        adj.computeIfAbsent(id, k -> new HashMap<>());
    }

    public void addEdge(String from, String to, double weight) {
        if (weight < 0) throw new IllegalArgumentException("weight < 0");
        requireNode(from); requireNode(to);
        adj.get(from).put(to, weight);
    }

    public void removeEdge(String from, String to) {
        requireNode(from); requireNode(to);
        adj.get(from).remove(to);
    }

    public boolean hasEdge(String from, String to) {
        return adj.containsKey(from) && adj.get(from).containsKey(to);
    }

    public Set<String> nodes() { return Collections.unmodifiableSet(adj.keySet()); }

    private void requireNode(String id) {
        if (!adj.containsKey(id)) throw new IllegalArgumentException("missing node " + id);
    }

    /** Dijkstra: distanza + percorso */
    public PathResult shortestPath(String src, String dst) {
        requireNode(src); requireNode(dst);
        Map<String, Double> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        for (String v : adj.keySet()) dist.put(v, Double.POSITIVE_INFINITY);
        dist.put(src, 0.0);
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingDouble(dist::get));
        pq.add(src);
        while (!pq.isEmpty()) {
            String u = pq.poll();
            if (u.equals(dst)) break;
            for (Map.Entry<String, Double> e : adj.get(u).entrySet()) {
                String v = e.getKey();
                double nd = dist.get(u) + e.getValue();
                if (nd < dist.get(v)) {
                    dist.put(v, nd);
                    prev.put(v, u);
                    pq.remove(v); pq.add(v);
                }
            }
        }
        double d = dist.get(dst);
        if (Double.isInfinite(d)) return new PathResult(Collections.emptyList(), Double.POSITIVE_INFINITY);
        LinkedList<String> path = new LinkedList<>();
        String cur = dst;
        while (cur != null) {
            path.addFirst(cur);
            cur = prev.get(cur);
        }
        return new PathResult(path, d);
    }

    public static final class PathResult {
        public final List<String> path;
        public final double distance;
        public PathResult(List<String> path, double distance) {
            this.path = path;
            this.distance = distance;
        }
    }

    /** Verifica ciclo con DFS */
    public boolean hasCycle() {
        Map<String, Integer> color = new HashMap<>(); // 0=white,1=grey,2=black
        for (String v : adj.keySet()) color.put(v, 0);
        for (String v : adj.keySet()) {
            if (color.get(v) == 0 && dfsCycle(v, color)) return true;
        }
        return false;
    }

    private boolean dfsCycle(String u, Map<String,Integer> color) {
        color.put(u, 1);
        for (String v : adj.get(u).keySet()) {
            int c = color.getOrDefault(v, 0);
            if (c == 1) return true;
            if (c == 0 && dfsCycle(v, color)) return true;
        }
        color.put(u, 2);
        return false;
    }

    /** Ordine topologico (IllegalStateException se c'è un ciclo) */
    public List<String> topologicalOrder() {
        if (hasCycle()) throw new IllegalStateException("cycle");
        Map<String, Integer> indeg = new HashMap<>();
        for (String v : adj.keySet()) indeg.put(v, 0);
        for (Map.Entry<String, Map<String, Double>> e : adj.entrySet())
            for (String v : e.getValue().keySet())
                indeg.put(v, indeg.get(v) + 1);
        Deque<String> q = new ArrayDeque<>();
        for (Map.Entry<String, Integer> e : indeg.entrySet()) if (e.getValue() == 0) q.add(e.getKey());
        List<String> order = new ArrayList<>();
        while (!q.isEmpty()) {
            String u = q.removeFirst();
            order.add(u);
            for (String v : adj.get(u).keySet()) {
                indeg.put(v, indeg.get(v) - 1);
                if (indeg.get(v) == 0) q.addLast(v);
            }
        }
        if (order.size() != adj.size()) throw new IllegalStateException("cycle");
        return order;
    }
}
