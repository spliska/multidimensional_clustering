package backend.db;

import backend.models.Edge;
import backend.models.Graph;

import java.sql.*;
import java.util.ArrayList;

public class GraphService {
    public Edge[] getEdges() {
        ArrayList<Edge> edges = new ArrayList<Edge>();
        Connection connection = null;
        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:8889/clustering_db", "root", "root");
            try (Statement stmt = connection.createStatement()) {
                String selectSql = "SELECT * FROM edge";
                try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                    while (resultSet.next()) {
                        edges.add(new Edge(
                                        resultSet.getString(1),
                                        resultSet.getString(2),
                                        resultSet.getDouble(3)
                                )
                        );
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return edges.toArray(new Edge[0]);
    }

    public Graph getGraph() {

        return new Graph(new PersonService().getAllPersonsMap(), this.getEdges());

    }

}
