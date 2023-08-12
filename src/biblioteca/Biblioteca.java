package biblioteca;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Biblioteca {

    private ListaLibros libros;
    private HashMap<Integer, Usuario> usuarios;
    private static int clave = 1;

    public Biblioteca(ListaLibros lista) {
        this.libros = lista != null ? lista : new ListaLibros();
        this.usuarios = new HashMap<>();
    }

    public void prestarLibro(Libro libro) {
        if (libro != null && libros.estaElLibro(libro)) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            Usuario usuario = new Usuario(nombre, clave);
            usuario.agregarLibro(libro);
            usuarios.put(usuario.getCodigo(), usuario);
            libros.eliminarLibro(libro);
            clave++;
            System.out.println("El libro fue prestado al usuario " + usuario.getNombre());
        } else {
            System.out.println("No se encontro el libro");
        }
    }

    public String mostrarBiblioteca() {
        return libros.toString();
    }

    public String mostrarUsuarios() {
        if (!usuarios.isEmpty()) {
            StringBuilder cadena = new StringBuilder();
            for (Map.Entry<Integer, Usuario> usu : usuarios.entrySet()) {
                cadena.append(usu.getValue()).append("\n");
            }
            return cadena.toString();
        }
        return "Lista vacia";
    }

}
