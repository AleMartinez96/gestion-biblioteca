package biblioteca;

import java.util.Objects;

public class Autor {

    private String nombre;
    private Fecha nacimiento;
    private String nacionalidad;

    public Autor(String nombre, Fecha nacimiento, String nacionalidad) {
        this.nombre = nombre != null ? nombre : "";
        this.nacimiento = nacimiento;
        this.nacionalidad = nacionalidad != null ? nacionalidad : "";
    }

    @Override
    public String toString() {
        return "nombre: " + getNombre()
                + ", fecha de nacimiento: " + getNacimiento()
                + ", nacionalidad: " + getNacionalidad();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Fecha getNacimiento() {
        return nacimiento;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Autor otroAutor) {
            return getNombre().equals(otroAutor.getNombre());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        final int PRIME = 2;
        hash = PRIME * hash + Objects.hashCode(getNombre());
        return hash;
    }

}
