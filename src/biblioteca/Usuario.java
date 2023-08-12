package biblioteca;

import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private ArrayList<Libro> misLibros;
    private int codigo;

    public Usuario(String nombre, int codigo) {
        this.nombre = nombre != null ? nombre : "sin nombre";
        this.codigo = codigo;
        this.misLibros = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "nombre: " + getNombre() + ", código: " + getCodigo() + ", mis libros: " + mostrarMisLibros();
    }

    public String mostrarMisLibros() {
        if (!misLibros.isEmpty()) {
            StringBuilder cadena = new StringBuilder();
            int i = 1;
            for (Libro libro : misLibros) {
                cadena.append(i).append("- ").append(libro).append("\n");
                i++;
            }
            return cadena.toString();
        }
        return "Lista vacia";
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void agregarLibro(Libro libro) {
        if (libro != null) {
            misLibros.add(libro);
        } else {
            System.out.println("Error al agregar el libro");
        }
    }
}
