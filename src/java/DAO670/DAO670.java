package DAO670;

/**
 *
 * @author Ngọ Văn Trọng
 */

import java.sql.Connection;

public class DAO670 {
    public static Connection con;

    public DAO670() {
        if(con == null) {
            String dbUrl = "jdbc:mysql://localhost:3306/gara";
            String dbClass = "com.mysql.cj.jdbc.Driver";

            try {
                Class.forName(dbClass);
                con = java.sql.DriverManager.getConnection(dbUrl, "root", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

