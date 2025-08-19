package gestion_Cliente.conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
        public static Connection getConnection() {
            Connection con = null;
            String url = "jdbc:mysql://localhost:3306/gestioncliente";
            String user = "root";        // tu usuario
            String password = "admin";    // tu contraseña
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                System.out.println("Error al conectar con la base de datos" + e.getMessage());
            }
            return con;
        }

    public static void main(String[] args) {
        Connection conexion = getConnection();
        if (conexion != null) {
            System.out.println("Succesful conectar con la base de datos : " + conexion);
        }else
            System.out.println("Error al conectar con la base de datos" + conexion);
    }

}
