package usecase;

import exception.ExceptionYaExistePiloto;
import input.RegistrarPilotoInput;
import model.Piloto;
import output.GuardarPiloto;

import java.time.LocalDate;
import java.util.UUID;

public class RegistrarPilotoUseCase implements RegistrarPilotoInput {

    GuardarPiloto guardarPiloto;

    public RegistrarPilotoUseCase(GuardarPiloto guardarPiloto) {
        this.guardarPiloto=guardarPiloto;
    }

    @Override
    public UUID crearPiloto(String nombre, LocalDate fechaNacto, String DNI) {


        if(guardarPiloto.existePiloto(DNI)){
            throw new ExceptionYaExistePiloto("Piloto ya registrado");
        }
        



        return null;
    }
}
