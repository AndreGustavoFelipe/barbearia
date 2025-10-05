package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoDB {

    private Connection Conn = null;
    private Statement s = null;

    public ConexaoDB(String database) {
        try {
            Class.forName("org.postgresql.Driver");
            this.Conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+database,"postgres","postgres");
            this.s = this.Conn.createStatement();
            this.s.execute("SET search_path TO sistema");
            System.out.println("Conectado ao banco de dados: "+database);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return Conn;
    }

    public Statement getS() {
        return s;
    }
}
