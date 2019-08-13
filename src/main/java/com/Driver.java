package com;

import java.sql.SQLException;

public class Driver
{
    public static void main( String[] args )
    {
        dataBase db = new dataBase();
        try {
            db.importCellPhoneData();
            db.importUsageData();
            db.report();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

