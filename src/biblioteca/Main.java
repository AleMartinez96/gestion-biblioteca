package biblioteca;

public class Main {

    public static void main(String[] args) {

        Libro libro1 = new Libro("Los Juegos del Hambre", new Autor("Suzanne Collins", new Fecha(1962, 8, 10),
                "Estadounidense"), new Fecha(2008, 9, 14), 1, 1, "tapa dura");
        Libro libro2 = new Libro("El Señor de los Anillos", new Autor("J. R. R. Tolkien", new Fecha(1892, 1, 3),
                "Británico"), new Fecha(1954, 7, 29), 2, 1, "tapa dura");
        Libro libro3 = new Libro("Código Limpio", new Autor("Robert C. Martin", new Fecha(1952, 12, 5),
                "Estadounidense"), new Fecha(2008, 8, 1), 3, 1, "tapa dura");

        ListaLibros lista = new ListaLibros();
        lista.agregarLibro(libro1);
        lista.agregarLibro(libro2);
        lista.agregarLibro(libro3);
        lista.agregarLibro(null);

        Biblioteca b = new Biblioteca(lista);
        b.prestarLibro(null);

        System.out.println(b.mostrarBiblioteca());
        System.out.println(b.mostrarUsuarios());

    }
}
