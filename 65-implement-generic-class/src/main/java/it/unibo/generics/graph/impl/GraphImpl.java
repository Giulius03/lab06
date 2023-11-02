package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl implements Graph<String> {
    private Map<String, Set<String>> nodes;  //<nodi, nodi collegati al nodo chiave>

    public GraphImpl() {
        this.nodes = new HashMap<>();
    }

    public void addNode(final String node) {
        this.nodes.put(node, new HashSet<>());
    }

    public void addEdge(final String source, final String target) {
        this.nodes.get(source).add(target);
        this.nodes.get(target).add(source);
    }

    public Set<String> nodeSet() {
        return this.nodes.keySet();
    }

    public Set<String> linkedNodes(final String node) {
        return this.nodes.get(node);
    }

    // chi cazzo c'ha voglia
    public List<String> getPath(final String source, final String target) {
        return null;
    }
}