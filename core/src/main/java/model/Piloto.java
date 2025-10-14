package model;

import exception.ExceptionMayorEdad;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Piloto {
    private UUID licencia;
    private String nombre;
    private LocalDate fechaNacto;
    private String DNI;


    private Piloto(UUID licencia, String nombre, LocalDate fechaNacto, String DNI) {
        this.licencia = licencia;
        this.nombre = nombre;
        this.fechaNacto = fechaNacto;
        this.DNI = DNI;
    }

    public String getDNI(){
        return this.DNI;
    }

    public static Piloto crearPiloto(UUID licencia, String nombre, LocalDate fechaNacto, String DNI){
        //politicas mediante exceptios
        if(Piloto.getEdad(fechaNacto)<18){
            throw new ExceptionMayorEdad("El piloto debe ser mayor de edad");
        }

        return new Piloto(licencia,nombre,fechaNacto,DNI);
    }

    public static int getEdad(LocalDate fechaNacto){

        return Period.between(fechaNacto,LocalDate.now()).getYears();
    }

}
