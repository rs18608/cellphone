package com;

import java.sql.*;

public class dataBase {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";

    private Connection connection = getDBConnection();


    public void importCellPhoneData() throws SQLException {
        Statement stmt = connection.createStatement();

        stmt.execute("CREATE TABLE CELL_PHONES (employeeId int UNSIGNED NOT NULL, employeeName varchar(255), purchaseDate varchar(255), model varchar(255), PRIMARY KEY (employeeId));");
        stmt.execute("INSERT INTO CELL_PHONES (employeeId,employeeName,purchaseDate,model) select convert( \"employeeId\", int), \"employeeName\", \"purchaseDate\", \"model\" from CSVREAD( './data/CellPhone.csv', 'employeeId,employeeName,purchaseDate,model')");

        String sql = "SELECT * FROM CELL_PHONES";
   }

    public void importUsageData() throws SQLException {
        Statement stmt = connection.createStatement();

        stmt.execute("CREATE TABLE CELL_USAGE (employeeId int UNSIGNED NOT NULL, date varchar(255), totalMinutes varchar(255), totalData varchar(255));");
        stmt.execute("INSERT INTO CELL_USAGE (employeeId,date,totalMinutes,totalData) select convert( \"employeeId\", int), \"date\", \"totalMinutes\", \"totalData\" from CSVREAD( './data/CellPhoneUsageByMonth.csv', ' employeeId,date,totalMinutes,totalData')");

        String sql = "SELECT * FROM CELL_USAGE";
    }

    public void report() throws SQLException {

        Statement stmt = connection.createStatement();
        String sql = "SELECT cp.employeeID, cp.employeeName, cp.model, cp.purchaseDate, cu.totalMinutes, cu.totalData FROM CELL_PHONES AS cp, CELL_USAGE as cu JOIN CELL_PHONES ON cu.employeeId = cp.employeeID";
        ResultSet rs = stmt.executeQuery(sql);

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }

    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
