package backend.models;

public class Edge {
    String fromId;
    String toid;
    Double distance;

    public Edge(String fromId, String toid, Double distance) {
        this.fromId = fromId;
        this.toid = toid;
        this.distance = distance;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
