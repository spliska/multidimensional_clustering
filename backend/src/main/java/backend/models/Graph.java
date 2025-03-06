package backend.models;

import java.util.HashMap;

public class Graph {
    HashMap<String,Person> nodes;
    Edge[] edges;

    public Graph(HashMap<String, Person> nodes, Edge[] edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public Person getPersonById(String id){
       return nodes.get(id);
    }

    public Edge[] getEdges() {
        return edges;
    }

    public HashMap<String, Person> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<String, Person> nodes) {
        this.nodes = nodes;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }
}
