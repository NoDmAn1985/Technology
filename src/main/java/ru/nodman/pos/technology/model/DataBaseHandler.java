package ru.nodman.pos.technology.model;

import java.sql.*;

class DataBaseHandler {
    private final String CLASS_FOR_NAME_VALUE = "org.sqlite.JDBC";
    private final String URL = "jdbc:sqlite:parser.sqlite";
    private final String MACHINES_QUERY = "SELECT\n" +
            "  T.name,\n" +
            "  M.mark,\n" +
            "  T.parametr1name,\n" +
            "  T.parameter1unit,\n" +
            "  M.parameter1value,\n" +
            "  T.parameter2name,\n" +
            "  T.parameter2unit,\n" +
            "  M.parameter2value,\n" +
            "  F.name,\n" +
            "  F.unit,\n" +
            "  M.fuel_requirement,\n" +
            "  M.note\n" +
            "FROM [mechanisms] M\n" +
            "  JOIN [types] T  ON M.type = T.id\n" +
            "  JOIN [fuels] F ON M.fuel = F.id\n" +
            "  ORDER BY T.name;";

    void loadDataBase() {
        try {
            Class.forName(CLASS_FOR_NAME_VALUE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection con = DriverManager.getConnection(URL);
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery(MACHINES_QUERY)) {

            while (resultSet.next()) {

            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

}
