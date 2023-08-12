package biblioteca;

import java.util.*;

public class ListaLibros {

    private HashMap<Long, Libro> libros;

    public ListaLibros() {
        this.libros = new HashMap<>();
    }

    @Override
    public String toString() {
        if (!libros.isEmpty()) {
            StringBuilder cadena = new StringBuilder();
            for (Map.Entry<Long, Libro> libro : libros.entrySet()) {
                Libro l = libro.getValue();
                cadena.append(l).append("\n");
            }
            return cadena.toString();
        }
        return "Lista vacia";
    }

    public void agregarLibro(Libro libro) {
        if (libro != null) {
            this.libros.put(libro.getIsbn(), libro);
            System.out.println("Libro agregado con exito");
        } else {
            System.out.println("Error al agregar el libro");
        }
    }

    public void eliminarLibro(Libro libro) {
        if (libro != null && libros.containsKey(libro.getIsbn())) {
            this.libros.remove(libro.getIsbn());
            System.out.println("El libro fue eliminado con exito");
        } else {
            System.out.println("No se encontro el libro");
        }
    }

    public boolean estaElLibro(Libro libro) {
        return libros.containsKey(libro.getIsbn());
    }

}
