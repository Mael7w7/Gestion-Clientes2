package gestion_Cliente.dominio;

import java.util.Objects;

public class Customers {
    private int id;
    private String name;
    private String LastName;
    private String email;

    //contrsuctor vacio
    public Customers() {
    }
    //contructor para agregar cliente
    public Customers(String lastName, String name, String email) {
        LastName = lastName;
        this.name = name;
        this.email = email;
    }

    //contructor para eliminar
    public Customers(int id) {
        this.id = id;
    }
    //contructor para amodificar
    public Customers(int id, String name, String email, String lastName) {
        this.id = id;
        this.name = name;
        this.email = email;
        LastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return id == customers.id && Objects.equals(name, customers.name) && Objects.equals(LastName, customers.LastName) && Objects.equals(email, customers.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, LastName, email);
    }

    @Override
    public String toString() {
        return "Customers : {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
