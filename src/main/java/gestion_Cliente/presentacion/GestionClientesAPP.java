package gestion_Cliente.presentacion;

import gestion_Cliente.clienteDAO.ClienteDAOimp;
import gestion_Cliente.clienteDAO.IClienteDAO;
import gestion_Cliente.dominio.Customers;

import java.util.List;
import java.util.Scanner;

public class GestionClientesAPP {
    public static void main(String[] args) {
        gestionAPP();
    }

    private static void gestionAPP() {
        Scanner teclado = new Scanner(System.in);
        IClienteDAO iClienteDAO = new ClienteDAOimp();
        boolean salir = true;
        do {
            int opcion = menuOpciones(teclado);
            salir = ejecutarOpciones(opcion,teclado,iClienteDAO);

        }while (salir);
    }

    private static boolean ejecutarOpciones(int opcion, Scanner teclado, IClienteDAO iClienteDAO) {
        boolean salir = true;
        switch (opcion) {
            case 1 -> {
                System.out.println("** Listado de clientes **");
                List<Customers> clientes = iClienteDAO.listarclientes();
                clientes.forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("** Agregado de clientes **");
                System.out.print("Ingrese el  Nombre del cliente : ");
                String nombre = teclado.nextLine();
                System.out.print("Ingrese el  Apellido del cliente : ");
                String apellido = teclado.nextLine();
                System.out.print("Ingrese el email del cliente : ");
                String email = teclado.nextLine();
                Customers cliente = new Customers(nombre, apellido, email);
                boolean agregar =  iClienteDAO.agregarcliente(cliente);
                if (agregar!=false) {
                    System.out.println("Cliente agregado exitosamente" + cliente);
                }else
                    System.out.println("Cliente no agregado" + cliente);

            }
            case 3 -> {
                System.out.println(" ** Eliminando cliente **");
                System.out.print("Ingrese el ID del cliente : ");
                int id = Integer.parseInt(teclado.nextLine());
                Customers cliente = new Customers(id);
                boolean eliminar =  iClienteDAO.eliminarcliente(cliente);
                if (eliminar!=false) {
                    System.out.println("Cliente eliminado exitosamente" + cliente);
                }else
                    System.out.println("Cliente no eliminado" + cliente);

            }
            case 4 -> {
                System.out.println(" ** Buscarador Cliente  por ID **");
                System.out.print("Ingrese el ID del cliente : ");
                int id = Integer.parseInt(teclado.nextLine());
                Customers cliente = new Customers(id);
                boolean buscar =  iClienteDAO.buscarcliente(cliente);
                if (buscar!=false) {
                    System.out.println("Cliente buscado exitosamente" + cliente);
                }else
                    System.out.println("Cliente no encontrado" + cliente);
            }
            case 5 -> {
                System.out.println(" ** Modificar cliente **");
                System.out.print("Ingrese el ID del cliente : ");
                int id = Integer.parseInt(teclado.nextLine());
                System.out.print("Ingrese el nombre del cliente : ");
                String nombre = teclado.nextLine();
                System.out.print("Ingrese el apellido del cliente : ");
                String apellido = teclado.nextLine();
                System.out.print("Ingrese el email del cliente : ");
                String email = teclado.nextLine();
                Customers cliente = new Customers(id, nombre, apellido, email);
                boolean modificar =  iClienteDAO.modificarcliente(cliente);
                if (modificar!=false) {
                    System.out.println("Cliente modificado exitosamente" + cliente);
                }else
                    System.out.println("Cliente no encontrado" + cliente);
            }
            case 6 -> {
                System.out.println("programaa exit ......");
                return salir =false;
            }

        }
        return salir;
    }


    private static int menuOpciones(Scanner teclado) {
        System.out.print(""" 
                ***** Menu ****
                1. Listar Clientes
                2. Agregar Clientes
                3. Eliminar Clientes
                4. Buscar Clientes ID
                5. Modificar Clientes
                Elegir una opcion : 
                """);
                return Integer.parseInt(teclado.nextLine());
    }
}
