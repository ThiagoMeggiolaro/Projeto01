package br.mack.ps2.Persistencias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    String url = "jdbc:mysql://localhost:3306/projeto1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String psw ="";

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, psw);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
