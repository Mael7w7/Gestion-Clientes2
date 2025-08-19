package gestion_Cliente.clienteDAO;

import gestion_Cliente.conexion.Conexion;
import gestion_Cliente.dominio.Customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimp implements IClienteDAO {
    @Override
    public List<Customers> listarclientes() {
        List<Customers> clientes = new ArrayList<>();
        PreparedStatement ps ;
        ResultSet rs ;
        Connection con = Conexion.getConnection();
        String sql = "SELECT * FROM customers ORDER BY id";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Customers cliente = new Customers();
                cliente.setId(rs.getInt("id"));
                cliente.setName(rs.getString("name"));
                cliente.setLastName(rs.getString("lastname"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
            return clientes;

        } catch (Exception e) {
            System.out.println("Error al listar clientes" + e.getMessage());
        }finally {
            try{
               con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion" + e.getMessage()+ e);
            }
        }
        return null;
    }

    @Override
    public boolean agregarcliente(Customers cliente) {
        PreparedStatement ps ;
        String sql = "INSERT INTO customers (name, lastname, email) VALUES (?, ?, ?)";
        Connection con = Conexion.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getName());
            ps.setString(2, cliente.getLastName());
            ps.setString(3, cliente.getEmail());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar cliente" + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (Exception e) {
                System.out.println("ERROR AL CERRAR DATOS" + e.getMessage());
            }
        }

        return false;
    }

    @Override
    public boolean eliminarcliente(Customers cliente) {
        PreparedStatement ps  ;
        String sql = "DELETE FROM customers WHERE id = ?";
        Connection con = Conexion.getConnection();
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("eror al eliminar cliente" + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar " + e.getMessage());
            }
        }


        return false;
    }

    @Override
    public boolean modificarcliente(Customers cliente) {
        PreparedStatement ps ;
        String sql = "UPDATE customers SET name = ? , lastname = ?, email = ? WHERE id = ?";
        Connection con = Conexion.getConnection();
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, cliente.getName());
            ps.setString(2, cliente.getLastName());
            ps.setString(3, cliente.getEmail());
            ps.setInt(4, cliente.getId());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Error al modificar cliente" + e.getMessage());
        }finally {
            try{
                con.close();

            } catch (Exception e) {
                System.out.println("Error al cerrar sesion : " +e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean buscarcliente(Customers cliente) {
        PreparedStatement ps ;
        ResultSet rs ;
        String sql = "SELECT * FROM customers WHERE id = ?";
        Connection con = Conexion.getConnection();
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setName(rs.getString("name"));
                cliente.setLastName(rs.getString("lastname"));
                cliente.setEmail(rs.getString("email"));
                ps.execute();

            }
            return true;



        } catch (Exception e) {
            System.out.println("Error al buscar cliente" + e.getMessage());
        }finally {
            try{
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerraaa buscar" + e.getMessage());
            }
        }


        return false;
    }


}
