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
            actualizarDatos(libro);
        } else {
            System.out.println("No se encontro el libro");
        }
    }

    private void actualizarDatos(Libro libro) {
        if (libro.quedanCopias()) {
            agregarUsuario(libro);
            clave++;
        }
        this.libros.prestarLibro(libro);
        actualizarBiblioteca();
    }

    private void agregarUsuario(Libro libro) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
        Usuario usuario = new Usuario(nombre, clave);
        usuario.agregarLibro(libro);
        this.usuarios.put(usuario.getCodigo(), usuario);
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

    private void actualizarBiblioteca() {
        libros.actualizarLista();
    }

}
