package biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fecha {

    private LocalDate fecha;

    public Fecha(int anio, int mes, int dia) {
        this.fecha = LocalDate.of(anio, mes, dia);
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formato.format(getFecha());
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
