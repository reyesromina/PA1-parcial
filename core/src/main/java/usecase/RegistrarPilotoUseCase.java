package usecase;

import exception.ExceptionPiloto;
import exception.ExceptionYaExistePiloto;
import input.RegistrarPilotoInput;
import model.Piloto;
import output.GuardarPiloto;

import java.time.LocalDate;
import java.util.UUID;

import static model.Piloto.crearPiloto;

public class RegistrarPilotoUseCase implements RegistrarPilotoInput {

    GuardarPiloto guardarPiloto;

    public RegistrarPilotoUseCase(GuardarPiloto guardarPiloto) {
        this.guardarPiloto=guardarPiloto;
    }

    @Override
    public UUID registrarPiloto(String nombre, LocalDate fechaNacto, String DNI) {


        if(guardarPiloto.existePiloto(DNI)){
            throw new ExceptionYaExistePiloto("Piloto ya registrado");
        }
        try {
            Piloto piloto=crearPiloto(UUID.randomUUID(),nombre,fechaNacto,DNI);

            return piloto.getLicencia();

        }catch (ExceptionPiloto e){}



        return null;
    }
}
