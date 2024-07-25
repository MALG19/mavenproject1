package com.tiendamascotas.mavenproject1;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mavenproject1 {

    public static void main(String[] args) {
        System.out.println("hola profe");
            
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mavenproject1.class.getName()).log(Level.SEVERE, null, ex);
        }
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/java";
        Connection conexion;// donde se guarda la coneccion
        Statement statement;// donde guardamos el objeto para hacer consultas
        ResultSet rs; // donde guardamos los datos que trae la BD con un SELECT
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            System.out.println("Consultando Valores");
            while(rs.next()){//ciclo que valida si hay otra fila, y si la hay la obtiene
                System.out.println("id: " + rs.getInt("id") + " usuario: " + rs.getString("username"));
            }
            statement.execute("INSERT INTO usuarios (username) VALUES (\"Miguel lopez\")");
            statement.execute("INSERT INTO usuarios (username) VALUES (\"Jefferson Rico\")");
            
            rs = statement.executeQuery("SELECT * FROM usuarios");
            System.out.println("insertando valores");
            while(rs.next()){//ciclo que valida si hay otra fila, y si la hay la obtiene
                System.out.println("id: " + rs.getInt("id") + " usuario: " + rs.getString("username"));
            }
            
            statement.executeUpdate( "UPDATE usuarios SET username=\"Doris Profe\" WHERE username=\"Miguel lopez\"");
            
            rs = statement.executeQuery("SELECT * FROM usuarios");
            System.out.println("Actualizando Valores");
            while(rs.next()){//ciclo que valida si hay otra fila, y si la hay la obtiene
                System.out.println("id: " + rs.getInt("id") + " usuario: " + rs.getString("username"));
            }
            
             statement.executeUpdate( "DELETE FROM  usuarios WHERE username=\"Jefferson Rico\"");
            
            rs = statement.executeQuery("SELECT * FROM usuarios");
            System.out.println("Eliminando Valores");
            while(rs.next()){//ciclo que valida si hay otra fila, y si la hay la obtiene
                System.out.println("id: " + rs.getInt("id") + " usuario: " + rs.getString("username"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mavenproject1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
