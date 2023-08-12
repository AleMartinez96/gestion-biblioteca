package biblioteca;

import java.util.Objects;

public class Libro {

    private String titulo;
    private Fecha fechaPublicacion;
    private Autor autor;
    private long isbn;
    private int edicion;
    private String formato;
    private int copias;

    public Libro(String titulo, Autor autor, Fecha fechaPublicacion, long isbn, int edicion, String formato) {
        this.titulo = titulo != null ? titulo : "sin titulo";
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.isbn = isbn;
        this.edicion = edicion;
        this.formato = formato != null ? formato : "sin formato";
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("libro: ").append(getTitulo()).append(", fecha de publicación: ")
                .append(isNull(getFechaPublicacion(), "sin fecha"))
                .append(", autor: ").append(isNull(getAutor(), "sin autor"))
                .append(", isbn: ").append(getIsbn())
                .append(", formato: ").append(getFormato()).append(", edición: ").append(getEdicion());
        return cadena.toString();
    }

    private String isNull(Object obj, String dato) {
        return obj != null ? obj.toString() : dato;
    }

    public String getTitulo() {
        return titulo;
    }

    public Fecha getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public long getIsbn() {
        return isbn;
    }

    public boolean mismoLibro(Libro otroLibro) {
        if (equals(otroLibro)) {
            boolean mismoAutor = Objects.equals(getAutor(), otroLibro.getAutor());
            boolean mismaFechaPublicacion = Objects.equals(getFechaPublicacion(), otroLibro.getFechaPublicacion());
            boolean mismaEdicion = getEdicion() == otroLibro.getEdicion();
            boolean mismoTitulo = getTitulo().equals(otroLibro.getTitulo());
            boolean mismoFormato = getFormato().equals(otroLibro.getFormato());
            return mismoAutor && mismaFechaPublicacion && mismaEdicion && mismoTitulo && mismoFormato;
        }
        return false;
    }

    public String getFormato() {
        return formato;
    }

    public long getEdicion() {
        return edicion;
    }

    public void setCopias(int copias) {
        this.copias += copias;
    }

    public int getCopias() {
        return copias;
    }

    public boolean quedanCopias() {
        return getCopias() > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Libro otroLibro) {
            return getIsbn() == otroLibro.getIsbn();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        final int PRIME = 31;
        hash = hash * PRIME + Objects.hashCode(getIsbn());
        return hash;
    }

}
