package input;

import model.Piloto;

import java.time.LocalDate;
import java.util.UUID;

public interface RegistrarPilotoInput {
    UUID registrarPiloto(String nombre, LocalDate fechaNacto,String DNI);
}
