package biblioteca;

import java.util.*;
import javax.swing.JOptionPane;

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
                cadena.append(libro.getValue()).append(", copias: ").append(libro.getValue().getCopias()).append("\n");
            }
            return cadena.toString();
        }
        return "Lista vacia";
    }

    public void agregarLibro(Libro libro) {
        if (libro != null) {
            libro.setCopias(numeroCopias());
            this.libros.put(libro.getIsbn(), libro);
            System.out.println("Libro agregado con exito");
        } else {
            System.out.println("Error al agregar el libro");
        }
    }

    private int numeroCopias() {
        int copias = Integer.parseInt(JOptionPane.showInputDialog("Número de copias"));
        if (copias > 0) {
            return copias;
        }
        return numeroCopias();
    }

    public void prestarLibro(Libro libro) {
        if (libro != null && libros.containsKey(libro.getIsbn())) {
            actualizarStock(libro);
        } else {
            System.out.println("No se encontro el libro");
        }
    }

    public void actualizarLista() {
        Iterator<Map.Entry<Long, Libro>> iterador = libros.entrySet().iterator();
        while (iterador.hasNext()) {
            Map.Entry<Long, Libro> lista = iterador.next();
            Libro libro = lista.getValue();
            if (libro.getCopias() == 0) {
                iterador.remove();
            }
        }

    }

    private void actualizarStock(Libro libro) {
        if (libro.quedanCopias()) {
            libro.setCopias(- 1);
            System.out.println("El libro " + libro.getTitulo() + " fue prestado");
        } else {
            System.out.println("No quedan copias del libro " + libro.getTitulo());
            libros.remove(libro.getIsbn());
        }
    }

    public boolean estaElLibro(Libro libro) {
        return libros.containsKey(libro.getIsbn());
    }

}
