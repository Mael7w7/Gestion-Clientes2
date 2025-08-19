package gestion_Cliente.clienteDAO;

import gestion_Cliente.dominio.Customers;

import java.util.List;

public interface IClienteDAO {
    List<Customers> listarclientes();
    boolean agregarcliente(Customers cliente);
    boolean eliminarcliente(Customers cliente);
    boolean modificarcliente(Customers cliente);
    boolean buscarcliente(Customers cliente);

}
